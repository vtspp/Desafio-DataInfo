package com.DataInfo.Api.error;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ErrorNotFound extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;

	public ErrorNotFound(String msg) {
		super(msg);
	}

}
