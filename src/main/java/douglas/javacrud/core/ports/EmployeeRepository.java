package douglas.javacrud.core.ports;

import douglas.javacrud.core.entities.Employee;
import douglas.javacrud.type.EmployeePosition;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    Boolean existsByCPF(String cpf);
    Boolean existsByEmail(String email);
    List<Employee> getEmployeeByPosition(EmployeePosition position);
    void save(Employee employee);
    List<Employee> findAll();
    Employee findById(Long id);
    void delete(Long id);

}
