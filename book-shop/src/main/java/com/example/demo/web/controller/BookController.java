package com.example.demo.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.model.Pagination;
import com.example.demo.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {
	
	int ROWS_PER_PAGE = 5;
	int PAGES_PER_BLOCK = 5;

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<Map<String, Object>> getBooks(@RequestParam(name = "page", required = false, defaultValue = "1") int page) {
		Map<String, Object> condition = new HashMap<>();
		condition.put("begin", (page - 1)*ROWS_PER_PAGE + 1);
		condition.put("end", page*ROWS_PER_PAGE);
		
		int rows = bookService.getTotalRows(condition);
		List<Book> books = bookService.getBooks(condition);
		
		Pagination pagination = new Pagination(page, rows);
		
		Map<String, Object> result = new HashMap<>();
		result.put("status", "ok");
		result.put("page", pagination);
		result.put("items", books);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/books/{no}")
	public ResponseEntity<Map<String, Object>> getBook(@PathVariable("no") int bookNo) {
		Book book = bookService.getBook(bookNo);
		
		Map<String, Object> result = new HashMap<>();
		result.put("status", "ok");
		result.put("items", List.of(book));
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
