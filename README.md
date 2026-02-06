# 🧩 Cloud Workflow Platform (Backend)

A Spring Boot–based backend application for managing and executing workflows with a well-defined lifecycle.
Designed using RESTful principles, layered architecture, and production-ready best practices.

## 🚀 Overview

The **Cloud Workflow Platform** provides APIs to create, manage, and track workflows through different lifecycle stages such as **CREATED**, **RUNNING**, and **COMPLETED**. 
It demonstrates real-world backend concepts including validation, exception handling, persistence, security, and API documentation.

## ✨ Features

- RESTful APIs for workflow creation and execution

- Workflow lifecycle management (**CREATED, RUNNING, COMPLETED**)

- Persistent storage using **H2 database** with **JPA/Hibernate**

- Clean separation of layers (Controller, Service, Repository)

- Robust exception handling with global error responses

- API documentation via **Swagger / OpenAPI**

- Basic authentication using **Spring Security**

- Health and monitoring endpoints (Spring Boot Actuator)

- UUID-based entity identification

- Input validation using Bean Validation (`@Valid`)

## 🏗️ Tech Stack

- **Java 17+**

- **Spring Boot 3.x**

- **Spring Web**

- **Spring Data JPA**

- **Spring Security**

- **Hibernate**

- **H2 Database**

- **Swagger / OpenAPI**

- **Maven**

## 📦 Project Structure
```bash
com.workflow.backend

├── controller        # REST controllers
├── service           # Business logic
├── repository        # JPA repositories
├── entity            # JPA entities
├── dto               # Request & response DTOs
├── exception         # Custom exceptions & global handler
├── config            # Security & application configs
└── BackendApplication.java
```

## 🔄 Workflow Lifecycle

A workflow progresses through the following states:
```sql
CREATED → RUNNING → COMPLETED
```

State transitions are strictly controlled through dedicated APIs.

## 🔌 API Endpoints
### Workflow APIs
| Method | Endpoint                 | Description                   |
|--------|--------------------------|-------------------------------|
| POST   | /api/workflows           | Create a new workflow         |
| GET    | /api/workflows           | Get workflows (paginated)     |
| GET    | /api/workflows/{id}      | Get workflow by ID            |
| PUT    | /api/workflows/{id}/start | Start a workflow             |
| PUT    | /api/workflows/{id}/complete | Complete a workflow       |

### Pagination Support

The `GET /api/workflows` endpoint supports pagination using query parameters.

**Query Parameters:**
- `page` → Page number (0-based)
- `size` → Number of records per page
- `sort` → Sorting field and direction

**Example:**
```http request
GET /api/workflows?page=0&size=5&sort=createdAt,desc
```

**Response includes:**
- List of workflows
- Total elements
- Total pages
- Current page number

## 📄 Sample Requests
### Create Workflow
```http request
POST /api/workflows
Content-Type: application/json
```
```json
{
  "name": "Order Processing"
}
```     

### Start Workflow
```http request
PUT /api/workflows/{id}/start
```

### Complete Workflow
```http request
PUT /api/workflows/{id}/complete
```

## ⚠️ Error Handling

All errors are handled centrally using a global exception handler.

Example error response:
```json
{
  "message": "Workflow not found",
  "status": 404,
  "timestamp": "2026-02-01T12:30:00"
}
```
    

## 🔐 Security

- Basic Authentication enabled via Spring Security

- Stateless API design

- Endpoints can be extended with role-based access control

⚠️ Default credentials are for development only.
Production security must be hardened.

## 📊 Monitoring & Health

Spring Boot Actuator endpoints are enabled for monitoring:

- `/actuator/health`

- `/actuator/info`

## 🧪 Testing

APIs can be tested using:

- **Postman**

- **cURL**

- **Swagger UI**

Swagger UI:
```bash
http://localhost:8080/swagger-ui.html
```

### Pagination Testing

Pagination can be tested by passing query parameters:

- Page 0, size 5:

```http request
GET /api/workflows?page=0&size=5
```
- Page 1, size 10:
```http request
GET /api/workflows?page=1&size=10
```

Swagger UI automatically exposes pagination parameters for testing.

## ▶️ Running the Application
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on:
```arduino
http://localhost:8080
```

## 🛠️ Future Enhancements

- Filtering and sorting support
- Role-based authorization
- Audit logs for workflow state changes
- Async workflow execution 
- Integration with external workflow engines 
- Production-grade database (PostgreSQL/MySQL)
- Docker & CI/CD pipeline

## 👤 Author

Developed as part of a structured backend engineering journey, focusing on **clean code, scalable design**, and **interview-ready architecture**.
