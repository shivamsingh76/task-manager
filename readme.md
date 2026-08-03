# Task Manager API

A secure RESTful Task Manager backend built with **Spring Boot**, **Spring Security**, **JWT Authentication**, and **PostgreSQL**.

This application provides secure APIs for user authentication and task management. It is designed to work with the Angular frontend available in the companion repository.

---

## Features

### Authentication

- User Registration
- User Login
- JWT Authentication
- BCrypt Password Encryption
- Stateless Authentication using Spring Security

### Task Management

- Create Task
- Update Task
- Delete Task
- Get All Tasks
- Get Task by Id
- Mark Task as Completed
- Task Ownership Validation

### Backend Features

- Spring Boot REST APIs
- Spring Data JPA
- PostgreSQL Database
- DTO based Request/Response
- Global Exception Handling
- Bean Validation
- Docker Support
- Docker Compose Support

---

# Tech Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.1 |
| Spring Security | 7 |
| Spring Data JPA | Latest |
| PostgreSQL | 17+ |
| JWT (jjwt) | 0.13 |
| Maven | 3.9+ |
| Docker | Latest |
| Docker Compose | Latest |

---

# Project Structure

```
task-manager
│
├── src
│   ├── main
│   │
│   ├── java
│   │   └── com.shivam.task_manager
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── exception
│   │       ├── filter
│   │       ├── mapper
│   │       ├── model
│   │       ├── repository
│   │       ├── response
│   │       ├── security
│   │       ├── service
│   │       └── util
│   │
│   └── resources
│       └── application.yaml
│
├── Dockerfile
├── docker-compose.yaml
├── pom.xml
└── README.md
```

---

# Architecture

```
                Angular UI
                     │
                     ▼
             Spring Boot REST API
                     │
      Spring Security + JWT Filter
                     │
                     ▼
              Spring Data JPA
                     │
                     ▼
                PostgreSQL
```

---

# Authentication Flow

```
User
 │
 │ Login
 ▼
Spring Boot
 │
 │ Validate Credentials
 ▼
Generate JWT
 │
 ▼
Client stores JWT
 │
 ▼
Authorization: Bearer <TOKEN>
 │
 ▼
Protected APIs
```

---

# API Endpoints

## Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/v1/users/signup` | Register a new user |
| POST | `/api/v1/users/signin` | Login and receive JWT |

---

## Task APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/v1/tasks` | Get all tasks |
| GET | `/api/v1/tasks/{id}` | Get task by id |
| POST | `/api/v1/tasks` | Create task |
| PATCH | `/api/v1/tasks/{id}` | Update task |
| DELETE | `/api/v1/tasks/{id}` | Delete task |

> **Note:** All Task APIs require a valid JWT token.

---

# Clone Repository

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

| Variable | Default Value |
|----------|---------------|
| DB_HOST | localhost |
| DB_PORT | 5432 |
| DB_NAME | task_manager |
| DB_USER | postgres |
| DB_PASSWORD | mysecretpassword |

Example

```bash
DB_HOST=localhost
DB_PORT=5432
DB_NAME=task_manager
DB_USER=postgres
DB_PASSWORD=mysecretpassword
```

---

## Build

Linux / macOS

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

Application will start on

```
http://localhost:8080
```

---

# Running using Docker

## Build Image

```bash
docker build -t task-manager:v1.0 .
```

---

## Run Container

If PostgreSQL is running on your host machine:

```bash
docker run -d \
-p 8080:8080 \
-e DB_HOST=host.docker.internal \
-e DB_PORT=5432 \
-e DB_NAME=task_manager \
-e DB_USER=postgres \
-e DB_PASSWORD=mysecretpassword \
--name task-manager-service \
task-manager:v1.0
```

If PostgreSQL is running inside Docker, use the PostgreSQL container name instead of `host.docker.internal`.

---

# Running using Docker Compose

The repository contains a ready-to-use `docker-compose.yaml`.

It starts:

- PostgreSQL
- Spring Boot Backend

To start all services

```bash
docker compose up --build
```

Run in detached mode

```bash
docker compose up -d --build
```

Stop containers

```bash
docker compose down
```

Remove containers and database volume

```bash
docker compose down -v
```

---

## Docker Compose Architecture

```
             Docker Network

       +----------------------+

       PostgreSQL Container
                ▲
                │
                │
     Spring Boot Container

       +----------------------+
```

Spring Boot connects to PostgreSQL using

```
DB_HOST=postgres-db
```

which is automatically resolved by Docker Compose.

---

# Docker Environment Variables

Spring Boot uses the following variables:

| Variable | Description |
|----------|-------------|
| DB_HOST | PostgreSQL host |
| DB_PORT | PostgreSQL port |
| DB_NAME | Database name |
| DB_USER | Database username |
| DB_PASSWORD | Database password |

---

# Security

The application uses

- Spring Security
- JWT Authentication
- BCrypt Password Encoder
- Stateless Sessions

Example Authorization header

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

---

# Validation

The application validates incoming requests using Jakarta Bean Validation.

Examples

- Required fields
- Email validation
- Password validation
- Task validation

---

# Exception Handling

Global exception handling provides consistent API responses for

- Validation errors
- Authentication failures
- Resource not found
- Business exceptions
- Unexpected server errors

---

# Angular Frontend

The Angular frontend for this project is available in a separate repository.

It provides

- User Registration
- User Login
- JWT Authentication
- Task Dashboard
- Task CRUD Operations
- Responsive UI
- Docker Support

---

# Future Improvements

- Swagger / OpenAPI Documentation
- Refresh Token Authentication
- Role Based Authorization
- Pagination
- Sorting
- Search APIs
- Flyway Database Migration
- Integration Tests using Testcontainers
- GitHub Actions CI/CD
- Kubernetes Deployment

---

# Author

**Shivam Singh**

GitHub

https://github.com/shivamsingh76

LinkedIn

https://www.linkedin.com/in/shivamsingh76/

---

# License

This project is developed for learning purposes and portfolio demonstration.