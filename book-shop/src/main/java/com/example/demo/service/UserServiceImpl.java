package com.example.demo.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User insertUser(User user) {
		User savedUser = userMapper.getUserById(user.getId());
		if (savedUser != null) {
			throw new IncorrectResultSizeDataAccessException(0, 1);
		}
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
		userMapper.insertUser(user);
		return user;
	}
}
