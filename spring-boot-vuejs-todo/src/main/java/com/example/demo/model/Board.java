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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boards")

@Getter
@Setter
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_no")
	private Long id;
	
	@Column(name = "board_title", length = 200, nullable = false)
	private String title;
	
	@Column(name = "board_writer", length = 100, nullable = false)
	private String writer;
	
	@Column(name = "board_content", length = 1000, nullable = false)
	private String content;
	
	@Column(name = "board_likes")
	private int likes;
	
	@Column(name = "board_disabled")
	private boolean isDisabled;
	
	@Column(name = "board_created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "board_updated_date")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name = "board_deleted_date")
	@Temporal(TemporalType.DATE)
	private Date deletedDate;

	@Builder
	public Board(String title, String writer, String content, int likes, boolean isDisabled, Date createdDate) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.likes = likes;
		this.isDisabled = isDisabled;
		this.createdDate = createdDate;
	}
}
