package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TodoForm {

	private long id;
	private String username;
	private String title;
	private LocalDate dueDate;
	private String description;
}
