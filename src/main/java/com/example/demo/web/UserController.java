package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/list")
	public List hi() {
		return userDao.list();
	}
	
	@PostMapping("/add")
	public int add(User user) {
		return userDao.add(user);
	}
}
