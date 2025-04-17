```markdown
# 🐞 Sistema de Gerenciamento de Insetos

Bem-vindo ao **EntomologiaProject**, uma API REST desenvolvida em **Spring Boot** com **PostgreSQL**, voltada para o **gerenciamento de insetos** do acervo do Laboratório de Entomologia da UnDF.

O sistema permite cadastrar informações completas sobre insetos, como nome, espécie, características, e também associar **imagens** que podem ser visualizadas diretamente via navegador ou renderizadas em base64.

---

## ⚙️ Tecnologias utilizadas

- ☕ Java 17  
- 🌱 Spring Boot  
- 🌐 Spring Web  
- 🛢️ Spring JDBC  
- 🐘 PostgreSQL  
- 🚀 Flyway (migrations)  
- 📦 Maven  

---

## 🚀 Funcionalidades principais

- 📌 Cadastro de insetos com seus respectivos dados
- 🖼️ Upload e associação de múltiplas imagens por inseto
- 🔍 Visualização de imagens:
  - Por **base64**, ideal para exibir diretamente no front-end
  - Por **bytes binários**, permitindo abrir diretamente no navegador ou baixar
- 📂 Organização das imagens por inseto
- ✏️ Edição e exclusão de registros

---

## 📂 Documentação da API (Swagger)

Acesse a interface interativa do Swagger para explorar todos os endpoints disponíveis:

🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 💻 Como rodar o projeto localmente

### 🐘 Pré-requisitos

- PostgreSQL instalado e rodando
- Criar o banco de dados:

```sql
CREATE DATABASE entomologia;
```

### 🛠️ Passos

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/nome-do-projeto.git
cd nome-do-projeto
```

2. **Configure o banco no `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/entomologia
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. **Execute a aplicação:**

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
📍 `http://localhost:8080`

---

## 🔎 Visualização de imagens

### 📁 Por ID (exibição ou download)

Acesse diretamente no navegador:

```
GET http://localhost:8080/api/imagens/1
```

O navegador irá baixar a imagem automaticamente se o `content-type` estiver correto.

---

### 🧬 Por Base64 (útil para uso em páginas HTML)

```
GET http://localhost:8080/api/imagens/inseto/{idInseto}
```

A resposta conterá um JSON com campos como `nomeArquivo`, `tipo`, e `dados` (em base64).

#### 👁️ Como visualizar

1. Copie o valor base64 do campo `dados`.
2. Acesse: [https://codebeautify.org/base64-to-image-converter](https://codebeautify.org/base64-to-image-converter)
3. Cole o conteúdo e visualize a imagem.

#### 💡 Exemplo de uso em HTML:

```html
<img src="data:image/jpeg;base64,suaStringBase64Aqui" />
```

---

## 🧪 Ferramentas para testes

- [Postman](https://www.postman.com/)
- [Hoppscotch (alternativa online)](https://hoppscotch.io)
- [CodeBeautify - Base64 to Image](https://codebeautify.org/base64-to-image-converter)
- 🔗 `http://localhost:8080/swagger-ui/index.html`

---

## 👨‍💻 Autor

**João Pedro Varela Borges**  
🎓 Estudante de Sistemas de Informação - UnDF
---

## 📜 Licença

Este projeto está licenciado sob a **MIT License**.  
Consulte o arquivo [`LICENSE`](LICENSE) para mais detalhes.

---

```
