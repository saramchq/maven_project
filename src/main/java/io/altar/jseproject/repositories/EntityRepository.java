package io.altar.jseproject.repositories;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.myEntity;

@Dependent // esta classe só existe como base para ser usada pelas classes concretas que terão o scope real
public abstract class EntityRepository<T extends myEntity> { // classe abstrata genérica. Funciona como um repositório
																// (ou base de dados) para qualquer tipo de entidade													// desde q herde de MyEntity

	@PersistenceContext(unitName = "mypersistence")
	protected EntityManager em;
	
	//cada subclasse indica a classe da entidade
	protected abstract Class<T> getEntityClass();
	//private Map<Long, T> db = new HashMap<>(); // base de dados em memória
	//private long currentId = 0; // gera ids automáticos

	// CREATE
    public long create(T entity) {
        em.persist(entity); // INSERT
        return entity.getId(); // ID já preenchido pelo JPA
    }

    // READ by ID
    public T getById(Long id) {
        return (id == null) ? null : em.find(getEntityClass(), id);
    }

    // READ all
    public List<T> getAll() {
        // JPQL baseado no nome da entidade
        return em.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e", getEntityClass()) //jpa dinamico p queries simples
                 .getResultList();
    }

    // UPDATE
    public void edit(T entity) {
        em.merge(entity);
    }

    // DELETE
    public void remove(Long id) {
        if (id == null) return;
        T managed = em.find(getEntityClass(), id);
        if (managed != null) em.remove(managed);
    }
}