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

| Module                                                                                        | Description |
|-----------------------------------------------------------------------------------------------|------------|
| [discovery-server](https://github.com/jyoti102/MovieTicketBooking/tree/main/discovery-server) | Eureka service registry |
| [api-gateway](https://github.com/jyoti102/MovieTicketBooking/tree/main/api-gateway)           | Central API routing & security |
| [auth-server](https://github.com/jyoti102/MovieTicketBooking/tree/main/auth-server)           | Identity integration layer |
| [admin-panel](https://github.com/jyoti102/MovieTicketBooking/tree/main/admin-panel)           | Admin management APIs |
| [booking-system](https://github.com/jyoti102/MovieTicketBooking/tree/main/booking-system)     | Customer booking APIs |
| [common](https://github.com/jyoti102/MovieTicketBooking/tree/main/common)                                                                                    | Shared DTOs and utilities |

---

## Architecture Overview

[Link](https://github.com/jyoti102/MovieTicketBooking/blob/main/ARCHITECTURE.md)  
Client → API Gateway → Microservices  
Microservices → Register with Eureka  
Authentication → Handled by Keycloak