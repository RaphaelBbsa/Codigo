package br.com.barberporto.barberporto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.barberporto.barberporto.domain.Barbeiro;
import br.com.barberporto.barberporto.repository.BarbeiroRepository;

@Service //serve pra indicar que essa classe e um servico do spring
public class BarbeiroService {

        private final BarbeiroRepository repository; //o service sempre vai usar esse repositorio, por isso o final

        public BarbeiroService(BarbeiroRepository repository) {
            this.repository = repository;
        }

        public List<Barbeiro> listarTodos (){
            return repository.findAll();
        }

        public Barbeiro criar(Barbeiro barbeiro){
            return repository.save(barbeiro);
        }
}
