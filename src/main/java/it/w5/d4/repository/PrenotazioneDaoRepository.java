package it.w5.d4.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.w5.d4.model.Postazione;
import it.w5.d4.model.Prenotazione;
import it.w5.d4.model.Utente;

@Repository
public interface PrenotazioneDaoRepository extends CrudRepository<Prenotazione, Long> {

	@Query(value = "SELECT p FROM Prenotazione p INNER JOIN p.utente u WHERE u = :utente")
	public List<Prenotazione> cercaPerUtente(Utente utente);

	@Query(value = "SELECT p FROM Prenotazione p INNER JOIN p.utente u WHERE u = :utente AND p.data = :data")
	public List<Prenotazione> cercaPerData(Utente utente, LocalDate date);

	@Query(value = "SELECT pr FROM Prenotazione pr INNER JOIN pr.postazione ps WHERE ps = :postazione AND pr.data = :data")
	public List<Prenotazione> findByStatAndDate(Postazione postazione, LocalDate date);

}