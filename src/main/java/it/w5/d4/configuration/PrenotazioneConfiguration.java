package it.w5.d4.configuration;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.w5.d4.model.Postazione;
import it.w5.d4.model.Prenotazione;
import it.w5.d4.model.Utente;

@Configuration
public class PrenotazioneConfiguration {

	@Bean("Reservation")
	@Scope("prototype")
	public Prenotazione prenotazione(Utente utente, Postazione postazione, LocalDate data) {
		return new Prenotazione(utente, postazione, data);
	}
}
