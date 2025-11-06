package br.com.rporto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;

import org.junit.jupiter.api.Test;

import br.com.rporto.dao.IdaoCurso;
import br.com.rporto.dao.IdaoMatricula;
import br.com.rporto.domain.Curso;
import br.com.rporto.domain.Matricula;

public class MatriculaTest {

    private IdaoMatricula DaoMatricula;

    private IdaoCurso DaoCurso;

    public MatriculaTest() {
        DaoMatricula = new br.com.rporto.dao.DaoMatricula();
        DaoCurso = new br.com.rporto.dao.DaoCurso();
    }
    
@Test
public void cadastro () {

    Curso curso = criarCurso ("A234-XYZ2");

    Matricula mat = new Matricula();
    mat.setCodigo("MAT-003");
    mat.setDataMatricula(Instant.now());
    mat.setValor(1000);
    mat.setCurso(curso);
    mat.setStatus("ATIVO");

   mat = DaoMatricula.cadastrar(mat);
   
    assertNotNull(mat);
    assertNotNull(mat.getId());
    }

    private Curso criarCurso (String codigo){
        Curso curso = new Curso();
        curso.setNome("Java");
        curso.setCodigo(codigo);
        curso.setDescricao("Curso de Java");
        curso =   DaoCurso.cadastrar(curso);
        return curso;
    }
}