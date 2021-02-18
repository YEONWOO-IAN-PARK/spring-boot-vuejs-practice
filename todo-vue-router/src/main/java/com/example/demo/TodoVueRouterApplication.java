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
			todoRepository.save(Todo.builder().title("프로젝트 회의").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 15)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 1, 14)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("전산용품 구매").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 25)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 1, 17)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("외주인력 계약연장건").description("연습입니다.").dueDate(LocalDate.of(2021, 1, 31)).status(TodoStatus.DELETED).deletedDate(LocalDate.of(2021, 1, 18)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("팀별 회의 참석").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 4)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 2, 4)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신규 사업 보고").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 6)).status(TodoStatus.DELETED).deletedDate(LocalDate.of(2021, 2, 5)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("유지보수 일정 잡기").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 10)).status(TodoStatus.COMPLETED).completedDate(LocalDate.of(2021, 2, 9)).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신입사원 교육").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 15)).status(TodoStatus.DELAYED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("인사발령").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 19)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("신입사원 교육 준비").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 20)).status(TodoStatus.REGISTERED).username("홍길동").build());
			todoRepository.save(Todo.builder().title("부서별 구매물품 확인").description("연습입니다.").dueDate(LocalDate.of(2021, 2, 26)).status(TodoStatus.REGISTERED).username("홍길동").build());
		};
	}

}
