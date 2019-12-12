package com.mindtree.hospitalManagementSystem.exception;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleApplicationException(final ApplicationException exception,
			HttpServletRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorMessage(exception.getMessage());
		exceptionResponse.setRequestUrl(request.getRequestURI());
		return exceptionResponse;
	}
}
