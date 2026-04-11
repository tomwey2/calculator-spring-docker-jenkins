# Calculator Spring Boot Application

A simple calculator application built with **Spring Boot 3.2**, **Java 21**, and **Maven**, containerized using **Docker** for easy deployment and integrated with **Jenkins** for CI/CD.

## Features
- REST API for basic arithmetic operations (addition, subtraction, multiplication, division).
- Containerized using Docker for easy deployment.
- CI/CD pipeline using Jenkins for automated builds and deployments.

## Technologies
The application is built using the following technologies:
- **Java 21**: The programming language used for development.
- **Spring Boot 3.2**: Framework for building the Java application.
- **Maven**: Build tool and dependency management.
- **PostgreSQL**: Database for storing application data (if applicable).
- **Lombok**: Library to reduce boilerplate code.
- **Docker**: Containerization platform for packaging the application.
- **Jenkins**: Automation server for CI/CD pipelines.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST Controller for API endpoints
│   │   │   └── CalculatorService.java       # Business logic for calculations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           └── CalculatorServiceTest.java       # Tests for calculation logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline configuration
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

## Prerequisites
- **Java 21** or higher
- Maven
- Docker (optional, for containerization)
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
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

### Docker Execution
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

## API Endpoints
The application provides the following REST API endpoints for arithmetic operations:

### Addition
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result as plain text.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```
- **Response Format**: Plain text
- **Status Codes**:
  - `200 OK`: Successful operation. Returns the sum of `a` and `b`.
  - `400 Bad Request`: Invalid input (e.g., non-integer values for `a` or `b`).

### Subtraction
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts two integers and returns the result as plain text.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/subtract?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  2
  ```
- **Response Format**: Plain text
- **Status Codes**:
  - `200 OK`: Successful operation. Returns the result of `a - b`.
  - `400 Bad Request`: Invalid input (e.g., non-integer values for `a` or `b`).

### Multiplication
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result as plain text.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/multiply?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  15
  ```
- **Response Format**: Plain text
- **Status Codes**:
  - `200 OK`: Successful operation. Returns the result of `a * b`.
  - `400 Bad Request`: Invalid input (e.g., non-integer values for `a` or `b`).

### Division
- **Endpoint**: `GET /divide`
- **Description**: Divides two integers and returns the result as plain text.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/divide?a=6&b=3"
  ```
- **Example Response**:
  ```plaintext
  2
  ```
- **Response Format**: Plain text
- **Status Codes**:
  - `200 OK`: Successful operation. Returns the result of `a / b`.
  - `400 Bad Request`: Invalid input (e.g., non-integer values for `a` or `b` or division by zero).

## Testing
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.