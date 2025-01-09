package douglas.javacrud.adapters;

import douglas.javacrud.core.entities.User;
import douglas.javacrud.core.ports.UserRepository;
import douglas.javacrud.infra.repositories.UserRepositoryJPA;
import douglas.javacrud.type.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private final UserRepositoryJPA userRepositoryJPA;

    public UserRepositoryImpl(UserRepositoryJPA userRepository) {
        this.userRepositoryJPA = userRepository;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepositoryJPA.existsByEmail(email);
    }

    @Override
    public Boolean existsByRoleEquals(UserRoles role) {
        return userRepositoryJPA.existsByRoleEquals(role);
    }

    @Override
    public Optional<User> findByEmail(String username) {
        return userRepositoryJPA.findByEmail(username);
    }

    @Override
    public User save(User userManager) {
        return userRepositoryJPA.save(userManager);
    }

}
