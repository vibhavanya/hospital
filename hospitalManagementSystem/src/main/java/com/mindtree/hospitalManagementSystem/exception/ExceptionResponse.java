package com.mindtree.hospitalManagementSystem.exception;

public class ExceptionResponse {
	private String errorMessage;
	private String requestUrl;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
}
