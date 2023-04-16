package it.w5.d4.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import it.w5.d4.model.Utente;

@Configuration
@PropertySource("classpath:application.properties")
public class UtenteConfiguration {

	@Bean("Utente")
	@Scope("prototype")
	public Utente parametriUtente(String nomeutente, String nome, String cognome, String citta, String email) {
		return new Utente(nomeutente, nome, cognome, citta, email);
	}

	@Bean("UtenteFake")
	@Scope("prototype")
	public Utente utenteFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Utente u = new Utente();
		u.setNomeutente(u.getCognome() + "." + u.getNome() + "0");
		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setCitta(fake.address().cityName());
		u.setEmail(u.getNome() + "." + u.getCognome() + "@dominio.com");
		return u;
	}

}
