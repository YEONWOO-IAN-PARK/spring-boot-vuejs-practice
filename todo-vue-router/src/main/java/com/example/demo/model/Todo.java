package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "todos")
@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TODO_ID")
	long id;
	
	@Column(name = "TODO_USERNAME")
	String username;
	
	@Column(name = "TODO_TITLE")
	String title;
	
	@Column(name = "TODO_DESCRIPTION")
	String description;
	
	@Column(name = "TODO_DUE_DATE")
	LocalDate dueDate;
	
	@Column(name = "TODO_STATUS")
	TodoStatus status;
	
	@Column(name = "TODO_REGISTERED_DATE")
	LocalDate registeredDate;
	
	@Column(name = "TODO_COMPLETED_DATE")
	LocalDate completedDate;
	
	@Column(name = "TODO_DELETED_DATE")
	LocalDate deletedDate;
	
	enum TodoStatus {
		COMPLETED, DELETED, DELAYED, REGISTERED;
	}
}
