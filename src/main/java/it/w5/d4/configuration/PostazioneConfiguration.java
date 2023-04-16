package it.w5.d4.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.w5.d4.enums.ElencoEdifici;
import it.w5.d4.enums.StatoPostazione;
import it.w5.d4.enums.TipoPostazione;
import it.w5.d4.model.Edificio;
import it.w5.d4.model.Postazione;

@Configuration
public class PostazioneConfiguration {

	@Bean("Station")
	@Scope("prototype")

	public Postazione parametriPostazione(String descrizione, TipoPostazione tipopostazione, Integer numMaxPosti,
			Edificio edificio) {
		return new Postazione();

	}

	@Bean("Postazione_Fake")
	@Scope("prototype")
	public Postazione fakeStation() {
		Faker f = Faker.instance(new Locale("it-IT"));
		Postazione p = new Postazione();
		p.setDescrizione("La postazione è di tipo " + p.getTipopostazione() + "ed offre un numero massimo di "
				+ p.getNumMaxPosti() + " posti.");
		int posti = f.number().numberBetween(1, 50);
		p.setNumMaxPosti(posti);
		if (posti <= 35) {
			p.setTipopostazione(TipoPostazione.SALA_RIUNIONI);
		} else if (posti <= 15) {
			p.setTipopostazione(TipoPostazione.PRIVATO);
		} else {
			p.setTipopostazione(TipoPostazione.OPENSPACE);
		}
		return p;
	}

}

//EDIFICI NON FAKE: Deprecated //

//@Configuration
//@PropertySource("classpath:application.properties")
//public class PostazioneConfiguration {
//
//	@Bean("ParametriPostazione")
//	@Scope("prototype")
//	public Postazione parametriPostazione(String descrizione, TipoPostazione tipoedificio, Integer numeroMaxposti,
//			ElencoEdifici elencoedifici) {
//		return new Postazione();
//	}
//
//	// EDIFICIO 01//
//
//	@Bean("Postazione01")
//	@Scope("prototype")
//	public Postazione Postazione01() {
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.SALA_RIUNIONI);
//		p.setNumMaxPosti(30);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_01);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}
//
//	@Bean("Postazione02")
//	@Scope("prototype")
//	public Postazione Postazione02() {
//
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.OPENSPACE);
//		p.setNumMaxPosti(30);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_01);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}
//
//	// EDIFICIO 02//
//
//	@Bean("Postazione03")
//	@Scope("prototype")
//	public Postazione Postazione03() {
//
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.PRIVATO);
//		p.setNumMaxPosti(30);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_02);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}
//
//	@Bean("Postazione04")
//	@Scope("prototype")
//	public Postazione Postazione04() {
//
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.SALA_RIUNIONI);
//		p.setNumMaxPosti(30);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_02);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}
//
//	// EDIFICIO 03//
//
//	@Bean("Postazione05")
//	@Scope("prototype")
//	public Postazione Postazione05() {
//
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.OPENSPACE);
//		p.setNumMaxPosti(100);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_03);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}
//
//	@Bean("Postazione06")
//	@Scope("prototype")
//	public Postazione Postazione06() {
//
//		Postazione p = new Postazione();
//		p.setId(null);
//		p.setTipoedificio(TipoPostazione.SALA_RIUNIONI);
//		p.setNumMaxPosti(30);
//		p.setStatopostazione(StatoPostazione.LIBERA);
//		p.setElencoedifici(ElencoEdifici.EDIFICIO_03);
//
//		p.setDescrizione("La postazione si trova nell'" + p.getElencoedifici() + ", è di tipo " + p.getTipoedificio()
//				+ ", offre un numero massimo di " + p.getNumMaxPosti() + " posti.");
//
//		return p;
//	}

//}
