<h1 align="center">
  Sistema Mercado
</h1>

API para cadastro de itens em um mercado (CRUD).

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

A API poderá ser acessada em [localhost:8080](http://localhost:8080)

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


Para fazer as requisições HTTP abaixo, deverá visualizar pela documentação Swagger acima.

- Criar Tarefa (POST)
```
[
  {
    "nome": "Arroz 5KG",
    "preco": 10.99,
    "quantidade": 3
  }
]
```

- Listar Tarefas (GET)
```
[
  {
    "id": 1,
    "nome": "Arroz 5KG",
    "preco": 10.99,
    "quantidade": 3,
    "valorTotal": 32.97
  }
]
```

- Atualizar Tarefa (UPDATE)
```
[
  {
    "nome": "Arroz Integral",
    "preco": 10.99,
    "quantidade": 3
  }
]
```

- Remover Tarefa (DELETE)
```
    Digitar apenas o ID da tarefa.
```