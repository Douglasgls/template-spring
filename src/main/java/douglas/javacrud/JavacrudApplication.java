package douglas.javacrud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;


@EnableJdbcAuditing
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "CRUD-USER",description = "Crud completo com auteticação de usuários e gerenciamento de funcionarios",version = "v0"))
public class JavacrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavacrudApplication.class, args);
	}

}
