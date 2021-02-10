package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Board;
import com.example.demo.repository.BoardRepository;

@SpringBootApplication
public class SpringbootVueVuerouterAxiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootVueVuerouterAxiosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initBoards(BoardRepository repository) {
		return args -> {
			for (int i=1; i<=50; i++) {
				repository.save(Board.builder().title("연습" + i).writer("관리자" + i).content("연습" + 1).build());
			}
		};
	}

}
