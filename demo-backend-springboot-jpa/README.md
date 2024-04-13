# Projeto Base 

### Estrutura do Projeto

Este projeto segue uma estrutura de pacotes típica para uma aplicação Spring Boot de três camadas:

```java
com.example.app
├─ apresentacao
│ ├─ controller
│ └─ dto
│ └─ exception
├─ negocio
│ ├─ service
│ └─ model
├─ persistencia
│ ├─ repository
│ └─ entity
├─ config
├─ security
├─ util
└─ Application.java
```

### Descrição dos Pacotes

`apresentacao`:Camada de apresentação
  - `controller`: Contém os controladores que lidam com as requisições HTTP.
  - `dto`: Contém os Data Transfer Objects (DTOs) para transferência de dados entre camadas.
  - `exception`: Contém classes relacionadas ao tratamento de exceções.

`negocio`:Camada de Neógócio
  - `service`: Contém a lógica de negócios da aplicação (serviços).
  - `model`: Contém os modelos de dados (entidades).

`persistencia`: Camada de persitência. Contém as interfaces de repositório para acesso a dados e/ou as entidades que representam os objetos no banco de dados.

`config`: Contém as configurações da aplicação.

`security`: Contém as configurações e componentes relacionados à segurança da aplicação.

`util`: Contém utilitários e classes de utilidade.

### Pré-requisitos

- [Java](https://www.java.com/) (versão X.X ou superior)
- [Maven](https://maven.apache.org/) (versão X.X ou superior)
- [Spring Boot](https://spring.io/projects/spring-boot) (versão X.X ou superior)

### Configuração e Uso

Descreva como configurar e usar o projeto. Inclua instruções detalhadas, comandos ou exemplos, se necessário.



## Licença

Este projeto está licenciado sob a Licença [Nome da Licença] - consulte o arquivo [LICENSE.md](LICENSE.md) para obter detalhes.
