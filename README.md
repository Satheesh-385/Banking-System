🏦 Banking System with JWT Authentication

A secure Spring Boot-based Banking System that uses JWT (JSON Web Token) for authentication and authorization. This project demonstrates backend development with REST APIs, Spring Security, and database integration.

🚀 Features
🔐 User Registration & Login
🪪 JWT-based Authentication
👤 Role-based Authorization (User/Admin)
💳 Account Management (Create, View, Update)
💰 Deposit & Withdraw functionality
📊 Transaction tracking
🛡️ Secure REST APIs using Spring Security
🗄️ MySQL Database integration
🛠️ Tech Stack
Backend: Java, Spring Boot
Security: Spring Security, JWT
Database: MySQL
ORM: Spring Data JPA
Build Tool: Maven
IDE: Eclipse / IntelliJ
📁 Project Structure
banking-system
│
├── src/main/java
│   └── com.banking
│       ├── controller
│       ├── service
│       ├── repository
│       ├── model
│       ├── security (JWT config)
│       └── BankingSystemApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
└── README.md
🔐 JWT Authentication Flow
User registers or logs in
Server validates credentials
JWT token is generated
Token is sent to client

Client uses token in header:

Authorization: Bearer <token>
Server validates token for every request
⚙️ Setup Instructions
1. Clone the repository
git clone https://github.com/Satheesh-385/banking-system.git
2. Import into Eclipse / IDE
File → Import → Maven Project
3. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
4. Run the project
mvn spring-boot:run
📌 API Endpoints
Auth APIs
POST /auth/register → Register user
POST /auth/login → Login & get JWT token
User APIs
GET /user/profile
POST /account/create
GET /account/balance
Transaction APIs
POST /deposit
POST /withdraw
GET /transactions
🧪 Testing

You can test APIs using:

Postman
Swagger UI (if enabled)
🔒 Security
- Passwords encrypted using BCrypt  
- JWT token-based authentication  
- Token validation for every request 
👨‍💻 Author

Satheesh Thota

📌 Future Improvements
Add Swagger documentation
Add email notifications
Add transaction history filters
Deploy on AWS / Render
