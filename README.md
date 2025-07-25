# 🎫 - Siska Backend

This project is a backend RESTful API built with **Spring Boot** for managing user authentication, ticket

---

## 🚀 Project Requirements

- **Java 17+**
- **Maven 3.8+**
- **Spring Boot 3.5+**
- **PostgreSQL** or compatible RDBMS -> update on application.properties
- **Postman** (for API testing)
- **Docker (optional)** – for DB and deployment
- **Lombok Plugin** enabled in your IDE
- **Open API WebMVC** with swagger-ui

---
## 🧰 Stack Used

| Layer             | Technology                         |
|-------------------|------------------------------------|
| Language          | Java 24                            |
| Framework         | Spring Boot 3.5.4                  |
| Auth              | Spring Security + JWT              |
| Data Access       | Spring Data JPA                    |
| DB                | PostgreSQL (configurable)          |
| Build Tool        | Maven                              |
| Validation        | Jakarta Bean Validation            |
| Uploads           | Multipart/Form-Data (image upload) |
| Testing           | JUnit 5, Mockito                   |
| API Documentation | Swagger-UI                         |

---
# 🔗 Entity Relationships

### 1. **User**
- `id`, `name`, `email`, `password`, `role`.
- Implements `UserDetails` for Spring Security
---

# API Documentation
Swagger UI can be accessed on <br>
`{{base_uri}}/swagger-ui/index.html`

# Commands

- `mvn -B clean package` : for building the app and test, or add `-D skiptest` to skip tests when building the app
- `mvn test` : to run all testings

# Dockerized App
You can run this app on your docker desktop by running this command from the app's root directory:
- `docker-ps` : check the running images
- `docker compose up -d` : run in detached mode on docker
- `docker compose down` : stop the running container
- `docker logs springstore-cont` : view logs of the dockerized app

# 🛠️ API Endpoints
### 🧑‍💼 Auth

| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| POST   | `/api/auth/login`    | Login, returns JWT |
