package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;

@Mapper
public interface BookMapper {

	int getTotalRows(Map<String, Object> codition);
	List<Book> getBooks(Map<String, Object> condition);
}
