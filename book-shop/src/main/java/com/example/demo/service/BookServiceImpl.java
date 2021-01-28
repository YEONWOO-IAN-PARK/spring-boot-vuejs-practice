package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public int getTotalRows(Map<String, Object> condition) {
		return bookMapper.getTotalRows(condition);
	}
	
	@Override
	public List<Book> getBooks(Map<String, Object> condition) {
		return bookMapper.getBooks(condition);
	}
	
	@Override
	public Book getBook(int bookNo) {
		return bookMapper.getBookByNo(bookNo);
	}
}
