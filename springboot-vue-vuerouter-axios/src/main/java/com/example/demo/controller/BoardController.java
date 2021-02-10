package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Board;
import com.example.demo.repository.BoardRepository;

import lombok.extern.log4j.Log4j2;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Log4j2
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/boards")
	public ResponseEntity<Map<String, Object>> getBoards(@RequestParam(name = "keyword", required = false) String keyword,
			Pageable pageable) {
		Map<String, Object> response = new HashMap<>();
		Page<Board> page = Page.empty();
		try {
			if (keyword != null) {
				page =boardRepository.findByTitleContaining(keyword, pageable);
			} else {
				page = boardRepository.findAll(pageable);
			}
			response.put("rows", page.getTotalElements());
			response.put("totalPages", page.getTotalPages());
			response.put("page", page.getPageable().getPageNumber());
			response.put("items", page.getContent());
			response.put("status", "ok");
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			response.put("status", "fail");
			response.put("message", "Server Error");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping("/boards/{id}")
	public ResponseEntity<Map<String, Object>> getBoard(@PathVariable(name = "id") long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Optional<Board> optionalBoard = boardRepository.findById(id);
			if (optionalBoard.isPresent()) {
				Board board = optionalBoard.get();
				board.setReadCount(board.getReadCount() + 1);
				boardRepository.save(board);
				
				response.put("status", "ok");
				response.put("data", optionalBoard.get());
			} else {
				response.put("status", "fail");
				response.put("message", "Not Found data");
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			response.put("status", "fail");
			response.put("message", "Server Error");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@PostMapping("/boards")
	public ResponseEntity<Map<String, Object>> saveBoard(@RequestBody Board board) {
		Map<String, Object> response = new HashMap<>();
		try {
			response.put("status", "ok");
			response.put("data", boardRepository.save(board));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			response.put("status", "fail");
			response.put("message", "Server Error");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@PutMapping("/boards/{id}")
	public ResponseEntity<Map<String, Object>> updateBoard(@PathVariable(name = "id") long id,
			@RequestBody Board board) {
		Map<String, Object> response = new HashMap<>();
		try {
			Optional<Board> optionalBoard = boardRepository.findById(id);
			if (optionalBoard.isEmpty()) {
				response.put("status", "fail");
				response.put("message", "Not found data");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Board updatedBoard = optionalBoard.get();
			updatedBoard.setTitle(board.getTitle());
			updatedBoard.setWriter(board.getWriter());
			updatedBoard.setContent(board.getContent());
			updatedBoard.setReadCount(board.getReadCount());
			
			response.put("status", "ok");
			response.put("data", boardRepository.save(updatedBoard));
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			response.put("status", "fail");
			response.put("message", "Server Error");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/boards/{id}")
	public ResponseEntity<Map<String, Object>> deleteBoard(@PathVariable(name = "id") long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			boardRepository.deleteById(id);
			response.put("status", "ok");
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			
			response.put("status", "fail");
			response.put("message", "Server Error");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
}
