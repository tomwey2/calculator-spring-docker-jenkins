# Calculator Spring Boot Application

A simple calculator application built with **Spring Boot**, containerized using **Docker**, and integrated with **Jenkins** for CI/CD.

## Features
- REST API for basic arithmetic operations.
- Containerized using Docker for easy deployment.
- CI/CD pipeline using Jenkins for automated builds and deployments.

## Technologies
- **Spring Boot**: Framework for building the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automation for CI/CD pipelines.
- **Maven**: Build tool and dependency management.

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
- Java 21 or higher
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

### Addition (Sum)
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result as plain text.
- **Content-Type**: `text/plain`
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Request Format**:
  ```
  GET /sum?a=<integer>&b=<integer> HTTP/1.1
  Host: localhost:8080
  ```
- **Example Request**:
  ```bash
  curl -X GET "http://localhost:8080/sum?a=5&b=3"
  ```
- **Success Response**:
  ```
  HTTP/1.1 200 OK
  Content-Type: text/plain

  8
  ```
- **Error Cases**:
  - If `a` or `b` is missing, the API returns a `400 Bad Request` response.
  - If `a` or `b` is not a valid integer, the API returns a `400 Bad Request` response.
  - If the result exceeds the integer limit, the API may return an unexpected result due to integer overflow.

### Subtraction
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts two integers and returns the result.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/subtract?a=5&b=3"
  ```
- **Response**:
  ```
  2
  ```

### Multiplication
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/multiply?a=5&b=3"
  ```
- **Response**:
  ```
  15
  ```

### Division
- **Endpoint**: `GET /divide`
- **Description**: Divides two integers and returns the result.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/divide?a=6&b=3"
  ```
- **Response**:
  ```
  2
  ```

## Testing
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.