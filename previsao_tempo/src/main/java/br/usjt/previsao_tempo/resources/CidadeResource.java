package br.usjt.previsao_tempo.resources;

import br.usjt.previsao_tempo.model.Cidade;
import br.usjt.previsao_tempo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/lista")
    public List<Cidade> todasAsCidades() {
        return cidadeRepository.findAll();
    }

    @GetMapping("/{nome}")
    public List<Cidade> buscarPelonome(@PathVariable String nome) {
        return cidadeRepository.findAllByNomeIgnoreCase(nome);
    }

    @RequestMapping("/buscaLatELon")
    public List<Cidade> buscaPeloLatELon(@RequestParam Double latitude, @RequestParam Double longitude) {
        return cidadeRepository.findAllByLatitudeAndLongitude(latitude, longitude);
    }

    @PostMapping("/salvar")
//@ResponseStatus (HttpStatus.CREATED) agora desnecessária
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse
            response) {
        Cidade c = cidadeRepository.save(cidade);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentServletMapping().path("/{id}").
                buildAndExpand(c.getId()).
                toUri();
        //desnecessário também
        //response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(c);
    }

}
