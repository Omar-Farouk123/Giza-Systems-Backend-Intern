# Giza Systems HR System Spring Boot Project

## Project Hierarchy

```
spring/
├── docker-compose.yml         # Docker configuration (if used)
├── mvnw, mvnw.cmd             # Maven wrapper scripts
├── pom.xml                    # Maven project configuration
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── STC/
│       │           ├── Main.java                # Main Spring Boot application entry point
│       │           ├── Admin/                   # Admin-related logic and repository
│       │           ├── API/                     # API controllers
│       │           ├── Attendences/             # Attendance management
│       │           ├── Auth/                    # Authentication and security
│       │           ├── demo/                    # Demo/test controllers
│       │           ├── Employee/                # Employee management
│       │           ├── Exceptions/              # Custom exceptions and handlers
│       │           ├── History/                 # History tracking
│       │           ├── Manager/                 # Manager logic
│       │           ├── Requests/                # Request handling
│       │           ├── Security/                # Security configuration
│       │           └── Users/                   # User management
│       └── resources/
│           └── application.yml                  # Main application configuration
└── target/                                      # Compiled output (auto-generated)
```

## Setup Guide

### Prerequisites
- Java 17 or later
- Maven 3.6+
- (Optional) Docker & Docker Compose

### Steps

1. **Clone the repository**
   ```sh
   git clone <your-repo-url>
   cd spring
   ```

2. **Configure the application**
   - Edit `src/main/resources/application.yml` to set up your database connection and other environment variables as needed.
   - **Database Setup:**
     - Make sure you have a running database instance (e.g., PostgreSQL, MySQL, etc.).
     - Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` fields in `application.yml` with your database details.
     - Example for PostgreSQL:
       ```yaml
       spring:
         datasource:
           url: jdbc:postgresql://localhost:5432/your_db
           username: your_username
           password: your_password
       ```

3. **Build the project**
   ```sh
   ./mvnw clean install
   ```
   Or on Windows:
   ```cmd
   mvnw.cmd clean install
   ```

4. **Run the application**
   ```sh
   ./mvnw spring-boot:run
   ```
   Or on Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```

5. **(Optional) Run with Docker Compose**
   If you have a `docker-compose.yml`, you can start services with:
   ```sh
   docker-compose up
   ```

## Notes
- Source code is organized by feature (Admin, Employee, Auth, etc.) for modularity.
- Main entry point: `com.STC.Main.java`
- All configuration is in `application.yml`.

## Contributing
Feel free to open issues or submit pull requests for improvements.
