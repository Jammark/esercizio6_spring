package com.esercizio6_spring.esercizio6_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.esercizio6_spring.esercizio6_spring.model.Edificio;
import com.esercizio6_spring.esercizio6_spring.service.EdificioService;

public class AppRunner implements CommandLineRunner {

	@Autowired
	private EdificioService eSrv;

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				Esercizio6SpringApplication.class);

		List<Edificio> lista = (List<Edificio>) ctx.getBean("getEdifici");
		lista.stream().filter(eSrv::exists).forEach(eSrv::save);

		ctx.close();

	}

}
