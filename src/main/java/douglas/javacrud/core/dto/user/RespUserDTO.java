package douglas.javacrud.core.dto.user;


import douglas.javacrud.type.UserRoles;


public record RespUserDTO(String name, String email, UserRoles role){}
