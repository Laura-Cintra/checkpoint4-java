# CRUD de Usuários com SSR, Spring Boot e Thymeleaf

Este projeto é uma aplicação **Spring Boot** que implementa um **CRUD** de usuários, utilizando **Server-Side Rendering (SSR)** com **Thymeleaf** para a interface.

## 🚀 Como Acessar a Aplicação

A aplicação será iniciada na porta 8080. O ponto de entrada principal é a listagem:

| Funcionalidade | Endpoint |
| :--- | :--- |
| **Listar Usuários (READ)** | `http://localhost:8080/users` |

**Nota**: O projeto inclui o `UserRunner.java` para popular o banco de dados com **5 usuários de exemplo** na inicialização.

-----

## ✨ Funcionalidades do CRUD (Thymeleaf)

Todas as funcionalidades são acessadas a partir da listagem através de botões e **ícones de ação**:

| Ação | Template | Ícone/Botão | Detalhes |
| :--- | :--- | :--- | :--- |
| **Listar** | `list.html` | — | Tabela principal do CRUD. |
| **Criar** | `form.html` | "Novo Usuário" | Formulário de cadastro. |
| **Visualizar** | `view.html` | **👁️** | Exibe detalhes (senha mascarada com `*`). |
| **Editar** | `form.html` | **✏️** | Formulário de edição. |
| **Excluir** | `list.html` | **🗑️** | Exclusão com diálogo de confirmação customizado. |

-----

## 💻 Arquitetura (Spring Boot)

O módulo de usuários segue o padrão em camadas e usa **UUID** como chave primária.

### Componentes Chave

  * **`User.java` (Entidade)**: Mapeada para a tabela `USERS`. Possui validações Jakarta (`@NotBlank`, `@Email`, `@Size`).
  * **`UserEditDTO.java` (DTO)**: Usado no *Update*. Permite que o campo `password` seja **opcional** ao editar, aplicando a validação de mínimo de 6 caracteres apenas se for preenchido.
  * **`UserRepository.java`**: Interface Spring Data JPA para acesso ao banco.
  * **`UserServiceImpl.java`**: Camada de serviço com regras de negócio.
  * **`UserController.java` (Controller)**: Gerencia o fluxo das requisições, delegando a lógica para o `UserService`.

-----

## 👤 Integrante

| Nome | RM | GitHub |
| :--- | :--- | :--- |
| **Laura de Oliveira Cintra** | 558843 | [@Laura-Cintra](https://github.com/Laura-Cintra) |
