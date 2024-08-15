# Pizzaria API

Bem-vindo ao projeto da API de Pizzaria! Este projeto oferece uma API RESTful para gerenciar pedidos de pizza, cardápio e clientes.

## Índice

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração](#configuração)
- [Como Usar](#como-usar)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Descrição

Esta API de pizzaria permite que você:

- Adicione e gerencie pizzas no cardápio.
- Faça e gerencie pedidos de pizza.
- Gerencie informações dos clientes.

A API segue os princípios RESTful, facilitando a integração com outras aplicações e serviços.

## Funcionalidades

- **Gerenciamento de Pizzas**: Adicionar, atualizar, remover e listar pizzas.
- **Gerenciamento de Pedidos**: Criar, atualizar e listar pedidos de pizza.
- **Gerenciamento de Clientes**: Adicionar, atualizar e listar informações dos clientes.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para criação de aplicações Java baseadas em Spring.
- **Spring Data JPA**: Para interação com o banco de dados.
- **PostgreSQL**: Banco de dados relacional.
- **JUnit**: Framework de testes.
- **Swagger**: Para documentação da API.

## Configuração

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/seu-usuario/pizzaria-api.git
   
# 

2. **Navegue para o Diretório do Projeto**

   ```bash
   cd pizzaria-api
   
# 

3. **Configurar o Banco de Dados**
   
*Edite o arquivo 'src/main/resources/application.properties' para configurar a conexão com seu banco de dados PostgreSQL.*

  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/pizzaria
  spring.datasource.username=seu-usuario
  spring.datasource.password=sua-senha
  ```   
#

## Como Usar

A API está disponível em http://localhost:8080. Você pode usar o Swagger UI para explorar os endpoints e testar a API.

1. Listar Pizzas

  ```bash
  GET /pizzas
  ```

2. Adicionar uma Nova Pizza

  ```bash
  POST /pizzas
  Content-Type: application/json

  {
    "nome": "Margherita",
    "preco": 29.99
  }
  ```

3. Criar um Novo Pedido

  ```bash
  POST /pedidos
  Content-Type: application/json

  {
    "clienteId": 1,
    "pizzas": [
      { "id": 1, "quantidade": 2 }
    ]
  }
```

#

## Testes
Os testes automatizados estão localizados no diretório src/test/java. Para executar os testes, use:

  ```bash
  ./mvnw test
  ```

## Contribuição
Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto.
2. Crie uma nova branch ('git checkout -b feature/nova-feature').
3. Faça suas alterações e commit ('git commit -am 'Adiciona nova feature'').
4. Faça um push para a branch ('git push origin feature/nova-feature').
5. Abra um pull request.

