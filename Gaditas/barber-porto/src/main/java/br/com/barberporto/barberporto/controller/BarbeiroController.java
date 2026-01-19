package br.com.barberporto.barberporto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barberporto.barberporto.domain.Barbeiro;
import br.com.barberporto.barberporto.repository.BarbeiroRepository;


@RestController //diz ao spring que essa classe vai receber as requisicoes http
@RequestMapping("/barbeiros")//defino o endereco base do barbeiro, GET /barbeiros, POST /barbeiros
public class BarbeiroController {

    
    
    
    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroController(BarbeiroRepository barbeiroRepository) { //fiz essa injecao de dependencia e garanto que o controller sempre tera um repositorio
        this.barbeiroRepository = barbeiroRepository;
    }


    @GetMapping //mapeia requisicoes do tipo GET
    public List<Barbeiro> getAllBarbeiros() {
        return barbeiroRepository.findAll();
    }

    @PostMapping //mapeia requisicoes do tipo POST
    public Barbeiro criar(@RequestBody Barbeiro barbeiro) { 
        return barbeiroRepository.save(barbeiro);
    }
}
