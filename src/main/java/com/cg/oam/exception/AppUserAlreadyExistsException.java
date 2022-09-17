package com.cg.oam.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

public class AppUserAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppUserAlreadyExistsException() {
		super();
	}

	public AppUserAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}

}