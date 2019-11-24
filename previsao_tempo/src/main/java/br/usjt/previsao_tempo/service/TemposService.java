package br.usjt.previsao_tempo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.previsao_tempo.model.Tempo;
import br.usjt.previsao_tempo.repository.TemposRepository;

import java.util.List;

@Service
public class TemposService {

    @Autowired
    private TemposRepository repository;

    public void salvar(Tempo tempo) {
        repository.save(tempo);
    }

    public List<Tempo> listarTodos() {
        return repository.findAll();
    }

    public List<Tempo> buscarCidade(String nome) {
        return repository.BuscaPeloCidadeNome(nome);
    }

    public List<Tempo> buscarLateLon(Double lat, Double lon) {
        return repository.BuscaPeloLatELon(lat, lon);
    }



}
