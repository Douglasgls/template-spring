package douglas.javacrud.core.useCases;

import douglas.javacrud.core.dto.employee.ReqEmployeeDTO;
import douglas.javacrud.core.dto.employee.RespEmployeeDTO;
import douglas.javacrud.core.dto.employee.UpdateEmployee;
import douglas.javacrud.core.entities.Employee;
import douglas.javacrud.core.exceptions.employee.EmployeeAlreadyCpf;
import douglas.javacrud.core.exceptions.employee.EmployeeAlreadyEmail;
import douglas.javacrud.core.ports.EmployeeRepository;
import douglas.javacrud.type.EmployeePosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeUserCase {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeUserCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void create(ReqEmployeeDTO employeeDTO) {
        if (employeeRepository.existsByCPF(employeeDTO.CPF())) {
            throw new EmployeeAlreadyCpf("CPF already exists");
        }

        if (employeeRepository.existsByEmail(employeeDTO.email())) {
            throw new EmployeeAlreadyEmail("Email already exists");
        }

        Employee employee = new Employee(
                employeeDTO.name(),
                employeeDTO.email(),
                employeeDTO.salary(),
                employeeDTO.CPF(),
                employeeDTO.position()
        );
        employeeRepository.save(employee);
    }

    public List<RespEmployeeDTO> getAll() {
        var employees = employeeRepository.findAll();

        return employees.stream().map(
                employee -> new RespEmployeeDTO(
                        Long.parseLong(String.valueOf(employee.getId())),
                        employee.getName(),
                        employee.getCPF(),
                        employee.getEmail(),
                        employee.getPosition())
        ).toList();

    }

    public List<RespEmployeeDTO> getAllPosition(EmployeePosition position) {
        var employees = employeeRepository.getEmployeeByPosition(position);

        return employees.stream().map(
                employee -> new RespEmployeeDTO(
                        Long.parseLong(String.valueOf(employee.getId())),
                        employee.getCPF(),
                        employee.getName(),
                        employee.getEmail(),
                        employee.getPosition())
        ).toList();

    }

    public Optional<RespEmployeeDTO> getEmployee(Long id) {
        var employee = employeeRepository.findById(id);

        return Optional.of(new RespEmployeeDTO(
                Long.parseLong(String.valueOf(employee.getId())),
                employee.getCPF(),
                employee.getName(),
                employee.getEmail(),
                employee.getPosition())
        );
    }

    public void update(Long id, UpdateEmployee employee) {

        Employee existEmployee =  employeeRepository.findById(id);

        if (existEmployee == null) {
            throw new EmployeeAlreadyCpf("Employee not found");
        }

        existEmployee.setName(employee.name());
        existEmployee.setEmail(employee.email());
        existEmployee.setPosition(employee.position());
        employeeRepository.save(existEmployee);
    }

    public void delete(Long id) {
        employeeRepository.delete(id);
    }
}
