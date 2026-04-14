# Calculator Spring Boot Application

A simple and efficient calculator application built with **Spring Boot 3**, containerized using **Docker**, and integrated with **Jenkins** for CI/CD. This application provides RESTful APIs for basic arithmetic operations, making it easy to integrate into larger systems or use as a standalone service.

## Features
- **REST API for Arithmetic Operations**: Perform addition, subtraction, multiplication, and division via REST endpoints.
- **Containerized Deployment**: Easily deploy the application using Docker for consistent environments.
- **CI/CD Pipeline**: Automated builds, testing, and deployments using Jenkins.
- **Scalable and Extensible**: Designed with modularity in mind, allowing for easy addition of new features or operations.

## Technologies
- **Spring Boot 3.2**: The primary framework for building the Java application.
- **Docker**: Containerization platform for packaging the application and its dependencies.
- **Jenkins**: Automation server for setting up CI/CD pipelines.
- **Maven**: Build automation and dependency management tool.
- **PostgreSQL**: Database for storing application data (if applicable).
- **Lombok**: Library to reduce boilerplate code in Java.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST Controller for API endpoints
│   │   │   ├── CalculatorService.java       # Business logic for calculations
│   │   │   ├── dto                           # Data Transfer Objects (if any)
│   │   │   ├── exception                     # Custom exceptions and handlers
│   │   │   └── config                        # Application configuration (if any)
│   │   └── resources
│   │       ├── application.properties       # Application configuration
│   │       └── application-dev.properties   # Development-specific configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           ├── CalculatorServiceTest.java       # Tests for calculation logic
│           ├── CalculatorControllerIT.java     # Integration tests for API endpoints
│           └── util                            # Test utilities (if any)
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline configuration
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

## Prerequisites
Before you begin, ensure you have the following installed:
- **Java 21** or higher
- **Maven 3.9+**
- **Docker** (optional, for containerization)
- **Jenkins** (optional, for CI/CD)
- **PostgreSQL** (if the application uses a database)

## Installation and Execution
### Local Execution
1. **Clone the repository**:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd calculator-spring-docker-jenkins
   ```
3. **Build the application using Maven**:
   ```bash
   mvn clean install
   ```
4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

### Docker Execution
1. **Build the Docker image**:
   ```bash
   docker build -t calculator-spring-app .
   ```
2. **Run the container**:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

### CI/CD with Jenkins
The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is properly configured to execute the pipeline. The pipeline typically includes:
- Code checkout
- Build and test
- Docker image creation
- Deployment to a staging or production environment

## API Endpoints
The application provides the following REST API endpoints for arithmetic operations:

### Addition (`/sum`)
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result as a plain text response.
- **Parameters**:
  - `a` (integer, required): The first operand.
  - `b` (integer, required): The second operand.
- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/sum?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  8
  ```
- **Error Responses**:
  - **400 Bad Request**: Returned if either `a` or `b` is missing or not an integer.
    ```plaintext
    {
      "error": "Invalid input",
      "message": "Parameters 'a' and 'b' must be integers."
    }
    ```

---

### Subtraction (`/subtract`)
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts the second integer from the first and returns the result as a plain text response.
- **Parameters**:
  - `a` (integer, required): The first operand.
  - `b` (integer, required): The second operand.
- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/subtract?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  2
  ```
- **Error Responses**:
  - **400 Bad Request**: Returned if either `a` or `b` is missing or not an integer.
    ```plaintext
    {
      "error": "Invalid input",
      "message": "Parameters 'a' and 'b' must be integers."
    }
    ```

---

### Multiplication (`/multiply`)
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result as a plain text response.
- **Parameters**:
  - `a` (integer, required): The first operand.
  - `b` (integer, required): The second operand.
- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/multiply?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  15
  ```
- **Error Responses**:
  - **400 Bad Request**: Returned if either `a` or `b` is missing or not an integer.
    ```plaintext
    {
      "error": "Invalid input",
      "message": "Parameters 'a' and 'b' must be integers."
    }
    ```

---

### Division (`/divide`)
- **Endpoint**: `GET /divide`
- **Description**: Divides the first integer by the second and returns the result as a plain text response.
- **Parameters**:
  - `a` (integer, required): The dividend.
  - `b` (integer, required): The divisor.
- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/divide?a=6&b=3"
  ```
- **Response**:
  ```plaintext
  2
  ```
- **Error Responses**:
  - **400 Bad Request**: Returned if either `a` or `b` is missing, not an integer, or if `b` is zero.
    ```plaintext
    {
      "error": "Invalid input",
      "message": "Parameters 'a' and 'b' must be integers, and 'b' cannot be zero."
    }
    ```

## Testing
The application includes comprehensive unit and integration tests to ensure reliability and correctness.

### Running Tests
To execute all tests, run:
```bash
mvn test
```

### Test Coverage
- **Unit Tests**: Cover business logic and service layer methods.
- **Integration Tests**: Validate API endpoints and their interactions with the service layer.

## License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.
