package com.Mitanand.CRUD.DTO;

public class ApiResponse {
	
	private String message;
	private boolean done;
	
	
	//constructors
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApiResponse(String message, boolean done) {
		super();
		this.message = message;
		this.done = done;
	}


	//getters and setters
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

	
	
	
	
	
	

}
