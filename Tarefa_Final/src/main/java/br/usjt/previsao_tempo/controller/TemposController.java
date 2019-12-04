package br.usjt.previsao_tempo.controller;




import br.usjt.previsao_tempo.core.Forecast;
import br.usjt.previsao_tempo.model.Cidade;
import br.usjt.previsao_tempo.model.Tempo;
import br.usjt.previsao_tempo.repository.CidadeRepository;
import br.usjt.previsao_tempo.service.TemposService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TemposController {

//    @Autowired
//    private PeriodosRepository repository;

//    @Autowired
//    public PeriodosController(PeriodosRepository repository) {
//        this.repository = repository;
//    }
//
//    @Autowired
//    public void setRepository(PeriodosRepository repository){
//        this.repository = repository;
//    }
	

    @Autowired
    private CidadeRepository cidadeRepo;

    @Autowired
    private TemposService temposService;

    @GetMapping("/tempo")
    public ModelAndView listarPeriodos() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
        List<Tempo> tempos = temposService.listarTodos();
        mv.addObject("tempos", tempos);
        mv.addObject(new Tempo());
       return mv;
    }
    
      @PostMapping("/buscarCidade")
    public ModelAndView buscarCidade(String nome){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
           List<Tempo> tempos = temposService.buscarCidade(nome);
        //Future<List<Tempo>> tempos = peridosService.buscarCidade(nome);
        mv.addObject("tempos", tempos);
        return mv;
    }

    @PostMapping("/buscarLateLon")
    public ModelAndView buscarLateLon(Double lat, Double lon){
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        List<Tempo> tempos = temposService.buscarLateLon(lat,lon);
        mv.addObject("tempos", tempos);
        return mv;
    }
    
    @PostMapping(value = "/buscarPrev/cidade", produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consume(@RequestBody long cidadeId) {
		Cidade cidade = cidadeRepo.findById(cidadeId).get(); //TODO: O que fazer se for inválido?
		Forecast forecast = temposService.obter(cidade);
		List<Tempo> climas = temposService.toClimaList(forecast, cidade);
		temposService.saveClimas(climas);
		return "redirect:/previsoes";
	}

    //@PostMapping(value = "/buscarnome", produces = MediaType.APPLICATION_JSON_VALUE)
	//public String consume(@PathVariable String nome) {
		//Cidade cidade = (Cidade) cidadeRepo.findAllByCidade_Nome(nome);
		//Forecast forecast = temposService.obter(cidade);
		//List<Tempo> climas = temposService.toClimaList(forecast, cidade);
		//temposService.saveClimas(climas);
		//return "redirect:/previsoes";
	//}
    
    //Salvar Tempo
    @PostMapping("/salvartempo")
	public String salvar (Tempo temp) {
		temposService.salvar(temp);
		return "redirect:/tempo";
	}
    
    @PostMapping("/cadastrar")
    public Cidade salvar(Cidade cidade) {
    return cidadeRepo.save(cidade);
    }

    @PostMapping("/tempo")
    public ModelAndView Home() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
        List<Tempo> tempos = temposService.listarTodos();
       mv.addObject("tempos", tempos);
       return mv;
    }
   
}
