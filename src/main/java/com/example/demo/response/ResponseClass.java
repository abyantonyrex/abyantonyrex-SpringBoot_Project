package com.example.demo.response;

public class ResponseClass<T> {
	
	private String Message;
	private boolean Status;
	private T Data;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	public ResponseClass(String message, boolean status, T data) {
		super();
		this.Message = message;
		this.Status = status;
		this.Data = data;
	}
	

}
