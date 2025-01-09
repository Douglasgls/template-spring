package douglas.javacrud.core.useCases;

import douglas.javacrud.core.dto.user.ReqUserDTO;
import douglas.javacrud.core.dto.user.RespUserDTO;
import douglas.javacrud.core.entities.User;
import douglas.javacrud.core.exceptions.user.UserAlreadyADM;
import douglas.javacrud.core.exceptions.user.UserAlreadyEmail;
import douglas.javacrud.core.ports.UserRepository;
import douglas.javacrud.type.UserRoles;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    private final UserRepository userRepository;

    @Autowired
    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RespUserDTO registerNewUser(@NotNull ReqUserDTO creatingUserDTO) {
        if (userRepository.existsByEmail(creatingUserDTO.email())) {
            throw new UserAlreadyEmail("Email already exists");
        }

        if (userRepository.existsByRoleEquals(UserRoles.ADMIN)) {
            throw new UserAlreadyADM("Role admin already exists");
        }

        String EncryptedPassword = new BCryptPasswordEncoder().encode(creatingUserDTO.password());

        User newUser = new User(creatingUserDTO.name(), creatingUserDTO.email(), EncryptedPassword, creatingUserDTO.role());
        User user = userRepository.save(newUser);
        return new RespUserDTO(user.getName(), user.getEmail(), user.getRole());
    }
}
