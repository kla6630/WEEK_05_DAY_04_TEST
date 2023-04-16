package it.w5.d4.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.w5.d4.enums.ElencoEdifici;

import it.w5.d4.model.Edificio;

@Configuration
@PropertySource("classpath:application.properties")
public class EdificioConfiguration {

	@Bean("ParametriEdificio")
	@Scope("prototype")
	public Edificio parametriEdificio(String nome, String indirizzo, String citta) {
		return new Edificio(nome, indirizzo, citta);
	}

	@Bean("EdificioFake")
	@Scope("prototype")
	public Edificio edificioFake() {
		Faker f = Faker.instance(new Locale("it-IT"));
		Edificio e = new Edificio();
		e.setNome(f.company().name());
		e.setIndirizzo(f.address().streetAddress());
		e.setCitta(f.address().city());
		return e;
	}

//EDIFICI PERSONALIZZATI//	

//	// EDIFICIO 01//
//
//	@Bean("Edificio01")
//	@Scope("prototype")
//	public Edificio Edificio01() {
//		Edificio e = new Edificio();
//		e.setId(01l);
//		e.setIndirizzo("Via dei lecci 500");
//		e.setCitta("Rovigo");
//		e.setElencoedifici(ElencoEdifici.EDIFICIO_01);
//
//		return e;
//	}
//
//	// EDIFICIO 02//
//
//	@Bean("Edificio02")
//	@Scope("prototype")
//	public Edificio Edificio02() {
//		Edificio e = new Edificio();
//		e.setId(02l);
//		e.setIndirizzo("Via delle Angurie 60");
//		e.setCitta("Sulmona");
//		e.setElencoedifici(ElencoEdifici.EDIFICIO_02);
//
//		return e;
//	}
//
//	// EDIFICIO 03//
//
//	@Bean("Edificio01")
//	@Scope("prototype")
//	public Edificio Edificio03() {
//		Edificio e = new Edificio();
//		e.setId(03l);
//		e.setIndirizzo("Via Ziggurat 12");
//		e.setCitta("Pretoria");
//		e.setElencoedifici(ElencoEdifici.EDIFICIO_03);
//
//		return e;
//
//	}

}
