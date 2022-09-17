package com.cg.oam.exception;


import org.springframework.web.bind.annotation.ResponseStatus;

public class AppUserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppUserNotFoundException() {
		super();
	}

	public AppUserNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}