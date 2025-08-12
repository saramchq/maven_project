package io.altar.jseproject.repositories;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.User;
@ApplicationScoped
public class UserRepository {

	@PersistenceContext(unitName = "myperesistence")
	private EntityManager em;
	
	//private final Map<Long, User> users = new HashMap<>();
	//private long currentId = 1;

	/*
	 * private static final UserRepository INSTANCE = new UserRepository();
	 * 
	 * private UserRepository() {
	 * 
	 * }
	 * 
	 * public static UserRepository getInstance() { return INSTANCE; }
	 */

//criar
	public User create(User user) {
		//user.setId(currentId++);
		//users.put(user.getId(), user);
		em.persist(user); //INSERT
		return user; //id gerado pelo jpa
	}

//busca todos
	public Collection<User> getAll() {
		return em.createQuery("SELECT u FROM User u", User.class)
				.getResultList(); //jpql
		//return users.values();
	}

//busca por id
	public User getById(long id) {
		return em.find(User.class, id); //SELECT por primary key
		//return users.get(id);
	}

//edita
	public void edit(User user) {
		em.merge(user); //UPDATE
		//users.put(user.getId(), user);
	}

//remover
	public void remove(long id) {
		User managed = em.find(User.class, id); //usa o entitymanager p procurar na bd o user c a pk  e existir devolve uma entidade managed se n devolve null
		if(managed !=null) em.remove(managed); //DELETE, marca a entidade para DELETE na BD
		//users.remove(id);
	}
}