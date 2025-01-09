package douglas.javacrud.controllers;

import douglas.javacrud.core.dto.employee.ReqEmployeeDTO;
import douglas.javacrud.core.dto.employee.RespEmployeeDTO;
import douglas.javacrud.core.dto.employee.UpdateEmployee;
import douglas.javacrud.core.useCases.EmployeeUserCase;
import douglas.javacrud.type.EmployeePosition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Funcionários", description = "Gerenciamento de funcionários")
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeUserCase employeeUserCase;

    @PostMapping("/")
    @Operation(summary = "Add new employee")
    public ResponseEntity<String> registerEmployee(@RequestBody @Valid ReqEmployeeDTO employee){
        employeeUserCase.create(employee);
        return ResponseEntity.ok().body("Funcionário criado com sucesso!");
    }

    @GetMapping("/")
    @Operation(summary = "Get all employees")
    public ResponseEntity<List<RespEmployeeDTO>> getAllEmployees(@RequestParam(required = false) EmployeePosition position) {
        List<RespEmployeeDTO> employees = (position == null)
                ? employeeUserCase.getAll()
                : employeeUserCase.getAllPosition(position);
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get employee by id")
    public Optional<RespEmployeeDTO> getEmployeeById(@PathVariable String id) {
        return employeeUserCase.getEmployee(Long.parseLong(id));
    }


    @PatchMapping("/{id}")
    @Operation(summary = "Update Employee")
    public ResponseEntity<String> updateEmployee(
            @PathVariable String id,
            @RequestBody UpdateEmployee employee
    ){
        employeeUserCase.update(Long.parseLong(id),employee);
        return ResponseEntity.ok().body("Functionary actualization success!");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete employee by id")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
        var deleteUser = employeeUserCase.delete(Long.parseLong(id));
        if (!deleteUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body("Functionary deletable success!");
    }
}
