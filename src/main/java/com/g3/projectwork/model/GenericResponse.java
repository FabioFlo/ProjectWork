package com.g3.projectwork.model;

public class GenericResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GenericResponse [message=" + message + "]";
	}
	
	
}
