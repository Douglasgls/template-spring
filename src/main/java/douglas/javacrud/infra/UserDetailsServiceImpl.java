package douglas.javacrud.infra;

import douglas.javacrud.infra.repositories.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import douglas.javacrud.core.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepositoryJPA userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(user -> new User(user.getName(), user.getEmail(), user.getPassword(), user.getRole()))
                .orElseThrow(
                        () -> new UsernameNotFoundException("User Not Found with username: " + username));
    }
}
