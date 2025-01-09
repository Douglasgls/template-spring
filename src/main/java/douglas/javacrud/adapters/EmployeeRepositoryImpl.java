package douglas.javacrud.adapters;

import douglas.javacrud.core.entities.Employee;
import douglas.javacrud.core.ports.EmployeeRepository;
import douglas.javacrud.infra.repositories.EmployeeRepositoryJPA;
import douglas.javacrud.infra.repositories.UserRepositoryJPA;
import douglas.javacrud.type.EmployeePosition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeRepositoryJPA repositoryJPA;

    public EmployeeRepositoryImpl(EmployeeRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }


    @Override
    public Boolean existsByCPF(String cpf) {
        return repositoryJPA.existsByCPF(cpf);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repositoryJPA.existsByEmail(email);
    }

    @Override
    public List<Employee> getEmployeeByPosition(EmployeePosition position) {
        return repositoryJPA.findByPosition(position);
    }

    @Override
    public void save(Employee employee) {
        repositoryJPA.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repositoryJPA.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return repositoryJPA.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repositoryJPA.deleteById(id);
    }
}
