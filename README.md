# 🐞 EntomologiaProject - Sistema de Gerenciamento de Insetos

![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

Bem-vindo ao **EntomologiaProject**, uma API REST completa para gerenciamento de acervo entomológico, desenvolvida com Spring Boot e PostgreSQL, pronta para execução em containers Docker.

## 📌 Índice

- [Visão Geral](#-visão-geral)
- [Tecnologias](#-tecnologias-utilizadas)
- [Funcionalidades](#-funcionalidades-principais)
- [Instalação com Docker](#-como-rodar-com-docker-recomendado)
   - [Pré-requisitos](#pré-requisitos)
   - [Passo a Passo](#passo-a-passo-completo)
   - [Gerenciamento de Containers](#gerenciamento-de-containers)
- [Execução Local](#-como-rodar-o-projeto-localmente)
- [Documentação da API](#-documentação-da-api-swagger-ui)
- [Visualização de Imagens](#-visualização-de-imagens)
- [Ferramentas Úteis](#-ferramentas-úteis)
- [Solução de Problemas](#-solução-de-problemas)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 🌍 Visão Geral

Sistema completo para cadastro e gerenciamento de insetos do acervo do Laboratório de Entomologia, incluindo:

- CRUD completo de espécimes
- Upload e gerenciamento de imagens
- Documentação automática via Swagger
- Infraestrutura containerizada com Docker
- Banco de dados PostgreSQL com pgAdmin

---

## ⚙️ Tecnologias Utilizadas

| Categoria         | Tecnologias                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| Backend           | Java 17, Spring Boot 3.x, Spring Data JPA, Spring Web                       |
| Banco de Dados    | PostgreSQL 15, Flyway (migrations)                                         |
| Infraestrutura    | Docker, Docker Compose                                                     |
| Ferramentas       | Maven, Swagger UI, pgAdmin                                                 |
| Documentação      | OpenAPI 3.0, Markdown                                                      |

---

## 🚀 Funcionalidades Principais

- **Cadastro Completo de Insetos**
   - Dados taxonômicos
   - Características físicas
   - Localização e coleta

- **Gerenciamento de Imagens**
   - Upload múltiplo
   - Armazenamento eficiente
   - Dois modos de visualização:
      - Binário (download direto)
      - Base64 (para frontend)

- **API Documentada**
   - Swagger UI integrado
   - Esquemas OpenAPI
   - Teste interativo de endpoints

- **Infraestrutura Containerizada**
   - Serviços isolados
   - Comunicação via network dedicada
   - Facilidade de deploy

---

## 🐳 Como Rodar com Docker (Recomendado)

### Pré-requisitos

- Docker Desktop 20.10+
- Docker Compose 2.12+
- 4GB de RAM disponível

### Passo a Passo Completo

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/entomologia-project.git
cd entomologia-project
```

2. **Crie a network Docker**
```bash
docker network create entomologia_network
```

3. **Configure o ambiente (opcional)**
```bash
cp .env.example .env
# Edite o .env conforme necessário
```

4. **Inicie os containers**
```bash
docker-compose up -d --build
```

5. **Verifique o status**
```bash
docker-compose ps
```

### Acesse os Serviços

| Serviço     | URL                                   | Credenciais               |
|-------------|---------------------------------------|---------------------------|
| API         | http://localhost:8080                 | -                         |
| Swagger UI  | http://localhost:8080/swagger-ui.html | -                         |
| pgAdmin     | http://localhost:8081                 | admin@admin.com / admin   |
| PostgreSQL  | postgres:5432                         | postgres / postgres       |

### Gerenciamento de Containers

| Comando                     | Descrição                                  |
|-----------------------------|-------------------------------------------|
| `docker-compose stop`       | Para os serviços mantendo os dados        |
| `docker-compose start`      | Reinicia serviços parados                 |
| `docker-compose down`       | Remove containers mantendo volumes        |
| `docker-compose down -v`    | Remove containers e volumes               |
| `docker-compose logs -f`    | Mostra logs em tempo real                 |

---

## 💻 Como Rodar o Projeto Localmente

### Pré-requisitos

- Java 17 JDK
- Maven 3.8+
- PostgreSQL 15+
- 2GB RAM livre

### Configuração Manual

1. **Configure o banco de dados**
```sql
CREATE DATABASE entomologia;
CREATE USER entomologia_user WITH PASSWORD 'entomologia123';
GRANT ALL PRIVILEGES ON DATABASE entomologia TO entomologia_user;
```

2. **Configure o application.properties**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/entomologia
spring.datasource.username=entomologia_user
spring.datasource.password=entomologia123
```

3. **Execute a aplicação**
```bash
./mvnw spring-boot:run
```

---

## 📊 Documentação da API (Swagger UI)

Acesse a documentação interativa em:  
🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### Endpoints Principais

| Endpoint                | Método | Descrição                          |
|-------------------------|--------|------------------------------------|
| `/api/insetos`          | GET    | Lista todos os insetos             |
| `/api/insetos/{id}`     | GET    | Detalhes de um inseto específico   |
| `/api/imagens`          | POST   | Upload de novas imagens            |
| `/api/imagens/{id}`     | GET    | Download de imagem                 |

---

## 🔎 Visualização de Imagens

### Via Binário (Download)
```
GET /api/imagens/1
```
**Uso:** Acesse diretamente no navegador ou use para download

### Via Base64 (Frontend)
```
GET /api/imagens/inseto/5
```
**Resposta:**
```json
{
  "id": 1,
  "nomeArquivo": "besouro.jpg",
  "tipo": "image/jpeg",
  "dados": "base64encodedstring..."
}
```

**Exemplo HTML:**
```html
<img src="data:image/jpeg;base64,SEUDADOBA..." alt="Inseto">
```

---

## 🛠️ Ferramentas Úteis

1. **Testes de API**
   - [Postman](https://www.postman.com/)
   - [Insomnia](https://insomnia.rest/)

2. **Conversão de Imagens**
   - [Base64-Guru](https://base64.guru/converter)

3. **Gerenciamento de Banco**
   - [DBeaver](https://dbeaver.io/)
   - [TablePlus](https://tableplus.com/)

---

## ⁉️ Solução de Problemas

### Problemas Comuns

1. **Erro ao criar network**
   - Solução: Verifique se o Docker está rodando (`docker ps`)
   - Alternativa: Execute como administrador

2. **Portas ocupadas**
   - Solução: Altere as portas no `.env` ou libere as portas padrão

3. **Migrações falhando**
   - Solução: Execute `docker-compose down -v` e recrie os containers

4. **Aplicação não conecta ao banco**
   - Verifique:
     ```bash
     docker-compose logs postgres
     docker-compose logs api
     ```

---

## 👨‍💻 Autor

**João Pedro Varela Borges**  
🎓 Estudante de Sistemas de Informação - UnDF  
📧 jpvarela@email.com  
🔗 [LinkedIn](https://linkedin.com/in/seuperfil)

---

## 📜 Licença

MIT License - Consulte o arquivo [LICENSE](LICENSE) para detalhes completos.

Permissões incluem uso comercial, modificação, distribuição e uso privado sem custos.