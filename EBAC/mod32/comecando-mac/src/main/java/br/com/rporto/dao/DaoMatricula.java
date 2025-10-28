package br.com.rporto.dao;

import br.com.rporto.domain.Matricula;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoMatricula implements IdaoMatricula{

    @Override
    public Matricula cadastrar(Matricula matricula) {
         EntityManagerFactory emf= 
        Persistence.createEntityManagerFactory("ExemploJpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(matricula);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return matricula;
    }


}
