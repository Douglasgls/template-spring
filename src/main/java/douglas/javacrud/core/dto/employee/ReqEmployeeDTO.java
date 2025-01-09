package douglas.javacrud.core.dto.employee;

import douglas.javacrud.type.EmployeePosition;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Schema
public record ReqEmployeeDTO(
        @NotBlank(message = "The name is required.")
        @Size(min = 2, max = 100, message = "The name must be between 2 and 100 characters.")
        String name,

        @NotBlank(message = "The email is required.")
        @Email(message = "Invalid email format.")
        String email,

        @NotNull(message = "The salary is required.")
        @DecimalMin(value = "0.0", inclusive = false, message = "The salary must be greater than 0.")
        BigDecimal salary,

        @NotBlank(message = "The CPF is required.")
        @Pattern(regexp = "\\d{11}", message = "The CPF must contain exactly 11 digits.")
        String CPF,

        @NotNull(message = "The position is required.")
        EmployeePosition position
)implements Serializable {}