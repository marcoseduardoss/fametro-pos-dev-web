# Projeto Base para Pós-Graduação em Engenharia de Software - Unifametro

Este projeto é um template para os alunos da pós-graduação em engenharia de software da Fametro. Ele usa Spring Boot para a construção de uma API REST. Os alunos devem substituir as classes de modelo (`Xpto` e suas variações) por entidades de negócio específicas do projeto de cada grupo.

## Demonstração do Projeto

Veja abaixo um GIF demonstrando como abrir e executar os projetos no Eclipse e Visual Studio Code.

![Demonstração do Projeto](animacao.gif)

## Substituição de Classes e Atributos

- Substitua `Xpto`, `xpto`, `valor1`, `valor2` e `valor3` por nomes e atributos relevantes às entidades de negócio do seu projeto. Lembre-se de manter a consistência de maiúsculas e minúsculas conforme convenções do Java: CamelCase.

## Configuração do Ambiente

### Pré-requisitos

- Java 17
- Maven
- IDE de sua preferência ou Eclipse STS (utilizado em sala)
- Git

### Configurando o Eclipse ou outra IDE

1. Instale o Eclipse da [página oficial](https://www.eclipse.org/downloads/).
2. Importe o projeto: `File > Import > Existing Maven Projects`.
3. Navegue até a pasta do projeto e selecione-a para importação.
4. Na primeira execução, é neccessário escolher a classe `Main.java` do projeto.

### Clonando o Repositório

Para obter o projeto, use o seguinte comando do Git:

```bash
git clone https://github.com/marcoseduardoss/fametro-pos-dev-web/tree/main/demo-backend-springboot-jpa
```
## Executando o Projeto

### Via Linha de Comando

Na raiz do projeto, execute:

```bash
mvn spring-boot:run
```

Para construir o JAR e executá-lo:

```bash
mvn clean package
java -jar target/exemplo-backend-springboot-jdbc-0.0.1-SNAPSHOT.jar
```

### Acessando o Banco de Dados

H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

Use as configurações padrão do H2, a menos que tenha modificado as propriedades `spring.datasource` no `application.properties`.

### Acessando a Documentação API via Swagger

Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)



## Instalação do Java e Maven no Windows

### Instalação do Java

1. **Baixe o Java JDK 17:**
   - Acesse a [página de download do Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) e baixe a versão apropriada para Windows.

2. **Instale o Java JDK:**
   - Execute o arquivo baixado e siga as instruções de instalação. Certifique-se de escolher um caminho de instalação conhecido, pois você precisará referenciá-lo mais tarde.

3. **Configurar variáveis de ambiente:**
   - Clique com o botão direito em 'Este PC' e vá em 'Propriedades' > 'Configurações avançadas do sistema' > 'Variáveis de Ambiente'.
   - Em 'Variáveis do sistema', clique em 'Novo' e adicione uma nova variável chamada `JAVA_HOME` com o caminho para o diretório onde o Java foi instalado (ex: `C:\Program Files\Java\jdk-17`).
   - Localize a variável `Path` em 'Variáveis do sistema', clique em 'Editar' e adicione o seguinte ao final do valor: `;%JAVA_HOME%\bin`.

4. **Verificar a instalação do Java:**
   - Abra o CMD (Prompt de Comando) e digite:
     ```bash
     java -version
     ```
   - A versão instalada do Java deve aparecer, confirmando que o Java está corretamente instalado e configurado.

### Instalação do Maven

