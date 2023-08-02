package com.esercizio6_spring.esercizio6_spring.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdatePayload {

	private String username;
	private String nomeCompleto;
	private String email;

}
