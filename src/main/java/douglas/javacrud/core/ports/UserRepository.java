package douglas.javacrud.core.ports;

import douglas.javacrud.core.entities.User;
import douglas.javacrud.type.UserRoles;

import java.util.Optional;

public interface UserRepository
{
    Boolean existsByEmail(String email);
    Boolean existsByRoleEquals(UserRoles role);
    Optional<User> findByEmail(String username);
    User save(User userManager);
}
