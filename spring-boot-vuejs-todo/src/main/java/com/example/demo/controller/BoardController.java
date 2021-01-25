package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Board;
import com.example.demo.repository.BoardRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/boards")
	public ResponseEntity<List<Board>> list() {
		List<Board> boards = new ArrayList<>();
		boardRepository.findAll().forEach(boards::add);
		return new ResponseEntity<>(boards, HttpStatus.OK);
	}
}
