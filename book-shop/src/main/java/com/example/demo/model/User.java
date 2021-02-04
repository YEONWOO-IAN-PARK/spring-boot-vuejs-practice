package com.example.demo.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

	private int no;
	private String name;
	private String id;
	private String password;
	private String email;
	private String tel;
	private int availablePoint;
	private String status;
	private Date createdDate;
}
