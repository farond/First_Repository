package br.usjt.temperatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.usjt.temperatura.model.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Long>{
}