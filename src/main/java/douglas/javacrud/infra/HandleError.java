package douglas.javacrud.infra;

import douglas.javacrud.core.exceptions.employee.EmployeeAlreadyCpf;
import douglas.javacrud.core.exceptions.employee.EmployeeAlreadyEmail;
import douglas.javacrud.core.exceptions.employee.EmployeeNotFound;
import douglas.javacrud.core.exceptions.user.UserAlreadyEmail;
import douglas.javacrud.core.exceptions.user.UserNotFound;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandleError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        System.out.println(ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NotNull HttpHeaders headers,
            HttpStatusCode status,
            @NotNull WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("timestamp", new Date());
        response.put("errors", errors);

        return new ResponseEntity<>(response, headers, status);
    }


    //    USER
    @ExceptionHandler(UserAlreadyEmail.class)
    public ResponseEntity<MessageErrorAPI> handleEmailAlreadyExists(UserAlreadyEmail err) {
        MessageErrorAPI message = new MessageErrorAPI(HttpStatus.CONFLICT, err.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<MessageErrorAPI> handleUserNotFound(UserNotFound err) {
        MessageErrorAPI message = new MessageErrorAPI(HttpStatus.NOT_FOUND, err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    //    EMPLOYEE
    @ExceptionHandler(EmployeeAlreadyCpf.class)
    public ResponseEntity<MessageErrorAPI> handleCPFAlreadyExists(EmployeeAlreadyCpf err) {
        MessageErrorAPI message = new MessageErrorAPI(HttpStatus.CONFLICT, err.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(EmployeeAlreadyEmail.class)
    public ResponseEntity<MessageErrorAPI> handleEmailAlreadyExists(EmployeeAlreadyEmail err) {
        MessageErrorAPI message = new MessageErrorAPI(HttpStatus.CONFLICT, err.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<MessageErrorAPI> EmployeeNotFound(EmployeeNotFound err) {
        MessageErrorAPI messageNotFound = new MessageErrorAPI(HttpStatus.NOT_FOUND, err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageNotFound);
    }

}
