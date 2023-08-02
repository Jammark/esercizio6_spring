package com.esercizio6_spring.esercizio6_spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.esercizio6_spring.esercizio6_spring.model.Edificio;
import com.esercizio6_spring.esercizio6_spring.model.Postazione;
import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;
import com.esercizio6_spring.esercizio6_spring.model.User;
import com.github.javafaker.Faker;

@Configuration
public class AppConfig {

	@Bean
	public Faker getFaker() {
		return new Faker();
	}

	@Bean
	@Scope("prototype")
	public Edificio getEdificio() {
		return new Edificio(getFaker().address().city(), getFaker().address().fullAddress(),
				"Edificio-" + getFaker().address().buildingNumber());
	}

	@Bean
	@Scope("prototype")
	public Postazione getPostazione() {
		int index = new Random().nextInt(3);
		return new Postazione(getFaker().lorem().characters(), TipoPostazione.values()[index],
				new Random().nextInt(1, 20));
	}

	@Bean
	public List<Edificio> getEdifici() {
		return new ArrayList<>(Arrays.asList(getEdificio(), getEdificio(), getEdificio()));
	}

	@Bean
	public List<Postazione> getPostazioni() {
		return new ArrayList<Postazione>(
				Arrays.asList(getPostazione(), getPostazione(), getPostazione(), getPostazione()));
	}

	@Bean
	public List<User> getUsers() {
		return new ArrayList<>(Arrays.asList(getUser(), getUser(), getUser(), getUser()));
	}

	@Bean
	@Scope("prototype")
	public User getUser() {
		return new User(getFaker().name().username(), getFaker().name().fullName(),
				getFaker().internet().emailAddress());
	}

}
