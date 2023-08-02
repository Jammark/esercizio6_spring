package com.esercizio6_spring.esercizio6_spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio6_spring.esercizio6_spring.model.Postazione;
import com.esercizio6_spring.esercizio6_spring.model.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	List<Postazione> findByTipoAndEdificioCittà(TipoPostazione tipo, String città);
}
