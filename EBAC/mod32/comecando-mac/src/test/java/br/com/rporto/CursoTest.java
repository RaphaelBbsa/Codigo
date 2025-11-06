package br.com.rporto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.rporto.dao.IdaoCurso;
import br.com.rporto.domain.Curso;


public class CursoTest {
    private IdaoCurso DaoCurso;

public CursoTest (){
    DaoCurso = new br.com.rporto.dao.DaoCurso();
}
    @Test
    public void Cadastro () {
    Curso curso = new Curso();
    curso.setNome("Java");
    curso.setCodigo("JAVA-1245");
    curso.setDescricao("Curso de Java");
    curso =   DaoCurso.cadastrar(curso);

    assertNotNull(curso);
    assertNotNull(curso.getId());
}
}

