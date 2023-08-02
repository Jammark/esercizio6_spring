package com.esercizio6_spring.esercizio6_spring.service;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio6_spring.esercizio6_spring.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	boolean existsByPostazioneIdAndData(Long postazioneId, LocalDate data);

	boolean existsByUserIdAndData(Long userId, LocalDate data);
}
