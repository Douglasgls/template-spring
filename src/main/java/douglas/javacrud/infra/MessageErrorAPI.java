package douglas.javacrud.infra;

import io.swagger.v3.core.util.Json;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class MessageErrorAPI {
    private HttpStatus statusCode;
    private String message;
}