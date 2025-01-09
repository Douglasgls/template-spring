package douglas.javacrud.infra.repositories;

import douglas.javacrud.core.entities.Employee;
import douglas.javacrud.type.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryJPA extends JpaRepository<Employee, Long> {
    Boolean existsByCPF(String CPF);
    List<Employee> getEmployeeByPosition(EmployeePosition position);
    List<Employee> findByPosition(EmployeePosition position);
    Boolean existsByEmail(String email);
}
