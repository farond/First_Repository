package br.usjt.previsao_tempo.controller;



import br.usjt.previsao_tempo.model.Tempo;

import br.usjt.previsao_tempo.service.TemposService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private TemposService temposService;

    @GetMapping("/tempo")
    public ModelAndView listarPeriodos() {
        ModelAndView mv = new ModelAndView("lista_tempo");
        mv.addObject(new Tempo());
        //List<Tempo> tempos = repository.findAll();
        List<Tempo> tempos = temposService.listarTodos();
        mv.addObject("tempos", tempos);
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
