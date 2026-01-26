# Calculator Spring Boot Application

A simple calculator application built with **Spring Boot**, containerized using **Docker**, and integrated with **Jenkins** for CI/CD.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation and Execution](#installation-and-execution)
  - [Local Execution](#local-execution)
  - [Docker Execution](#docker-execution)
  - [CI/CD with Jenkins](#cicd-with-jenkins)
- [REST API Endpoints](#rest-api-endpoints)
  - [Sum](#sum)
- [Usage](#usage)
- [Testing](#testing)
- [Postman Collection](#postman-collection)
- [License](#license)

## Features
- REST API for basic arithmetic operations (currently supports **sum**).
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

## REST API Endpoints
### Base URL
All endpoints are relative to:
```
http://localhost:8080
```

### Sum
- **Method**: `GET`
- **Endpoint**: `/sum`
- **Description**: Adds two integers and returns the result.
- **Parameters**:
  - `a` (integer, required): First operand
  - `b` (integer, required): Second operand
- **Response Format**: Plain text (`text/plain`)
- **Status Codes**:
  - `200 OK`: Successful operation
  - `400 Bad Request`: Missing or invalid parameters
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```
- **Error Handling**:
  - If either `a` or `b` is missing, the API will return a `400 Bad Request` error.
  - The API handles large integers within the limits of Java's `Integer` type.

## Usage
To quickly test the API, use the following `curl` command:
```bash
curl "http://localhost:8080/sum?a=10&b=20"
```

## Testing
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## Postman Collection
For easier API testing, you can import the following Postman collection:
```json
{
  "info": {
    "_postman_id": "12345678-1234-1234-1234-123456789012",
    "name": "Calculator API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Sum",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "{{baseUrl}}/sum?a=5&b=3",
          "protocol": "http",
          "host": ["localhost"],
          "port": "8080",
          "path": ["sum"],
          "query": [
            {
              "key": "a",
              "value": "5"
            },
            {
              "key": "b",
              "value": "3"
            }
          ]
        }
      },
      "response": []
    }
  ]
}
```

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.