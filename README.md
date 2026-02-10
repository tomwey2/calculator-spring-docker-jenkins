# Calculator Spring Boot Application

A simple calculator application built with **Spring Boot**, containerized using **Docker**, and integrated with **Jenkins** for CI/CD. This application provides a REST API for basic arithmetic operations, starting with the sum functionality.

## Features
- REST API for basic arithmetic operations (currently supports addition).
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
- Java 11 or higher
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

## REST API Documentation
The application currently provides the following REST API endpoint:

### 1. Sum
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result as plaintext.
- **Content-Type**: `text/plain`
- **Parameters**:
  | Name | Type     | Description          | Required |
  |------|----------|----------------------|----------|
  | `a`  | Integer  | First operand         | Yes      |
  | `b`  | Integer  | Second operand        | Yes      |
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```
- **Status Codes**:
  | Code | Description                          |
  |------|--------------------------------------|
  | 200  | Success: Returns the sum of `a` and `b` |
  | 400  | Bad Request: Invalid or missing parameters |

- **Error Handling**:
  - If non-integer values are provided, the API returns a `400 Bad Request` error with a message: `"Invalid parameter: <parameter_name> must be an integer."`
  - If either `a` or `b` is missing, the API returns a `400 Bad Request` error with a message: `"Missing parameter: <parameter_name>."`

## Planned Endpoints
The following endpoints are planned for future improvements:

### 1. Subtraction
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts two integers and returns the result.
- **Parameters**:
  | Name | Type     | Description          |
  |------|----------|----------------------|
  | `a`  | Integer  | First operand         |
  | `b`  | Integer  | Second operand        |
- **Example Request**:
  ```bash
  curl "http://localhost:8080/subtract?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  2
  ```

### 2. Multiplication
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result.
- **Parameters**:
  | Name | Type     | Description          |
  |------|----------|----------------------|
  | `a`  | Integer  | First operand         |
  | `b`  | Integer  | Second operand        |
- **Example Request**:
  ```bash
  curl "http://localhost:8080/multiply?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  15
  ```

### 3. Division
- **Endpoint**: `GET /divide`
- **Description**: Divides two integers and returns the result.
- **Parameters**:
  | Name | Type     | Description          |
  |------|----------|----------------------|
  | `a`  | Integer  | First operand         |
  | `b`  | Integer  | Second operand        |
- **Example Request**:
  ```bash
  curl "http://localhost:8080/divide?a=6&b=3"
  ```
- **Response**:
  ```plaintext
  2
  ```

## Testing
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.