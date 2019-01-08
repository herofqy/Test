package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="test-prop")
public class TestProp {
	String string;
	@Value("${test-prop.string}")
	String string2;
	Integer integer;
	Date date;
	List list;
	Map map;
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public Integer getInteger() {
		return integer;
	}
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "TestProp [string=" + string + ", string2=" + string2 + ", integer=" + integer + ", date=" + date
				+ ", list=" + list + ", map=" + map + "]";
	}
	
}
