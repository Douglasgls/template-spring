package douglas.javacrud.core.exceptions.employee;

public class EmployeeNotFound extends RuntimeException {

    private String message;

    public EmployeeNotFound(String message) {super(message);}

}
