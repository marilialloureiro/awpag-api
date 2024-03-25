**Spring REST Project - AWPag**

1.	Para criar o projeto foi utilizado o Spring Initializr (https://start.spring.io/)
  - Projeto Maven
  - Linguagem: Java
  - Utilizado a última versão do Spring Boot
  - Packaging: Jar

2.	Ferramentas utlizadas:
- IDE: IntelliJ;
- Ferramenta de Teste: Postman;
- Banco de Dados: MySQL;
- Manutenção do BD: Flyway (módulo gratuito)

3. Todas as dependências foram adicionadas no arquivo pom.xml <dependency></dependency>

**DESENVOLVIMENTO DO PROJETO**

1.	Criar o projeto com Spring Initializr

2.	Implementar Collection Resource (Arquivo Controller com os métodos HTTP)
  a.	Métodos:
- GET (obter a representação de algo / requisição de busca)
- POST (envio da dados para o servidor)
- PUT (atualização de dados)
- DELETE (exclusão de dados)

3.	Configurar as propriedades em application.properties para criar o Schema no BD

spring.datasource.url=jdbc:mysql://localhost:3306/awpag?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=*******
spring.jpa.show-sql=true'

4.	Com as  propriedades acima adicionadas no projeto, ao dar um Refresh no BD, o database estará alocado no BD

5.	Adicionar as dependências Flyway para manutenção do BD

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-core</artifactId>
</dependency>

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-mysql</artifactId>
</dependency>

6.	Criar arquivos de migração > package > db/migration
- Arquivo deve ser criado com o padrão V00X__nome-tabela.sql
 
7.	Cria a tabela : no caso do projeto “cria-tabela-cliente”
DICA: realizado primeiro o create table no BD para ver se está tudo funcionando, em caso afirmativo, copia o código, realiza drop table, e coloca o código dentro da pasta de criação do db/migration
NOTA: Caso precise alterar algum nome na tabela, o ideal é criar uma nova migration

8.	Persistência de dados > Jakarta Persistence (JPA) > Especificações para projetos em Java, é preciso adicionar uma dependência, e utiliza-se através de anotações @ no código
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

9.	Para as validações realizadas no projeto: Jakarta Validation; é preciso adicionar sua dependência; e utiliza-se através de anotações @ no código
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-validation</artifactId>
</dependency>


