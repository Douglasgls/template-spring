package douglas.javacrud.core.entities;

import douglas.javacrud.type.EmployeePosition;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private BigDecimal salary;
    private String CPF;
    private EmployeePosition position;
    @CreatedDate LocalDate createdAt;

    public Employee(String name, String email, BigDecimal salary, String CPF, EmployeePosition position) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.CPF = CPF;
        this.position = position;
        this.createdAt = LocalDate.now();
    }

}
