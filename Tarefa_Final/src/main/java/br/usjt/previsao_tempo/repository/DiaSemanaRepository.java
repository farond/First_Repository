package br.usjt.previsao_tempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.previsao_tempo.model.DiaSemana;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {

}
