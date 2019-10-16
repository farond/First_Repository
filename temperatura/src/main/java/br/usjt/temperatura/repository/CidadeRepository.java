package br.usjt.temperatura.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.temperatura.model.Cidade;



@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	public Cidade findByNome(String nome);
	public Cidade getByLatitude(String latitude);
	public Cidade getBylongitude(String longitude);

	
	@Transactional
	public List<Cidade> queryByNome(String nome);

}
