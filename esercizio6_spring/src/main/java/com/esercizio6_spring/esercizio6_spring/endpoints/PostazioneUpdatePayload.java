package com.esercizio6_spring.esercizio6_spring.endpoints;

import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostazioneUpdatePayload {

	private Long edificiorId;
	private String descrizione;

	private TipoPostazione tipo;

	private int maxOccupanti;

}
