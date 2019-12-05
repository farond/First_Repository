package br.usjt.clima.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.clima.model.Cidade;
import br.usjt.clima.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@GetMapping("/lista")
	public List<Cidade> todas() {
		return cidadeRepo.findAll();
	}
	

	@GetMapping("/cidade/{id}")
	public Cidade buscarPeloId(@PathVariable Long id) {
		return cidadeRepo.getOne(id);
	}
	// Listar todas as cidades cujo nome começa com uma letra específica
	@GetMapping(value="/letra")
	public ModelAndView todasCidadesLetra(@RequestParam String nome) {
		String nomeCaixaAlta = nome.toUpperCase();
		nome = nomeCaixaAlta;
		ModelAndView mav = new ModelAndView("listar_previsoes");
		mav.addObject(new Cidade());
		mav.addObject("cidades", cidadeRepo.buscaByNomeIgnoreCase(nome));
		return mav;
	}
	
////	// Obter uma cidade por sua latitude e longitude

	@GetMapping("/latitude")
	public ModelAndView findByLatitudeAndLongitude(@RequestParam Double latitude, Double longitude) {
		if(cidadeRepo.findByLatitudeAndLongitude(latitude, longitude).isEmpty() || cidadeRepo.findByLatitudeAndLongitude(latitude, longitude) == null )
		{
			System.out.println("Lista vazia");
		}
		for(Cidade listaCidade: cidadeRepo.findByLatitudeAndLongitude(latitude, longitude))
		{
			System.out.println("Nome da Cidade: " + listaCidade.getNome());
		}
		ModelAndView lav = new ModelAndView("listar_previsoes");
		lav.addObject(new Cidade());
		lav.addObject("cidades", cidadeRepo.findByLatitudeAndLongitude(latitude, longitude));
		return lav;
		

	}
	
	//Salvar cidade não funciona
	@RequestMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8", value = "/test")
	@PostMapping("/salvarcidade")
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade c = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}")
				.buildAndExpand(c.getId())
				.toUri();
		return ResponseEntity.created(uri).body(c);
	}
	
}
