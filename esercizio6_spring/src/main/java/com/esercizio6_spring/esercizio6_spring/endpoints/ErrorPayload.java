package com.esercizio6_spring.esercizio6_spring.endpoints;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorPayload {

	private String message;
	private LocalDate timestamp;

}
