package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseData;
import com.example.demo.dto.ResponseData.ResponseDataStatus;
import com.example.demo.form.TodoForm;
import com.example.demo.model.Todo;
import com.example.demo.model.Todo.TodoStatus;
import com.example.demo.repository.TodoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public ResponseEntity<ResponseData<Todo>> getTodos() {
		ResponseData<Todo> responseData = new ResponseData<>();
		
		List<Todo> todos = todoRepository.findAll();
		if (!todos.isEmpty()) {
			responseData.setStatus(ResponseDataStatus.OK);
			responseData.setRows(todos.size());
			responseData.setItems(todos);
		
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			responseData.setStatus(ResponseDataStatus.EMPTY);
			responseData.setItems(List.of());
		
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
	}
	
	@GetMapping("/todos/{id}")
	public ResponseEntity<ResponseData<Todo>> getTodo(@PathVariable("id") long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		ResponseData<Todo> responseData = new ResponseData<>();
		if (todo.isPresent()) {
			responseData.setStatus(ResponseDataStatus.OK);
			responseData.setRows(1);
			responseData.setItems(List.of(todo.get()));
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			responseData.setStatus(ResponseDataStatus.NOTFOUND);
			responseData.setMessage("아이디와 일치하는 작업정보를 찾을 수 없습니다.");
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Void> insertTodo(@RequestBody Todo todo) {
		todo.setStatus(TodoStatus.REGISTERED);
		todo.setRegisteredDate(LocalDate.now());
		todoRepository.save(todo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<ResponseData<Object>> updateTodo(@PathVariable("id") long id, @RequestBody TodoForm todoForm) {
		ResponseData<Object> responseData = new ResponseData<>();

		Optional<Todo> savedTodo = todoRepository.findById(id);
		if (savedTodo.isPresent()) {
			Todo todo = savedTodo.get();
			BeanUtils.copyProperties(todoForm, todo);
			todoRepository.save(todo);

			responseData.setStatus(ResponseDataStatus.OK);
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			responseData.setStatus(ResponseDataStatus.NOTFOUND);
			responseData.setMessage("아이디와 일치하는 작업정보를 찾을 수 없습니다.");
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
	}
	
	@PutMapping("/todos/{id}/{status}")
	public ResponseEntity<ResponseData<Object>> deleteTodo(@PathVariable("id") long id,
			@PathVariable("status") String status) {
		ResponseData<Object> responseData = new ResponseData<>();
		
		Optional<Todo> savedTodo = todoRepository.findById(id);
		if (savedTodo.isPresent()) {
			Todo todo = savedTodo.get();
			todo.setStatus(TodoStatus.valueOf(status));
			if (todo.getStatus() == TodoStatus.COMPLETED) {
				todo.setCompletedDate(LocalDate.now());
			} else if (todo.getStatus() == TodoStatus.DELETED) {
				todo.setDeletedDate(LocalDate.now());
			}
			todoRepository.save(savedTodo.get());
			
			responseData.setStatus(ResponseDataStatus.OK);
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} else {
			responseData.setStatus(ResponseDataStatus.NOTFOUND);
			responseData.setMessage("아이디와 일치하는 작업정보를 찾을 수 없습니다.");
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
	}
}
