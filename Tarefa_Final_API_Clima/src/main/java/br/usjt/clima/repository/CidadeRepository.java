package br.usjt.clima.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import br.usjt.clima.model.Cidade;

@Repository

public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	public Cidade findOneByLatitudeAndLongitude(Double latitude, Double longitude);

	
	@Async
	public Future<List<Cidade>> findByNome(String nome);
	
	public List<Cidade> findByLatitudeAndLongitude (Double latitude, Double longitude); 
	

	@Query ("SELECT c FROM Cidade c WHERE Upper(c.nome) LIKE %:nome%")

	List<Cidade> buscaByNomeIgnoreCase (String nome);
}
 