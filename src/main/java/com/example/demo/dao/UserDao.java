package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
@SuppressWarnings("rawtypes")
public class UserDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List list() {
		return jdbcTemplate.queryForList("SELECT * FROM user");
	}
	
	public int add(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO user (NAME,GENDER,BIRTHDAY,PROFILE) VALUES (")
		.append(user.getName())
		.append(user.getGender())
		.append(user.getBirthday())
		.append(user.getProfile())
		.append(")");
		return jdbcTemplate.update(sql.toString());
	}
}
