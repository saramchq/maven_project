package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.model.User;
@ApplicationScoped
public class UserRepository {

	private final Map<Long, User> users = new HashMap<>();
	private long currentId = 1;

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
		user.setId(currentId++);
		users.put(user.getId(), user);
		return user;
	}

//busca todos
	public Collection<User> getAll() {
		return users.values();
	}

//busca por id
	public User getById(long id) {
		return users.get(id);
	}

//edita
	public void edit(User user) {
		users.put(user.getId(), user);
	}

//remover
	public void remove(long id) {
		users.remove(id);
	}
}