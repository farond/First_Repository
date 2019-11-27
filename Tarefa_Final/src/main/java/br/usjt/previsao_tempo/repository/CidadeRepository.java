package br.usjt.previsao_tempo.repository;

import br.usjt.previsao_tempo.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("select c from Cidade c where upper(c.nome) like :nome% or lower(c.nome) like :nome% ")
    public List<Cidade> findAllByNomeIgnoreCase(@Param("nome") String nome);

    @Query("select c from Cidade c where c.latitude = :latitude and c.longitude = :longitude")
    public List<Cidade> findAllByLatitudeAndLongitude(@Param("latitude") Double latitude, @Param("longitude") Double longitude);

}
