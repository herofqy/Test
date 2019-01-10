package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbctTests {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testUser() {
		List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from user");
		list.forEach(System.out::println);
	}
}
