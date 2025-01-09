package douglas.javacrud.core.dto.employee;

import douglas.javacrud.type.EmployeePosition;

import java.io.Serializable;

public record RespEmployeeDTO(
        Long id,
        String name ,
        String CPF,
        String email,
        EmployeePosition position
) implements Serializable {}
