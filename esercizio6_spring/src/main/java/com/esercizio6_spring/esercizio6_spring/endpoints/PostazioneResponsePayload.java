package com.esercizio6_spring.esercizio6_spring.endpoints;

import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostazioneResponsePayload {

	private Long id;
	private Long edificioId;
	private String descrizione;

	private TipoPostazione tipo;

	private int maxOccupanti;

}
