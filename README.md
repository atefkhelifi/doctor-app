# 🩺 Doctor Recommendation System

A Spring Boot application that helps users:
- Determine the **type of doctor** to consult based on symptoms
- Find the **nearest available doctor** from a PostgreSQL database

---

## 🚀 Features

- 🧠 Symptom-based doctor type detection
- 📍 Location-based nearest doctor search
- 🐘 PostgreSQL integration via Spring Data JPA
- 📡 RESTful API structure
- 🔒 Optional Spring Security

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Maven

---

## 🏁 Getting Started

### 📦 Prerequisites

Make sure you have the following installed:

- Java 17 or later
- Maven
- PostgreSQL

---

## 🔧 Configuration

> ⚠️ **Note:**  
> The file `application.properties` is **ignored by Git** (see `.gitignore`) to protect sensitive data.  
> You must **create it manually** in `src/main/resources`.

---


### 📄 Example: `application.properties`

```properties
spring.application.name=learn-project

# PostgreSQL config with environment variables for security
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA & Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Debugging
logging.level.org.springframework.security=DEBUG

# Server port
server.port=8080
```
---
### ⚙️ Create the Configuration File

Create `src/main/resources/application.properties` with content like above, referencing environment variables.

---

### ▶️ Run the Application

Set your environment variables and run the app:

```bash
export DB_URL=jdbc:postgresql://localhost:5433/learn_db
export DB_USERNAME=postgres
export DB_PASSWORD=your_password

mvn spring-boot:run
```
---

