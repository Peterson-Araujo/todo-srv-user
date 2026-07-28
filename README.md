# 👤 User Service

Microsserviço responsável pelo gerenciamento de usuários de um sistema de gerenciamento de tarefas.

## 📋 Sobre o projeto

O **User Service** fornece as funcionalidades necessárias para o cadastro e gerenciamento de usuários, além de servir como base para autenticação e autorização dos demais serviços da aplicação.

## 🚀 Funcionalidades

* Cadastro de usuários
* Busca de usuários
* Atualização de dados
* Exclusão de usuários
* Validação de dados
* Persistência em banco de dados PostgreSQL

## 🛠️ Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Maven
* Docker
* Docker Compose
* Lombok

## ▶️ Executando o projeto

### Pré-requisitos

* Java 17
* Maven 3.9+
* Docker
* Docker Compose

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/user-service.git
```

### Inicie o banco de dados

```bash
docker compose up -d
```

### Execute a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## 📌 Próximas implementações

* Autenticação com JWT
* Criptografia de senhas (BCrypt)
* Controle de permissões (Roles)
* Testes unitários
* Testes de integração
* Documentação com OpenAPI/Swagger
* Integração com o Task Service

## 👨‍💻 Autor

Desenvolvido por **Peterson Araujo**.
