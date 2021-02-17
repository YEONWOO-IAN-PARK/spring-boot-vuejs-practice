package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Todo;
import com.example.demo.model.Todo.TodoStatus;
import com.example.demo.repository.TodoRepository;

@SpringBootApplication
public class TodoVueRouterApplication {

	@Autowired
	TodoRepository todoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoVueRouterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insertSampleTodo(TodoRepository todoRepository) {
		return args -> {
			todoRepository.save(Todo.builder().title("연습1").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 21)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습2").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 22)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습3").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 23)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습4").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 24)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습5").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 25)).status(TodoStatus.REGISTERED).username("홍길동").build());
		};
	}

}
