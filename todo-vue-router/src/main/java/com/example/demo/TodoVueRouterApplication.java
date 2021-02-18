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
			todoRepository.save(Todo.builder().title("연습1").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 15)).status(TodoStatus.COMPLETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습2").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 25)).status(TodoStatus.COMPLETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습3").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 31)).status(TodoStatus.DELETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습4").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 4)).status(TodoStatus.COMPLETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습5").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 6)).status(TodoStatus.DELETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습6").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 10)).status(TodoStatus.COMPLETED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습7").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 15)).status(TodoStatus.DELAYED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습8").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 19)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습9").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 20)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("연습10").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 26)).status(TodoStatus.REGISTERED).username("홍길동").build());
		};
	}

}
