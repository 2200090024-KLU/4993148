# Library Management System

A Spring Framework-based application for managing library operations including book management, borrowing, and returning.

## Project Structure

\`\`\`
LibraryManagement/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── library/
│       │           ├── model/
│       │           │   └── Book.java
│       │           ├── repository/
│       │           │   └── BookRepository.java
│       │           ├── service/
│       │           │   └── BookService.java
│       │           └── LibraryManagementApplication.java
│       └── resources/
│           ├── applicationContext.xml
│           └── logback.xml
└── pom.xml
\`\`\`

## Features

- **Book Management**: Add, retrieve, update, and delete books
- **Borrowing System**: Borrow and return books with availability tracking
- **Spring Configuration**: XML-based Spring configuration with dependency injection
- **Logging**: Comprehensive logging using SLF4J and Logback

## How to Run

1. Ensure you have Java 11+ and Maven installed
2. Navigate to the project directory
3. Run: `mvn clean compile exec:java -Dexec.mainClass="com.library.LibraryManagementApplication"`

## Spring Configuration

The application uses XML-based Spring configuration (`applicationContext.xml`) to:
- Define `BookRepository` and `BookService` beans
- Configure dependency injection between services
- Manage the application lifecycle

## Key Components

- **Book**: Entity model representing a library book
- **BookRepository**: Data access layer for book operations
- **BookService**: Business logic layer for library operations
- **LibraryManagementApplication**: Main class demonstrating the functionality
