```markdown
# 🐞 Sistema de Gerenciamento de Insetos (EntomologiaProject)

Bem-vindo ao **EntomologiaProject**, uma API REST desenvolvida em **Spring Boot** com **PostgreSQL**, dockerizada e pronta para uso com Swagger UI, voltada para o gerenciamento de insetos do acervo do Laboratório de Entomologia da UnDF.

## 🚀 Novos Recursos Adicionados
- 🐳 Configuração Docker completa (aplicação + PostgreSQL + pgAdmin)
- 📊 Swagger UI integrado para documentação interativa
- 🔄 Migrações automáticas com Flyway

---

## ⚙️ Tecnologias utilizadas

- ☕ Java 17  
- 🌱 Spring Boot  
- 🌐 Spring Web  
- 🛢️ Spring JDBC  
- 🐘 PostgreSQL  
- 🚀 Flyway (migrations)  
- 📦 Maven  
- 🐳 Docker  
- 📊 Swagger UI  

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

## 🐳 Como rodar com Docker (Recomendado)

### Pré-requisitos
- Docker Desktop instalado e rodando
- Docker Compose instalado

### Passo a passo

1. **Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/entomologia-project.git
cd entomologia-project
```

2. **Configure as variáveis de ambiente (opcional)**
   Edite o arquivo `.env` se quiser alterar credenciais padrão

3. **Suba os containers:**
```bash
docker-compose up -d --build
```

4. **Acesse os serviços:**
    - API: http://localhost:8084
    - Swagger UI: http://localhost:8084/swagger-ui/index.html
    - pgAdmin: http://localhost:8081 (email: admin@admin.com, senha: admin)
    - PostgreSQL: porta 5432 (acessível via pgAdmin)

5. **Para parar os containers:**
```bash
docker-compose down
```

---

## 📊 Documentação da API (Swagger UI)

Acesse a interface interativa do Swagger para explorar e testar todos os endpoints:

🔗 [http://localhost:8084/swagger-ui/index.html](http://localhost:8084/swagger-ui/index.html)

### Principais endpoints no Swagger:
- `/api/insetos` - CRUD de insetos
- `/api/imagens` - Upload e gerenciamento de imagens
- `/api/imagens/inseto/{id}` - Busca imagens por inseto

---

## 💻 Como rodar o projeto localmente (sem Docker)

### 🐘 Pré-requisitos
- Java 17 JDK
- PostgreSQL 15+
- Maven

### Configuração manual

1. **Crie o banco de dados:**
```sql
CREATE DATABASE entomologia;
```

2. **Configure o application.properties:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/entomologia
spring.datasource.username=postgres
spring.datasource.password=postgres
```

3. **Execute a aplicação:**
```bash
./mvnw spring-boot:run
```

Acesse:  
📍 `http://localhost:8084`  
📊 Swagger UI: `http://localhost:8084/swagger-ui/index.html`

---

## 🔎 Visualização de imagens

### 📁 Por ID (exibição ou download)
```
GET http://localhost:8084/api/imagens/1
```

### 🧬 Por Base64 (JSON)
```
GET http://localhost:8084/api/imagens/inseto/{idInseto}
```

#### 👁️ Como visualizar base64:
1. Copie o valor base64 do campo `dados`
2. Use: [https://codebeautify.org/base64-to-image-converter](https://codebeautify.org/base64-to-image-converter)
3. Ou use em HTML:
```html
<img src="data:image/jpeg;base64,suaStringBase64Aqui" />
```

---

## 🛠️ Ferramentas úteis

- [Postman](https://www.postman.com/)
- [Hoppscotch](https://hoppscotch.io)
- [Docker Desktop](https://www.docker.com/products/docker-desktop)
- [pgAdmin](https://www.pgadmin.org/)

---

## 👨‍💻 Autor

**João Pedro Varela Borges**  
🎓 Estudante de Sistemas de Informação - UnDF

## 📜 Licença

MIT License - Veja [LICENSE](LICENSE) para detalhes.

---

## ⁉️ Suporte

Problemas com Docker? Verifique:
1. Se o Docker Desktop está rodando
2. Se as portas 8084 (API), 5432 (PostgreSQL) e 8081 (pgAdmin) estão disponíveis
3. Execute `docker-compose logs` para ver logs detalhados
```