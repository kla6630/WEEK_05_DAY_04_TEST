package it.w5.d4.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.w5.d4.model.Edificio;

@Repository
public interface EdificioDaoRepository extends CrudRepository<Edificio, Long> {
	
	@Query(value = "SELECT e FROM Edificio e ORDER BY RANDOM() LIMIT 1")
	public Edificio getEdificioCasuale();

}
