package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public ResponseEntity<Map<String, Object>> todos() {
		Map<String, Object> result = new HashMap<>();
		
		List<Todo> todos = todoRepository.findAll();
		if (!todos.isEmpty()) {
			result.put("status", "ok");
			result.put("rows", todos.size());
			result.put("items", todos);
		
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			result.put("status", "empty");
			result.put("rows", 0);
			result.put("items", List.of());
		
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
}
