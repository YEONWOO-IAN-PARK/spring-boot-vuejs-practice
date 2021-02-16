package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.TodoRepository;

@SpringBootApplication
public class TodoVueRouterApplication {

	@Autowired
	TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoVueRouterApplication.class, args);
	}

}
