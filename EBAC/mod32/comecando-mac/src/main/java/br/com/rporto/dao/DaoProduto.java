package br.com.rporto.dao;

import java.util.List;

import br.com.rporto.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DaoProduto implements IdaoProduto {

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJpa");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin(); //marca o início da transação
        entityManager.persist(produto); // comando para salvar o produto
        entityManager.getTransaction().commit(); //confirma a transação
        entityManager.close(); //fecha o entity manager
        emf.close(); //fecha o entity manager factory
        return produto;
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJpa");
        EntityManager entityManager = emf.createEntityManager();
        try {
            // find pode retornar null se não encontrar
            return entityManager.find(Produto.class, id);
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
            if (emf.isOpen()) {
                emf.close();
            }
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("ExemploJpa"); //carrega a unidade de persistencia que eu defiini no persistence.xml, prepaara pools, caches etc
        EntityManager entityManager = emf.createEntityManager(); //entity manager é o responsavel por fazer as operações no banco de dados 

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();//criteriaAPI é o consultor sql em java, crio consultas dinamicas. ele é a fabrica de consultas
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class); // é o papel em branco onde vou construir a consulta
        Root<Produto> root = query.from(Produto.class); //representa e entidade raiz, permite acessar os atributos da entidade. root.get(nome) por exemplo eu pegaria o nome
        query.select(root); //define o que quero selecionar na consulta
        
        TypedQuery<Produto> tpQuery = entityManager.createQuery(query);  //transforma o criteria query em uma consulta executavel, permite paginacao e binding de parametros
        List<Produto> produtos = tpQuery.getResultList();
        entityManager.close();
        emf.close();
        return produtos;
    }

}
