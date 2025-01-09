# Template Para Futuras Aplicações Spring-boot

Essa aplicação possui pré-configurações que têm o objetivo de servir como um molde para aplicações mais complexas, visando o crescimento e a escalabilidade.

O template segue os princípios da arquitetura Clean Code. 

Onde estudei o clean code:
- [Fernanda_Kipper](https://www.youtube.com/watch?v=ta0q7OrVxIc)

Onde estudei sobre Segurança:
- [Giuliana Bezerra](https://www.youtube.com/watch?v=kEJ8a1w4a2Q) 
- [Fernanda_Kipper](https://www.youtube.com/watch?v=5w-YCcOjPD0)

Segue as depencencias do pom.xml do projeto:
## 📦 Dependencies
### Spring Boot Starters
- Spring Boot Starters
- spring-boot-starter-data-jdbc: Provides support for JDBC repositories.
- spring-boot-starter-web: Used to build web applications (including RESTful services).
- spring-boot-starter-security: Provides security features for your application.
- spring-boot-starter-data-jpa: Adds support for JPA-based data access.
- spring-boot-starter-oauth2-resource-server: Enables the OAuth 2.0 Resource Server features.
- spring-boot-starter-webflux: Provides support for reactive web applications.

## Security & JWT

- ava-jwt (com.auth0: 4.4.0): Library for creating and validating JSON Web Tokens (JWT).
Validation
- hibernate-validator (8.0.2.Final): Provides support for validating Java Beans using the Bean Validation 2.0 (JSR 380) API.

## Database

- mysql-connector-java (8.0.33): JDBC driver for MySQL.
- h2: Embedded in-memory database, used for development and testing.

## Documentation
- springdoc-openapi-starter-webmvc-ui (2.7.0): Integrates OpenAPI documentation with Swagger UI for your Spring application.

## Utility
- lombok (1.18.36): Reduces boilerplate code by providing annotations to generate getters, setters, constructors, etc.
- spring-boot-devtools: Provides development-time features, such as automatic restarts.

## 🗂️ Entidades Implementadas

- User
- Employee


## 🗄️ Database
Comando para executar o banco de dados pelo docker

```bash
        docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=my_db -p 3306:3306 -d mysql:latest
```

## 🔐 Security

O template já está configurado para permitir acesso às rotas de User, enquanto as demais rotas exigem um token JWT para acesso.

A implementação de JWT foi realizada utilizando o OAuth2, seguindo práticas modernas de segurança.

## 📄 Swagger Config

No Security foi configurada uma whitelist que permite requisições ao Swagger UI para melhor documentação das rotas.

Acesse: http://localhost:7070/v3/swagger-ui/index.html#/


## ⚠️ Exceptions
As exceptions são manipuladas por um handler global que trata erros relacionados às entidades User, Employee e erros genéricos.