1. **Baixe o Maven:**
   - Acesse a [página de download do Maven](https://maven.apache.org/download.cgi) e baixe a versão binária mais recente do Apache Maven em formato zip.

2. **Descompacte o Maven:**
   - Extraia o conteúdo do arquivo zip para um diretório de sua escolha (ex: `C:\Maven`).

3. **Configurar variáveis de ambiente para o Maven:**
   - Siga os mesmos passos da instalação do Java para adicionar uma nova variável de ambiente chamada `M2_HOME` apontando para o diretório onde o Maven foi descompactado (ex: `C:\Maven`).
   - Adicione o caminho para o binário do Maven ao `Path` da seguinte forma: `;%M2_HOME%\bin`.

4. **Verificar a instalação do Maven:**
   - Abra um novo CMD (Prompt de Comando) e digite:
     ```bash
     mvn -version
     ```
   - A versão do Maven instalada e detalhes sobre o ambiente Java devem aparecer, confirmando que o Maven está corretamente instalado e configurado.

### Observações sobre o Eclipse

- **Uso do Eclipse:** O Eclipse IDE vem com um ambiente Java próprio (JDT - Java Development Tools), que inclui um compilador Java (javac). Portanto, não é estritamente necessário instalar o JDK para projetos básicos dentro do Eclipse, embora possa ser necessário para recursos avançados ou configurações específicas.
- **Maven no Eclipse:** O Eclipse também suporta o Maven internamente através do plugin 'm2e' (Maven Integration for Eclipse), o que elimina a necessidade de instalação manual do Maven para a gestão de projetos dentro do IDE.

Essas instruções simplificam o processo de configuração inicial para desenvolvedores usando Windows, permitindo que se concentrem mais no desenvolvimento e menos na configuração do ambiente.

## Arquitetura do Projeto

Este projeto utiliza o Spring Boot como base para a criação de uma aplicação web robusta e escalável. A seguir, estão detalhados os principais componentes da arquitetura do projeto e como eles interagem entre si.

### Componentes Principais

1. **Spring Boot:**
   - **Framework:** Utilizado para simplificar a configuração inicial e o desenvolvimento de novas aplicações Spring, oferecendo configurações padrão de aplicativos e suporte a diversos tipos de infraestrutura.
   - **Autoconfiguração:** O Spring Boot configura automaticamente as dependências do projeto com base nas bibliotecas presentes no classpath.

2. **Spring Data JPA:**
   - **Repositórios:** Facilita a implementação de repositórios baseados em JPA para a persistência de dados em banco de dados SQL.
   - **Integração:** Permite a integração com a base de dados H2, proporcionando um ambiente de desenvolvimento e testes isolado e controlado.

3. **H2 Database:**
   - **Banco de Dados em Memória:** Utilizado para testes e desenvolvimento, permitindo a execução de testes de integração sem necessidade de um ambiente de banco de dados externo.
   - **Console:** Acesso via browser ao banco de dados, permitindo a visualização e manipulação direta dos dados durante o desenvolvimento.

4. **Swagger/OpenAPI:**
   - **Documentação Automática:** Geração de documentação interativa para a API desenvolvida, facilitando o teste e a integração de endpoints.
   - **UI:** Interface gráfica acessível via navegador que permite a interação com a API documentada.

### Estrutura de Diretórios

A estrutura do projeto segue o padrão Maven com a seguinte organização de pacotes e diretórios principais:

- **`src/main/java/`** - Contém o código-fonte Java do projeto, organizado em subpacotes:
  - **`config`** - Configurações gerais da aplicação, como configuração de CORS e Swagger.
  - **`controller`** - Controladores REST que expõem os endpoints da API.
  - **`dto`** - Data Transfer Objects que facilitam a transferência de dados entre subcamadas.
  - **`mapper`** - Mapeadores para conversão entre entidades e DTOs.
  - **`model`** - Entidades JPA que representam as tabelas do banco de dados.
  - **`repository`** - Interfaces do Spring Data JPA para acesso ao banco de dados.
  - **`service`** - Serviços que contêm a lógica de negócio.
  - **`exception`** - Classes para tratamento de exceções personalizadas.

- **`src/main/resources/`**:
  - **`application.properties`** - Configurações da aplicação, incluindo dados de conexão com o banco de dados e parâmetros de inicialização do Spring Boot.
  - **`schema.sql`** e **`data.sql`** - Scripts SQL para criação de tabelas e inserção de dados iniciais no banco de dados H2.

### Fluxo de Dados

O fluxo de dados no projeto segue o padrão MVC (Model-View-Controller), organizado da seguinte forma:

- **Controller:** Recebe as requisições HTTP, delega a execução das operações para os serviços e retorna as respostas adequadas.
- **Service:** Contém a lógica de negócio, fazendo chamadas aos repositórios para interagir com o banco de dados.
- **Repository:** Interface entre a lógica de negócio e o banco de dados, utilizando o Spring Data JPA para facilitar a implementação.
- **Model:** Define as entidades que representam as tabelas do banco de dados.

Este projeto é configurado para ser fácil de adaptar e escalar, permitindo que os alunos da Fametro modifiquem e expandam conforme as necessidades do curso e projetos específicos.



