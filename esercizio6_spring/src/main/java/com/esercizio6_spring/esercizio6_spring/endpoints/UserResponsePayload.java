package com.esercizio6_spring.esercizio6_spring.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserResponsePayload {

	private Long id;
	private String username;
	private String nomeCompleto;
	private String email;
}
