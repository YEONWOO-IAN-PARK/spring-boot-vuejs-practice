package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	User getUserById(String userId);
	User getUserByNo(int userNo);
	void insertUser(User user);
	void updateUser(User user);
}
