package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "boards")
@Data
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "board_id")
	private long id;
	
	@Column(name = "board_title")
	private String title;
	
	@Column(name = "board_writer")
	private String writer;
	
	@Column(name = "board_content")
	private String content;
	
	@Column(name = "board_read_count")
	private int readCount;
	
	@Column(name = "board_created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Builder
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
}
