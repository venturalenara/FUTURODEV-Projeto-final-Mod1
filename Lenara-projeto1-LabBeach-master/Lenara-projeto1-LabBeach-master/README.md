# Lenara-projeto1-LabBeach
Projeto avaliativo do módulo 1 do curso FuturoDEV, de autoria de Lenara Ventura.

O projeto consiste em desenvolver uma aplicação para controle das praias da cidade de Florianópolis-SC.
É um desafio prático,para criar o back-end de um sistema de lista de praias.

OS REQUISITOS DA APLICAÇÃO SÃO:

Utilização correta do GitHub e escrita do Readme.md
Cadastro de bairro
Listagem de bairro
Exclusão de bairro
Cadastro de praia
Listagem de praias
Edição de praias por identificador
Exclusão de um praias por identificador
Listagem de praias conforme o status
Listagem de praias com acessibilidade
Listagens de praias por população no bairro
Documentação de código

O ROTEIRO DA APLICAÇÃO

Requisito geral da aplicação:
Utilização de Spring: Boot, MVC, Data
Criação de API Rest
Utilização de Git com GitHub
Uso do banco de dados PostgreSQL

Cadastro de bairro:
Não permitir cadastro duplicado
Não permitir cadastro com campos inválidos

Campos necessários:
Identificador da categoria: Único, autogerado.
Nome do bairro: Única, tipo texto, preenchimento obrigatório.
Descrição do bairro: Tipo texto, preenchimento não obrigatório.
População do bairro: Tipo inteiro, preenchimento não obrigatório.

Listagem de bairros:
Listar todas os bairros cadastrados com seus respectivos campos

Exclusão de bairro:
Deletar um bairro por identificador
Não permitir deletar um bairro caso tenha uma praia cadastrada.

Cadastro de praia:
Não permitir cadastro duplicado
Não permitir cadastro com campos inválidos

Campos necessários:
Identificador da praia: Único, autogerado
Identificador do bairro: Utilizar categoria válida e já criada
Nome da praia: Tipo texto, preenchimento obrigatório
Possui acessibilidade: Tipo booleano, preenchimento obrigatório
Status da praia (própria, imprópria): Tipo texto, preenchimento obrigatório.

Listagem de praias:
Listar todos as praias cadastradas com seus respectivos campos.

Edição de praia:
Editar as informações da praia por identificador.

Exclusão de praia:
Deletar uma praia por identificador.

Listagem de praias conforme o status
Listar praias conforme o status (própria ou imprópria)

Listagem de praias com acessibilidade
Listar praias por acessibilidade ( verdadeiro ou falso ) 

Listagens de praias por população no bairro
Listar praias com população até um certo número definido pelo usuário.
Ex. praias em bairros com população até 15000 pessoas.

Para iniciar a aplicação:

1. Configurar o arquivo application.properties na IDE:
spring.jpa.database=POSTGRESQL
spring.datasource.platform=postgres
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.database.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/LenaraProjeto1LabBeach
spring.datasource.username= "seu username"
spring.datasource.password= "sua senha"
server.port=8080

2. Clicar o BD LenaraProjeto1LabBeach no postgres.

3. Baixar o arquivo da coleção e adicionar no Insomnia 
nome: Insomnia_2023-02-25


