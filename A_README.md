# Movie Ticket Booking System (MTBS)

Microservices-based Movie Ticket Booking System built using:

- Spring Boot 3
- Spring Cloud
- Eureka Discovery Server
- API Gateway
- Keycloak (External Authentication)
- Maven Multi-Module Architecture

---

## Modules

| Module | Description |
|--------|------------|
| discovery-server | Eureka service registry |
| api-gateway | Central API routing & security |
| auth-server | Identity integration layer |
| admin-panel | Admin management APIs |
| booking-system | Customer booking APIs |
| common | Shared DTOs and utilities |

---

## Architecture Overview

Client → API Gateway → Microservices  
Microservices → Register with Eureka  
Authentication → Handled by Keycloak