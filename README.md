
# 🗂️ Task Tracker Application

A **backend-focused Task Tracker application** built using **Spring Boot**, designed to practice and demonstrate clean architecture, REST API design, and real-world backend development concepts.



---

## 🚀 Features

- Create, update, delete task lists
- Add tasks to task lists
- Mark tasks as completed or pending
- Fetch tasks by task list
- Global exception handling
- DTO-based API responses
- Clean layered architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL / PostgreSQL** (local setup)
- **Maven**
- **Lombok**
- **MapStruct**

---

## 🧱 Architecture Overview

The project follows a **layered architecture**:

```text
Controller Layer  ->  Service Layer  ->  Repository Layer  ->  Database
        |                  |
        |                  └── Business Logic
        └── REST API Endpoints
Layers Explained
Controller
Handles HTTP requests and responses (REST APIs)

Service
Contains business logic and validations

Repository
Handles database interactions using Spring Data JPA

DTOs & Mappers
Used to decouple API models from database entities

Global Exception Handler
Centralized error handling for clean API responses

📁 Project Structure
text
Copy code
src/main/java/com/afshan/tasktracker
│
├── controllers        # REST Controllers
├── services           # Business logic
├── repositories       # JPA Repositories
├── domain
│   ├── entity         # JPA Entities
│   ├── dto            # Data Transfer Objects
│
├── mappers            # MapStruct mappers
├── exceptions         # Custom & global exceptions
└── TaskTrackerApplication.java
⚙️ Setup & Run Locally
Prerequisites
Java 17+

Maven

MySQL or PostgreSQL running locally

Steps
Clone the repository

bash
Copy code
git clone https://github.com/<your-username>/task-tracker.git
cd task-tracker
Configure database in application.yml or application.properties

Build and run

bash
Copy code
./mvnw spring-boot:run
The application will start on:

arduino
Copy code
http://localhost:8080
📌 API Example
Create Task List
bash
Copy code
POST /api/v1/task-lists
Get All Task Lists
bash
Copy code
GET /api/v1/task-lists
Add Task to Task List
bash
Copy code
POST /api/v1/task-lists/{id}/tasks
🧪 Error Handling
The application uses a Global Exception Handler to return consistent error responses:

json
Copy code
{
  "status": 400,
  "message": "Invalid request",
  "details": "Task list not found"
}
📈 Future Improvements
Authentication & Authorization (Spring Security + JWT)

Pagination & Sorting

Task due dates & priorities

Docker support

Swagger / OpenAPI documentation

Frontend integration (React)

🎯 Learning Goals
This project was built to:

Understand real-world Spring Boot architecture

Practice clean code and separation of concerns

Learn DTO mapping and exception handling

Prepare for backend interviews
