package com.example.demo.model;

import lombok.Getter;

@Getter
public class Pagination {

	private int rowsPerPage;
	private int pagesPerBlock;
	private int page;
	private int block;
	private int rows;
	private int pages;
	private int blocks;
	private int begin;
	private int end;
	
	public Pagination(int page, int rows) {
		this(page, rows, 5, 5);
		init();
	}
	
	public Pagination(int page, int rows, int rowsPerPage) {
		this(page, rows, rowsPerPage, 5);
		init();
	}
	
	public Pagination(int page, int rows, int rowsPerPage, int pagesPerBlock) {
		this.page = page;
		this.rows = rows;
		this.rowsPerPage = rowsPerPage;
		this.pagesPerBlock = 5;
		init();
	}
	
	private void init() {
		this.pages = (int) (Math.ceil((double)rows/rowsPerPage));
		this.blocks = (int) (Math.ceil((double)pages/pagesPerBlock));
		if (page <= 0 || page > pages) {
			this.page = 1;
		}
		this.block = (int) (Math.ceil((double)page/pagesPerBlock));
		this.begin = (block - 1)*pagesPerBlock + 1;
		this.end = block*pagesPerBlock;
		if (block == blocks) {
			this.end = pages;
		}
	}
}
