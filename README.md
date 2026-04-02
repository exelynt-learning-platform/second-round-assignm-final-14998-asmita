# E-commerce Backend (Spring Boot)

## Requirements
- Java 21
- Maven

## Setup
1. Set environment variable `JWT_SECRET` to a sufficiently long secret (at least 32 chars recommended).
   Example (Linux/macOS):
     export JWT_SECRET="your-very-long-secret-key-which-is-secure"
   Windows (PowerShell):
     $env:JWT_SECRET="your-very-long-secret-key-which-is-secure"

2. (Optional) Set DB_URL/DB_USER/DB_PASS to use a real DB. By default H2 in-memory is used.

3. Build and run:
   mvn clean spring-boot:run

## Endpoints
- POST /auth/register  { "email": "...", "password": "..." }
- POST /auth/login     { "email": "...", "password": "..." } -> returns token
- GET  /products
- POST /products       (protected) create product
- PUT  /products/{id}  (protected) update product
- POST /orders         (protected) place order (body: Order with items)

## Notes
- Provide `Authorization: Bearer <token>` header for protected endpoints.
- JWT secret must be set via env var; app will fail to start if missing.
