package douglas.javacrud.core.dto.employee;

import douglas.javacrud.type.EmployeePosition;

import java.io.Serializable;

public record UpdateEmployee(String name, String email, EmployeePosition position) implements Serializable {}
