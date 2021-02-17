package com.example.demo.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<T> {

	ResponseDataStatus status;
	int rows;
	List<T> items;
	String message;
	
	@Builder
	public ResponseData(ResponseDataStatus status, int rows, List<T> items, String message) {
		super();
		this.status = status;
		this.rows = rows;
		this.items = items;
		this.message = message;
	}



	public enum ResponseDataStatus {
		OK, EMPTY, NOTFOUND, FAIL;
	}
}
