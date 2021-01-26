package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;

@SpringBootApplication
public class SpringBootVuejsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVuejsCrudApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner insetSampleData(TutorialRepository repo) {
		return args -> {
			for (int i=1; i<=10; i++) {
				repo.save(Tutorial.builder().title("제목-" + i).description("내용-"+ i).published(false).build());
			}
		};
	}

}
