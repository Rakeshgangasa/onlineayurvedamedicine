package com.cg.oam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AppUserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;       
	public  AppUserAlreadyExistsException()
	{
     super();
    }
	public AppUserAlreadyExistsException(String message) {
        super(message);

    }
}