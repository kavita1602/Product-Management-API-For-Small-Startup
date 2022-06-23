package com.javaguides.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	private static final long SerialVersionUID = 1L;	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable  ) {
		super(message , throwable);
	}


}
