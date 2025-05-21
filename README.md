````markdown
# 🐞 EntomologiaProject

Bem-vindo ao **EntomologiaProject**, uma poderosa **API REST** desenvolvida com **Spring Boot** e **PostgreSQL**, projetada para gerenciar o acervo de **insetos** do Laboratório de Entomologia da **UnDF**.

Com este sistema, é possível cadastrar, editar e visualizar detalhes dos insetos, além de associar e exibir múltiplas imagens — tanto em formato binário quanto em base64.

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia     | Descrição                          |
|----------------|------------------------------------|
| ☕ Java 17      | Linguagem principal                |
| 🌱 Spring Boot  | Framework principal da aplicação   |
| 🌐 Spring Web   | Suporte a REST APIs                |
| 🛢️ Spring JDBC  | Acesso direto ao banco relacional |
| 🐘 PostgreSQL   | Banco de dados relacional         |
| 🚀 Flyway       | Migrações automáticas de schema   |
| 📦 Maven        | Gerenciador de dependências       |

---

## 🚀 Funcionalidades

- 📌 **Cadastro completo de insetos** com nome, espécie e características
- 🖼️ **Upload de múltiplas imagens** por inseto
- 🔍 **Visualização de imagens**:
  - Em **base64** (ideal para integração com front-end)
  - Em **formato binário** (acesso direto via navegador ou download)
- 📂 **Organização das imagens** por inseto
- ✏️ **Edição e exclusão** de registros de insetos e imagens

---

## 📘 Documentação da API

Acesse a documentação interativa do Swagger:

🔗 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

---

## 💻 Como Rodar o Projeto Localmente

### 🐘 Pré-requisitos

- PostgreSQL instalado e em execução
- Criação do banco:

```sql
CREATE DATABASE entomologia;
````

---

### 🛠️ Passo a Passo

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/nome-do-projeto.git
cd nome-do-projeto
```

2. **Configure o acesso ao banco em `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/entomologia
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

📍 Acesse: `http://localhost:8080`

---

## 🔎 Como Visualizar as Imagens

### 📁 Exibição ou Download por ID

```http
GET http://localhost:8080/api/imagens/1
```

* O navegador fará o download automático se o `Content-Type` for compatível.

---

### 🧬 Visualização por Base64 (via JSON)

```http
GET http://localhost:8080/api/imagens/inseto/{idInseto}
```

* A resposta conterá campos como `nomeArquivo`, `tipo`, e `dados` (base64).

#### 👁️ Visualização Manual

1. Copie o valor de `dados` (base64).
2. Acesse: [CodeBeautify - Base64 to Image](https://codebeautify.org/base64-to-image-converter)
3. Cole o conteúdo para visualizar a imagem.

#### 💡 Exemplo de uso em HTML:

```html
<img src="data:image/jpeg;base64,suaStringBase64Aqui" />
```

---

## 🧪 Ferramentas Recomendadas para Testes

* [Postman](https://www.postman.com/)
* [Hoppscotch (alternativa online)](https://hoppscotch.io)
* [CodeBeautify - Base64 to Image](https://codebeautify.org/base64-to-image-converter)
* 🔗 [`http://localhost:8080/swagger-ui/index.html`](http://localhost:8080/swagger-ui/index.html)

---

## 👨‍💻 Autor

**João Pedro Varela Borges**
🎓 Estudante de Sistemas de Informação - UnDF
🔗 [LinkedIn (opcional)](https://www.linkedin.com/in/seu-perfil)

---

## 📜 Licença

Distribuído sob a licença **MIT**.
Consulte o arquivo [`LICENSE`](LICENSE) para mais detalhes.

---

```
