package com.esercizio6_spring.esercizio6_spring.endpoints;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestoreErrori {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorPayload handle(IllegalArgumentException e) {
		return new ErrorPayload(e.getMessage(), LocalDate.now());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorPayload handle(Exception e) {
		return new ErrorPayload(e.getMessage(), LocalDate.now());
	}

}
