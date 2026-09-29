# Lost & Found API

REST API developed for the Génie logiciel project at Polytech Nancy.

## Objective

The application allows users to declare and manage lost or found objects.

## Main features

- REST API for lost and found items
- CRUD operations on items
- Input validation
- HTTP error handling
- OpenAPI / Swagger documentation
- Spring Security foundation
- H2 database for the initial development phase
- Docker support
- Automated integration tests

## Technologies

- Java 21
- Spring Boot 3.5.6
- Spring Web
- Spring Data JPA
- H2
- Spring Security
- Springdoc OpenAPI
- JUnit / Spring Boot Test
- Docker

## Run locally

Requirements: Java 21 and Maven.

```bash
mvn spring-boot:run
```

The application runs on port 9090.

## API

- `GET /api/items`
- `GET /api/items/{id}`
- `POST /api/items`
- `PUT /api/items/{id}`
- `DELETE /api/items/{id}`

## Documentation

Project information:

`GET /`

Swagger UI:

`/swagger-ui.html`

OpenAPI JSON:

`/v3/api-docs`

## Tests

```bash
mvn test
```

## Docker

Build the application first:

```bash
mvn clean package
```

Build the image:

```bash
docker build -t lost-and-found-api .
```

Run:

```bash
docker run -p 9090:9090 lost-and-found-api
```

## Security

Spring Security is already integrated as a foundation. The current configuration keeps the API accessible during the initial development phase. Authentication and authorization will be added progressively, including the planned:

- `POST /api/auth/register`
- `POST /api/auth/login`

A JWT architecture is intentionally not added yet.

## Project architecture

```
controller  -> HTTP endpoints
service     -> business logic
repository  -> data access
model       -> persistent domain objects
dto         -> request validation
config      -> security and OpenAPI configuration
exception   -> centralized HTTP error handling
```
