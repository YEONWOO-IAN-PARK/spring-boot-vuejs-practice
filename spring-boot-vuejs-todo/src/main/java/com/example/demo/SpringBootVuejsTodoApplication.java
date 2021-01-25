package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Board;
import com.example.demo.repository.BoardRepository;

@SpringBootApplication
public class SpringBootVuejsTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsTodoApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertSampleData(BoardRepository boardRepository) {
		return args -> {
			for (int i=1; i<50; i++) {
				boardRepository.save(Board.builder().title("제목-" + i).writer("작성자-" + i).content("내용-" + i).likes(i).isDisabled(false).createdDate(new Date()).build());
			}
		};
	}
}
