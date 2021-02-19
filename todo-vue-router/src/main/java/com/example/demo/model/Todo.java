package com.example.demo.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
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
	@Enumerated(EnumType.STRING)
	TodoStatus status;
	
	@Column(name = "TODO_REGISTERED_DATE")
	LocalDate registeredDate;
	
	@Column(name = "TODO_COMPLETED_DATE")
	LocalDate completedDate;
	
	@Column(name = "TODO_DELETED_DATE")
	LocalDate deletedDate;
	
	@Builder
	public Todo(String username, String title, String description, LocalDate dueDate, TodoStatus status,
			LocalDate registeredDate, LocalDate completedDate, LocalDate deletedDate) {
		super();
		this.username = username;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.registeredDate = registeredDate;
		this.completedDate = completedDate;
		this.deletedDate = deletedDate;
	}
	
	public int getDelayedDays() {
		return Period.between(dueDate, LocalDate.now()).getDays();
	}

	public enum TodoStatus {
		COMPLETED, DELETED, DELAYED, REGISTERED;
	}
}
