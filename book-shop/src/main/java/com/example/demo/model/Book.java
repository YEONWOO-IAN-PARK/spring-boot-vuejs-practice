package com.example.demo.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

	private int no;
	private int categoryNo;
	private String title;
	private String writer;
	private String translator;
	private String publisher;
	private Date pubDate;
	private int stock;
	private String status;
	private int price;
	private int salePrice;
	private double discountRate;
	private int savePoint;
	private double reviewPoint;
	private int reviewCount;
	private String bestseller;
	private String freeDelivery;
	private Date createdDate;
}
