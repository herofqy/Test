package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.User;

import net.bytebuddy.utility.RandomString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Test
	public void test() throws Exception {
		RandomString rs = new RandomString(4);
		stringRedisTemplate.opsForValue().set("k1",rs.nextString());
		logger.info(stringRedisTemplate.opsForValue().get("k1"));
		logger.info(stringRedisTemplate.opsForValue().size("k1").toString());
		logger.info("_________________________");
		
		redisTemplate.opsForValue().set("k2", new User(rs.nextString()));
		logger.info(redisTemplate.opsForValue().get("k2").toString());
		logger.info(redisTemplate.opsForValue().size("k2").toString());
		logger.info("_________________________");
		
		stringRedisTemplate.opsForValue().set("k1",rs.nextString(),4);
		logger.info(stringRedisTemplate.opsForValue().get("k1"));
		logger.info(stringRedisTemplate.opsForValue().size("k1").toString());
		logger.info("_________________________");
		
		stringRedisTemplate.opsForList().rightPush("l1", "l1i0");
		stringRedisTemplate.opsForList().rightPush("l1", "l1i1");
		logger.info(stringRedisTemplate.opsForList().leftPop("l1"));
		logger.info(stringRedisTemplate.opsForList().leftPop("l1", 10, TimeUnit.SECONDS));
	}
}
