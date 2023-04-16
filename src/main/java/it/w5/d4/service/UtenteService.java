package it.w5.d4.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import it.w5.d4.model.Utente;
import it.w5.d4.repository.UtenteDaoRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {

	@Autowired
	private UtenteDaoRepository udr;

	@Autowired
	@Qualifier("UtenteFake")
	private ObjectProvider<Utente> utenteFakeProvider;

	public Utente nuovoUtenteFake() {
		Utente u = utenteFakeProvider.getObject();
		return u;

	}

	public void salvaUtente(Utente u) {
		udr.save(u);

	}

	public Utente ricercaPerId(Long id) {
		return udr.ricercaPerId(id).get();
	}

	public Utente ricercaPerNomeUtente(String nomeutente) {
		return udr.ricercaPerNomeUtente(nomeutente);
	}

	public void eliminaUtente(Long id) {
		udr.delete(ricercaPerId(id));

	}

	public List<Utente> trovaTuttiGliUtenti() {
		return (List<Utente>) udr.findAll();
	}

}