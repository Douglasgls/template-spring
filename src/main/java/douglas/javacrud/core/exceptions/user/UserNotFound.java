package douglas.javacrud.core.exceptions.user;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String userNotFound) {
        super(userNotFound);
    }
}
