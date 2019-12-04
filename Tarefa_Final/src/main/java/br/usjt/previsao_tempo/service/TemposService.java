package br.usjt.previsao_tempo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import br.usjt.previsao_tempo.core.Forecast;
import br.usjt.previsao_tempo.core.Previsao;
import br.usjt.previsao_tempo.model.Cidade;
import br.usjt.previsao_tempo.model.Tempo;
import br.usjt.previsao_tempo.repository.DiaSemanaRepository;
import br.usjt.previsao_tempo.repository.TemposRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service  @ResponseBody
public class TemposService {
	
	@Autowired
	private DiaSemanaRepository semanaRepo;

    @Autowired
    private TemposRepository repository;
    
    private final String URL_PREV = "https://samples.openweathermap.org/data/2.5/forecast?q=";
	private final String APP_ID = "f48a60813b8702a5473bff21e6677b8b";
	private final double TO_CELSIUS = 273.15;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private String urlPrev(String city) {
		return URL_PREV + city + "&appid=" + APP_ID;
	}

	public Forecast obter(Cidade cidade) {
		RestTemplate restTemplate = new RestTemplate();
		Forecast prev = restTemplate.getForObject(urlPrev(cidade.getNome()), Forecast.class);
		return prev;
	}

	public String raw() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlPrev("Sao%20Paulo,br"), String.class);
	}
	
	private int diaSemana(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public List<Tempo> toClimaList(Forecast forecast, Cidade cidade) {
		List<Tempo> tempos = new ArrayList<>();
		for (Previsao previsao : forecast.getPrevisoes()) {
			Date data = new Date(1000 * previsao.getDt());
			Tempo t = new Tempo(null, semanaRepo.findById(Long.valueOf(diaSemana(data))).get(), previsao.getTemperature().getHumidity(), 
					previsao.getTemperature().getTempMin() - TO_CELSIUS, 
					previsao.getTemperature().getTempMax() - TO_CELSIUS, data, 
					previsao.getWeathers().get(0).getDescription(), previsao.getWeathers().get(0).getIcon(), cidade);
			tempos.add(t);		
		}
		return tempos;
	}

	public void saveClimas(List<Tempo> tempos) {
		tempos.forEach(c -> repository.save(c));
	}

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
