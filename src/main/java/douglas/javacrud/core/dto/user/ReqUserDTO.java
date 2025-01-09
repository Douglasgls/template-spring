package douglas.javacrud.core.dto.user;

import douglas.javacrud.type.UserRoles;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema
public record ReqUserDTO(String name, String email, String password, UserRoles role) {
}
