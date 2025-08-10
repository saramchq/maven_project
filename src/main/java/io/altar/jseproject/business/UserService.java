package io.altar.jseproject.business;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.altar.jseproject.model.User;
import io.altar.jseproject.repositories.UserRepository;

@ApplicationScoped
public class UserService {
	
	@Inject
	private UserRepository userRepository;

   //private final UserRepository userRepository = UserRepository.getInstance();

    //criar um utilizador
    public User create(User user) {
        return userRepository.create(user);
    }

    //buscar User por ID
    public User getById(long id) {
        return userRepository.getById(id);
    }

    //devolver todos os Users
    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    //editar um User
    public void edit(User user) {
        userRepository.edit(user);
    }

    //remover User
    public void remove(long id) {
        userRepository.remove(id);
    }

    //verifica se o user pode aceder a produtos
    public boolean canAccessProducts(User user) {
        String role = user.getRole().toLowerCase();
        return role.equals("admin") || role.equals("manager");
    }
    
    //associar uma store a um utilizador
    public void associarStore(long userId, long storeId) {
        User user = userRepository.getById(userId);
        if (user != null) {
            user.getStoreIds().add(storeId);
            userRepository.edit(user);
        }
    }

}
