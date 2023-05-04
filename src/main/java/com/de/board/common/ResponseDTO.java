package com.de.board.common;

import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.de.board.post.dto.PostDTO;

public class ResponseDTO {
	
	private int status;
	private String message;
	private Object data;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	private ResponseDTO(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	private ResponseDTO(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public static ResponseDTO of(HttpStatus httpStatus, String message) {
		int status = Optional.ofNullable(httpStatus).orElse(httpStatus.OK).value();
		
		return new ResponseDTO(status, message);
	}
	
	public static ResponseDTO of(HttpStatus httpStatus, String message, Object data) {
		int status = Optional.ofNullable(httpStatus).orElse(httpStatus.OK).value();
		
		return new ResponseDTO(status, message, data);
	}

}
