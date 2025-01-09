package douglas.javacrud.core.exceptions.user;

public class UserAlreadyADM extends RuntimeException {
    public UserAlreadyADM(String roleAdminAlreadyExists) {
        super(roleAdminAlreadyExists);
    }
}
