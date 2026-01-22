# Calculator Spring Boot Application

A **RESTful calculator API** built with **Spring Boot**, containerized using **Docker**, and integrated with **Jenkins** for CI/CD.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [REST API Documentation](#rest-api-documentation)
  - [Addition](#addition)
  - [Future Endpoints](#future-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)


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

## Quick Start
### Local Execution
1. Clone the repository:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   ```
2. Navigate to the project directory:
   ```bash
   cd calculator-spring-docker-jenkins
   ```
3. Build and run the application:
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
The application provides RESTful endpoints for arithmetic operations.

### Addition
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result.
- **Request Method**: `GET`
- **Query Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Response**:
  - **Success**: Plain text with the result (e.g., `8`)
  - **Error**: HTTP 400 if parameters are missing or invalid
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```

### Future Endpoints
The following endpoints are planned for future improvements and will follow the same format as above.

#### Subtraction
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts two integers and returns the result.
- **Query Parameters**:
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

#### Multiplication
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result.
- **Query Parameters**:
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

#### Division
- **Endpoint**: `GET /divide`
- **Description**: Divides two integers and returns the result.
- **Query Parameters**:
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

## Testing
Run the tests using:
```bash
mvn test
```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.