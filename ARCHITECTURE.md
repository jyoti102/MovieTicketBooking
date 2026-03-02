# System Architecture

## High Level Flow

Client
↓
API Gateway (Port 8080)
↓
-----------------------------------
| admin-panel (Admin APIs)        |
| booking-system (Customer APIs)  |
| auth-server (Identity Layer)    |
-----------------------------------
↓
Eureka Discovery Server (8761)

Authentication handled by external Keycloak server.

---

## Responsibilities

### API Gateway
- Routes requests
- Validates JWT (future)
- Central entry point

### Auth Server
- User profile management
- Keycloak integration
- Future OTP / SSO logic

### Admin Panel
- Movie management
- Show management
- Theatre management

### Booking System
- Seat booking
- Ticket generation
- Payment integration (future)

### Common
- Shared DTOs
- Enums
- Constants