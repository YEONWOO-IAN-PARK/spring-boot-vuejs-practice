package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.model.Book;

public interface BookService {

	int getTotalRows(Map<String, Object> condition);
	List<Book> getBooks(Map<String, Object> condition);
	Book getBook(int bookNo);
}
