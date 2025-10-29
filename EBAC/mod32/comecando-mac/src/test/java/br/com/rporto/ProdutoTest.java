package br.com.rporto;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.rporto.dao.IdaoProduto;
import br.com.rporto.domain.Produto;

public class ProdutoTest {

    private IdaoProduto daoProduto;

    @BeforeEach //utilizando essa annotation para garantir que o metodo sera executado antes de cada teste
    public void setUp (){
        daoProduto = new br.com.rporto.dao.DaoProduto();
    }
    @Test
    public void testeCadastroProduto() {
        Produto p1 = new Produto();
        p1.setNome("Notebook");
        p1.setPreco(4500.00);
        p1.setDescricao("Notebook Gamer");

        p1 = daoProduto.cadastrar(p1);
        
        assertNotNull(p1);
        assertNotNull(p1.getId());

    }

}
