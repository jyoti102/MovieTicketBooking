# Admin Operations – Movie Ticket Booking System

This document defines the **role-based administrative operations** for the system using **Role-Based Access Control (RBAC)**.

## Roles

* **SuperAdmin** – Full system control.
* **SubAdmin** – Theatre-level operational management.

---

# SuperAdmin Operations

SuperAdmin has **complete control over the platform**, including theatres, movies, users, and admins.

## Theatre Management

Capabilities:

* Onboard new theatre
* Update theatre details
* Activate / deactivate theatre
* Block / unblock theatre
* View all theatres
* Assign theatre to SubAdmin

### APIs

```http
POST   /api/v1/admin/theatres
PUT    /api/v1/admin/theatres/{id}
PATCH  /api/v1/admin/theatres/{id}/activate
PATCH  /api/v1/admin/theatres/{id}/block
GET    /api/v1/admin/theatres
GET    /api/v1/admin/theatres/{id}
```

---

## Movie Management

Capabilities:

* Add movie
* Update movie details
* Remove movie
* Change movie status (Upcoming / Running / Archived)
* Upload poster or trailer

### APIs

```http
POST   /api/v1/admin/movies
PUT    /api/v1/admin/movies/{id}
DELETE /api/v1/admin/movies/{id}
GET    /api/v1/admin/movies
```

---

## Show Management

Capabilities:

* Create show
* Update show timing
* Cancel show
* Reschedule show
* View all shows

### APIs

```http
POST   /api/v1/admin/shows
PUT    /api/v1/admin/shows/{id}
PATCH  /api/v1/admin/shows/{id}/cancel
GET    /api/v1/admin/shows
```

---

## User Management

Capabilities:

* View all users
* Block or unblock users
* Reset user accounts
* View booking history

### APIs

```http
GET    /api/v1/admin/users
PATCH  /api/v1/admin/users/{id}/block
GET    /api/v1/admin/users/{id}/bookings
```

---

## Admin Management

Only **SuperAdmin** can manage other admins.

Capabilities:

* Create SubAdmin
* Update SubAdmin
* Assign theatres
* Remove admin

### APIs

```http
POST   /api/v1/admin/subadmins
PUT    /api/v1/admin/subadmins/{id}
DELETE /api/v1/admin/subadmins/{id}
```

---

## Booking Management

Capabilities:

* View all bookings
* Cancel bookings
* Issue refunds

### APIs

```http
GET    /api/v1/admin/bookings
PATCH  /api/v1/admin/bookings/{id}/cancel
POST   /api/v1/admin/bookings/{id}/refund
```

---

# SubAdmin Operations

SubAdmins are typically **theatre managers** responsible for managing assigned theatres.

---

## Theatre Management (Limited)

Capabilities:

* View assigned theatre
* Update theatre details

### APIs

```http
GET /api/v1/admin/theatres/{id}
PUT /api/v1/admin/theatres/{id}
```

---

## Screen Management

Capabilities:

* Add screen
* Update screen
* Delete screen
* View screens

### APIs

```http
POST   /api/v1/admin/screens
PUT    /api/v1/admin/screens/{id}
DELETE /api/v1/admin/screens/{id}
GET    /api/v1/admin/screens
```

---

## Seat Layout Management

Capabilities:

* Configure seat layout
* Update seat layout
* Mark seats as VIP or Premium

### APIs

```http
POST /api/v1/admin/screens/{screenId}/seats
PUT  /api/v1/admin/seats/{id}
```

---

## Show Management

Capabilities:

* Create show
* Update show
* Cancel show

### APIs

```http
POST   /api/v1/admin/shows
PUT    /api/v1/admin/shows/{id}
PATCH  /api/v1/admin/shows/{id}/cancel
```

---

## Booking Monitoring

Capabilities:

* View bookings for assigned theatres
* Cancel bookings for cancelled shows

### APIs

```http
GET   /api/v1/admin/bookings?theatreId=
PATCH /api/v1/admin/bookings/{id}/cancel
```

---

# Role Permission Matrix

| Operation      | SuperAdmin | SubAdmin |
| -------------- | ---------- | -------- |
| Create Theatre | ✅          | ❌        |
| Update Theatre | ✅          | ✅        |
| Block Theatre  | ✅          | ❌        |
| Add Movie      | ✅          | ❌        |
| Create Show    | ✅          | ✅        |
| Cancel Show    | ✅          | ✅        |
| Manage Screens | ❌          | ✅        |
| Manage Seats   | ❌          | ✅        |
| Manage Users   | ✅          | ❌        |
| Create Admin   | ✅          | ❌        |
| View Bookings  | ✅          | ✅        |
| Refund Booking | ✅          | ❌        |

---

# Notes

* All APIs are prefixed with `/api/v1/` for versioning.
* Role-based access will be enforced using **Spring Security RBAC**.
* Each **SubAdmin will only access theatres assigned to them**.
* Future expansion may introduce additional roles like **TheatreOwner or TheatreManager**.
