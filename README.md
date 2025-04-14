# Encurtador de URL
Este projeto é uma aplicação Java com Spring Boot que permite encurtar URLs longas, gerando links curtos e únicos com base no ID da URL armazenado no banco de dados. Ele utiliza codificação Base62 para transformar o ID numérico em um identificador curto e reutilizável.

# Funcionalidades
- Encurtar URLs longas em links curtos e semi personalizados.

- Redirecionar automaticamente a URL curta para a original.

- Listar todas as URLs encurtadas (endpoint /api/todas).

- Armazena os dados no MySQL com JPA/Hibernate.

- Arquivo application.properties configurado para uso local.

# Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

# Como usar
- Clone o repositório.
- Certifique-se de que o MySQL está rodando localmente.
- Altere a baseUrl no application.properties para o seu domínio (ex: https://meulink.com/).
- Rode a aplicação com o comando mvn spring-boot:run ou direto pela sua IDE.

# Exemplos de uso com Postman
## Encurtar URL:
Método: POST
Endpoint: http://localhost:8080/api
Body (JSON): { "originalUrl": "https://www.google.com" }

## Redirecionar:
Método: GET
Endpoint: http://localhost:8080/api/{codigo}

## Listar todas:
Método: GET
Endpoint: http://localhost:8080/api/todas

# Futuras atualizações
- Melhorar os Exceptions
- Criar um Docker-compose para facilitar as execuções do aplicativo
- Hospedar o aplicativo em uma nuvem, para que fique disponivel 24h
