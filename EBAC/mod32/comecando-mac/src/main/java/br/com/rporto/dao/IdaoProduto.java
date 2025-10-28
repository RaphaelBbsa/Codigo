package br.com.rporto.dao;

import java.util.List;

import br.com.rporto.domain.Produto;

public interface IdaoProduto {

    public Produto cadastrar(Produto produto);
    
    public Produto buscarPorId(Long id);

    public List<Produto> buscarTodos();

    
}
