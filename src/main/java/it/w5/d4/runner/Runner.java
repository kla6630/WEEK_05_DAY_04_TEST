package it.w5.d4.runner;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.w5.d4.model.*;
import it.w5.d4.service.*;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements ApplicationRunner {

	public static Scanner s = new Scanner(System.in);

	@Autowired
	UtenteService utenteDaoRepository;

	@Autowired
	EdificioService edificioDaoRepository;

	@Autowired
	PostazioneService postazioneDaoRepository;

	@Autowired
	PrenotazioneService prenotazioneDaoRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		//edificioDaoRepository.newFakeBuilding();
		//Utente u = utenteDaoRepository.findUser(1l);
		//Postazione p = postazioneDaoRepository.findStation(1l);
		//LocalDate d = LocalDate.of(2024, 12, 25);
		//prenotazioneDaoRepository.saveReservation(new Prenotazione(u, p, d));
		//System.out.println(postazioneDaoRepository.findByCity("sassari"));

	}
}
