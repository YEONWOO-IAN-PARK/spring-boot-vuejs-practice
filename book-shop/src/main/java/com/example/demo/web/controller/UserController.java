package com.example.demo.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<Map<String, Object>> saveUser(@RequestBody User userFormData) {
		Map<String, Object> result = new HashMap<>();

		try {
			User _user = new User();
			_user.setName(userFormData.getName());
			_user.setId(userFormData.getId());
			_user.setPassword(userFormData.getPassword());
			_user.setTel(userFormData.getTel());
			_user.setEmail(userFormData.getEmail());
			
			User user = userService.insertUser(_user);
			
			result.put("status", "ok");
			result.put("user", user);
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (DataAccessException e) {
			e.printStackTrace();
			result.put("status", "fail");
			result.put("errorMessage", "이미 사용중인 아이디입니다.");
			
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
}
