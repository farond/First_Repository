package br.usjt.temperatura.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.temperatura.model.Temperatura;
import br.usjt.temperatura.repository.TemperaturaRepository;

@Controller
public class TemperaturasController {


	@Autowired
	private TemperaturaRepository repository;

	@GetMapping("/temperaturas")
	private ModelAndView listarTemperaturas() throws IOException 
	{
		ModelAndView modelAndView = new ModelAndView("lista_temperatura");
		List<Temperatura> temperaturas = repository.findAll();
		modelAndView.addObject("temperaturas", temperaturas);
		return modelAndView;
	}
}
