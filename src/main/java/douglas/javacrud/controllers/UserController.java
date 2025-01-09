package douglas.javacrud.controllers;

import douglas.javacrud.core.dto.user.ReqAuthenticationDTO;
import douglas.javacrud.core.dto.user.ReqUserDTO;
import douglas.javacrud.core.dto.user.RespUserDTO;
import douglas.javacrud.core.useCases.UserUseCase;
import douglas.javacrud.infra.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "Usuários", description = "Gerenciamento de usuários")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserUseCase userUseCase;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/ping")
    @Operation(summary = "Return pong")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @PostMapping("/register")
    @Operation(summary = "Add new User")
    public ResponseEntity<RespUserDTO> registerUser(@RequestBody ReqUserDTO user) {
        RespUserDTO userDTO = userUseCase.registerNewUser(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> getProtectedResource(@RequestBody ReqAuthenticationDTO loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());

        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        Map<String, Object> body = new HashMap<>();
        body.put("token", authenticationService.authenticate(authentication));

        return ResponseEntity.ok().body(body);
    }
}
