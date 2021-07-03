
# Pets API Project

## About This Project:

Pets API is a Java REST API, with IntelliJ IDEA Community Edition using Spring Framework featuring JPA, Lombok, H2 Database. 

### Projeto Pets API

Neste projeto foi desenvolvido um pequeno sistema para o gerenciamento de Pets de um PetShop através de uma API REST, criada com o Spring Boot.

Foram abordados os seguintes tópicos:

    * Setup inicial de projeto com o Spring Boot Initialzr;
    * Criação de modelo de dados para o mapeamento de entidades em bancos de dados;
    * Desenvolvimento de operações de gerenciamento de Pets (Cadastro, leitura, atualização e remoção de Pets);
    * Relação de cada uma das operações acima com o padrão arquitetural REST;
    * Desenvolvimento de testes unitários para validação das funcionalidades;
    * Implantação do sistema na nuvem através do Heroku.

Para executar o projeto no terminal, digite o seguinte comando:

mvn spring-boot:run

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

http://localhost:8080/api/v1/pet

São necessários os seguintes pré-requisitos para a execução do projeto:

    * Java 11 ou versões superiores.
    * Maven 3.6.3 ou versões superiores.
    * IntelliJ IDEA Community Edition ou sua IDE favorita.
    * Controle de versão GIT instalado na sua máquina.
    * Conta no GitHub para o armazenamento do seu projeto na nuvem.
    * Conta no Heroku para o deploy do projeto na nuvem