package io.altar.jseproject.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.model.User;
@ApplicationScoped
public class UserRepository extends EntityRepository<User> {

	@Override
	protected Class<User> getEntityClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

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

}