package main.java.br.com.vvatte.dao;

import main.java.br.com.vvatte.domain.Carro;
import main.java.br.com.vvatte.domain.Marca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

public class CarroDao implements ICarroDao {
    @Override
    public Carro cadastrar(Carro carro) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carro);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return carro;
    }

    @Override
    public Carro buscarPorCodigoMarca(String codigoMarca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        Join<Object, Object> join = root.join("marca", JoinType.INNER);
        query.select(root).where(builder.equal(join.get("codigo"), codigoMarca));

        TypedQuery<Carro> tpQuery =
                entityManager.createQuery(query);
        Carro carro = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return carro;    }

    @Override
    public Carro buscarPorMarca(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Carro> query = builder.createQuery(Carro.class);
        Root<Carro> root = query.from(Carro.class);
        Join<Object, Object> join = root.join("marca", JoinType.INNER);
        query.select(root).where(builder.equal(join, marca));

        TypedQuery<Carro> tpQuery =
                entityManager.createQuery(query);
        Carro carro = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return carro;
    }
}
