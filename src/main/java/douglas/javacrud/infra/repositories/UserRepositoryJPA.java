package douglas.javacrud.infra.repositories;

import douglas.javacrud.core.entities.User;
import douglas.javacrud.type.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByRoleEquals(UserRoles role);
    Optional<User> findByEmail(String email);
    User findByName(String name);
}
