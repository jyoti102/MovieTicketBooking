# 🏗 Movie Ticket Booking System – Architecture

## 🔷 High-Level Microservices Architecture

```mermaid
flowchart TD

    Client["Client Application\n(Web / Mobile)"]

    subgraph Infrastructure
        Eureka["Eureka Discovery Server\nPort 8761"]
        Keycloak["Keycloak Server\nExternal Authentication"]
    end

    subgraph GatewayLayer
        Gateway["API Gateway\nPort 8080"]
    end

    subgraph Microservices
        Admin["Admin Panel Service"]
        Booking["Booking System Service"]
        Auth["Auth Server Service"]
    end

    Client -->|HTTP Requests| Gateway
    Gateway -->|Service Discovery| Eureka

    Admin --> Eureka
    Booking --> Eureka
    Auth --> Eureka

    Gateway -->|Route /admin/**| Admin
    Gateway -->|Route /booking/**| Booking

    Client -->|Login| Keycloak
    Keycloak -->|JWT Token| Client
    Client -->|JWT in Header| Gateway