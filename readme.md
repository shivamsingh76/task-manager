# Task Manager API

A secure Task Manager REST API built with **Spring Boot**, **Spring Security**, **JWT Authentication**, **PostgreSQL**, and **Docker**.

The application allows users to register, authenticate using JWT, and perform CRUD operations on their tasks.

---

## Features

- User Registration
- User Login with JWT Authentication
- Secure REST APIs using Spring Security
- CRUD Operations for Tasks
- PostgreSQL Database
- Input Validation
- Global Exception Handling
- Docker Support
- Docker Compose Support

---

## Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.1.0 |
| Spring Security | 7 |
| Spring Data JPA | Latest |
| PostgreSQL | 17+ |
| JWT (jjwt) | 0.13.0 |
| Maven | 3.9+ |
| Docker | Latest |
| Docker Compose | Latest |

---

## Project Structure

```
task-manager
│
├── src
│   ├── main
│   │   ├── java/com/shivam/task_manager
│   │   │   ├── config
│   │   │   ├── controller
│   │   │   ├── dto
│   │   │   ├── exception
│   │   │   ├── filter
│   │   │   ├── model
│   │   │   ├── repository
│   │   │   ├── response
│   │   │   └── service
│   │   └── resources
│   │       └── application.yaml
│   │
│   └── test
│
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── README.md
```

---

## Architecture

```
Browser / Postman
        │
        ▼
Spring Boot REST API
        │
 Spring Security + JWT
        │
        ▼
Spring Data JPA
        │
        ▼
 PostgreSQL
```

---

## REST APIs

### Authentication

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/v1/users/signup` | Register new user |
| POST | `/api/v1/users/signin` | Login user |

---

### Tasks

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/v1/tasks/{userId}` | Get all tasks |
| POST | `/api/v1/tasks` | Create task |
| PATCH | `/api/v1/tasks/{taskId}` | Update task |
| DELETE | `/api/v1/tasks/{taskId}` | Delete task |

---

## Clone Repository

```bash
git clone https://github.com/shivamsingh76/task-manager.git

cd task-manager
```

---

# Running Locally

## Prerequisites

- Java 21
- Maven 3.9+
- PostgreSQL

---

## Create Database

```sql
CREATE DATABASE task_manager;
```

---

## Configure Environment Variables

The application reads configuration from environment variables.

Example:

```text
DB_HOST=localhost
DB_PORT=5432
DB_NAME=task_manager
DB_USER=postgres
DB_PASSWORD=mysecretpassword
```

If these variables are not provided, default values defined in `application.yaml` are used.

---

## Build

```bash
./mvnw clean package
```

Windows

```cmd
mvnw.cmd clean package
```

---

## Run

```bash
java -jar target/task-manager-0.0.1-SNAPSHOT.jar
```

Application starts at

```
http://localhost:8080
```

---

# Running with Docker

## Build Image

```bash
docker build -t task-manager:v1.0 .
```

---

## Run Container

```bash
docker run \
-p 8080:8080 \
-e DB_HOST=host.docker.internal \
-e DB_PORT=5432 \
-e DB_NAME=task_manager \
-e DB_USER=postgres \
-e DB_PASSWORD=mysecretpassword \
task-manager:v1.0
```

If PostgreSQL is running inside another Docker container, replace

```
host.docker.internal
```

with the PostgreSQL container name.

---

# Running with Docker Compose

The project includes a `docker-compose.yaml` that starts

- PostgreSQL
- Spring Boot Application

If you are also using the Angular frontend, Docker Compose can be extended to start the frontend container as well.

---

## Start

```bash
docker compose up --build
```

Run in detached mode

```bash
docker compose up -d --build
```

---

## Stop

```bash
docker compose down
```

Remove database volume

```bash
docker compose down -v
```

---

## Docker Compose Architecture

```
                 Docker Network

      +-------------------------------+

      PostgreSQL
           ▲
           │
           │
 Spring Boot Application

      +-------------------------------+
```

Spring Boot automatically connects to PostgreSQL using

```
DB_HOST=postgres-db
```

provided by Docker Compose.

---

# Security

The application uses

- Spring Security
- JWT Authentication
- Stateless Authentication
- Password Encryption using BCrypt

Protected APIs require the JWT token in the Authorization header.

Example

```
Authorization: Bearer <JWT_TOKEN>
```

---

# Validation

The application validates incoming requests using Jakarta Bean Validation.

Examples include

- Required fields
- Email validation
- Password validation

---

# Exception Handling

A global exception handler returns consistent error responses for:

- Validation errors
- Authentication failures
- Business exceptions
- Unexpected server errors

---

# Future Improvements

- Angular Frontend
- Swagger / OpenAPI Documentation
- Refresh Tokens
- Role Based Authorization
- Pagination
- Sorting
- Search APIs
- Unit & Integration Tests
- Flyway Database Migration
- CI/CD using GitHub Actions
- Kubernetes Deployment

---

# Author

**Shivam Singh**

GitHub

https://github.com/shivamsingh76

---

# License

This project is intended for learning and demonstration purposes.