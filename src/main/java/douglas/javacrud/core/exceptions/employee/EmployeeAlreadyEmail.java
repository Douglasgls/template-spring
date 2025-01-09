package douglas.javacrud.core.exceptions.employee;

public class EmployeeAlreadyEmail extends RuntimeException {
    public EmployeeAlreadyEmail(String emailAlreadyExists) {
        super(emailAlreadyExists);
    }
}
