package br.com.rporto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;

import org.junit.jupiter.api.Test;

import br.com.rporto.dao.IdaoMatricula;
import br.com.rporto.domain.Matricula;

public class MatriculaTest {

    private IdaoMatricula DaoMatricula;

    public MatriculaTest() {
        DaoMatricula = new br.com.rporto.dao.DaoMatricula();
    }
    
@Test
public void cadastro () {
    Matricula mat = new Matricula();
    mat.setCodigo("MAT-001");
    mat.setDataMatricula(Instant.now());
    mat.setValor(1000);
    mat.setStatus("ATIVO");

   mat = DaoMatricula.cadastrar(mat);
   
    assertNotNull(mat);
    assertNotNull(mat.getId());
    }
}