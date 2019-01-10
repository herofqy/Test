package com.example.demo.web;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@ServerEndpoint("/ws")
public class WebSocketHeadler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketHeadler.class);
	
	private static AtomicInteger count = new AtomicInteger();
	
	private static ConcurrentHashMap<String, Session> wsMap = new ConcurrentHashMap<>();
	
	@OnOpen
	public void onOpen(Session session) throws IOException {
		wsMap.put(session.getId(), session);
		LOGGER.info("有新连接加入！当前在线人数为:"+count.incrementAndGet());
		session.getBasicRemote().sendText(session.getId()+"来啦!人数:"+count.get());
	}
	
	@OnClose
	public void onClose(Session session) throws IOException {
		wsMap.remove(session.getId());
		LOGGER.info("有连接离线！当前在线人数为:"+count.decrementAndGet());
		sendAll(session.getId()+"跑了!人数:"+count.get());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		LOGGER.info("有新消息:"+message);
		sendAll(session.getId()+"说: "+message);
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
        LOGGER.error("ws Err!",error);
    }
	
	private void sendAll(String msg) {
		wsMap.forEach((k,v) -> {
			try {
				v.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				LOGGER.error("WebSocketHeadler:",e);
			}
		});
	}
}
