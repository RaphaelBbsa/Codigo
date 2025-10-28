package br.com.rporto.dao;

import br.com.rporto.domain.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoCurso implements IdaoCurso {

    @Override
    public Curso cadastrar(Curso curso) {
        EntityManagerFactory emf= 
        Persistence.createEntityManagerFactory("ExemploJpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return curso;
    }

}
