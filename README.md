# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator implemented as a Spring Boot application, exposed via a REST API. The project is containerized using Docker and uses Jenkins for CI/CD.

## Technologies
- **Spring Boot**: Framework for the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automated builds and deployments.
- **Maven**: Build tool and dependency management.

## Features
The application provides a REST API for basic arithmetic operations: addition, subtraction, multiplication, and division. The API can be accessed via HTTP endpoints.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST controller for the API
│   │   │   └── CalculatorService.java       # Business logic for arithmetic operations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           └── CalculatorServiceTest.java       # Tests for arithmetic logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

## Prerequisites
- Java 11 or higher
- Maven
- Docker
- Jenkins (optional, for CI/CD)

## Installation and Execution
### Local Execution
1. Clone the repository:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```
2. Navigate to the project directory:
   ```bash
   cd calculator-spring-docker-jenkins
   ```
3. Build the application using Maven:
   ```bash
   mvn clean install
   ```
4. Start the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

### Execution with Docker
1. Build the Docker image:
   ```bash
   docker build -t calculator-spring-app .
   ```
2. Run the container:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

### CI/CD with Jenkins
The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is properly configured to execute the pipeline.

## Tests
The application includes unit tests for arithmetic logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## API Documentation
The application exposes the following REST API endpoints:

### 1. Addition
- **Endpoint**: `GET /sum?a={a}&b={b}`
- **Description**: Returns the sum of `a` and `b`.
- **Example**: `GET /sum?a=5&b=3`
  **Response**: `8`

### 2. Subtraction
- **Endpoint**: `GET /subtract?a={a}&b={b}`
- **Description**: Returns the result of `a` minus `b`.
- **Example**: `GET /subtract?a=5&b=3`
  **Response**: `2`

### 3. Multiplication
- **Endpoint**: `GET /multiply?a={a}&b={b}`
- **Description**: Returns the product of `a` and `b`.
- **Example**: `GET /multiply?a=5&b=3`
  **Response**: `15`

### 4. Division
- **Endpoint**: `GET /divide?a={a}&b={b}`
- **Description**: Returns the result of `a` divided by `b`.
- **Example**: `GET /divide?a=6&b=3`
  **Response**: `2.0`
- **Error Handling**: Returns an error if `b` is `0`.

## Error Handling
- **Division by Zero**: If a division operation is attempted with `b = 0`, the API will return an error response with a status code of `400 Bad Request` and a message: `Division by zero is not allowed.`

## Troubleshooting
- **Port Conflict**: If the application fails to start due to a port conflict, ensure no other service is running on port `8080`. You can change the port in `application.properties`.
- **Dependency Issues**: Run `mvn clean install` to resolve dependency issues.
- **Docker Issues**: Ensure Docker is running and the image is built correctly.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.