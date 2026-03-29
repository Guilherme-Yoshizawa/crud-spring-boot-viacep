# Atividade M1 - CRUD com Spring Boot

## Sobre o projeto
Projeto CRUD desenvolvido com Java, Spring Boot e PostgreSQL.

## Alterações realizadas na atividade

### Banco de dados
- Adicionado o campo `distribution_center` na tabela `product` via script Flyway
- Campo populado com 3 valores possíveis: `Mogi das Cruzes`, `Recife` e `Porto Alegre`

### Entidade
- Adicionado o campo `distributionCenter` na classe `Product`

### Service
- Criado o `ViaCepService` que faz integração com a API do ViaCEP
- A partir de um CEP, busca a cidade correspondente e compara com o `distribution_center` do produto
- Retorna `true` se a cidade bater, `false` caso contrário

### Endpoint
- Criado o endpoint `GET /product/disponibilidade`
- Recebe `cep` e `productId` como parâmetros
- Exemplo: `http://localhost:8080/product/disponibilidade?cep=08780100&productId=p1`

## Como rodar o projeto

### Pré-requisitos
- Java 17+
- PostgreSQL
- Maven

### Configuração do banco
1. Renomeie o arquivo `application.properties.example` para `application.properties`
2. Substitua `USER` e `SENHA` com suas credenciais do PostgreSQL
3. Certifique que o banco `product` está criado no PostgreSQL

### Rodando a aplicação
1. Abra o projeto no IntelliJ
2. Clique no botão **Run** (▶) no canto superior direito
3. O Flyway vai rodar os scripts automaticamente ao subir a aplicação

## Tecnologias utilizadas
- Java
- Spring Boot
- PostgreSQL
- Flyway
- ViaCEP API
