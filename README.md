# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator application built with Spring Boot, exposed as a REST API. The project is containerized using Docker and includes a Jenkins pipeline for CI/CD.

## Technologies
- **Spring Boot**: Framework for the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automated builds and deployments.
- **Maven**: Build tool and dependency management.

## Features
This application provides a REST API for basic arithmetic operations:
- Addition
- Subtraction
- Multiplication
- Division

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST Controller for the API
│   │   │   └── CalculatorService.java       # Business logic for calculations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           └── CalculatorServiceTest.java       # Unit tests for calculation logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins CI/CD pipeline
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
The project includes a `Jenkinsfile` for automated build and deployment. Configure Jenkins to use this file for the pipeline.

## Running Tests
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## REST API Endpoints
The application provides the following REST API endpoints for arithmetic operations:

| Endpoint                     | Method | Parameters       | Description                     | Example                     | Response |
|------------------------------|--------|------------------|---------------------------------|-----------------------------|----------|
| `/api/calculate/add`         | GET    | `a` (int), `b` (int) | Adds two numbers               | `/api/calculate/add?a=5&b=3` | `8`      |
| `/api/calculate/subtract`    | GET    | `a` (int), `b` (int) | Subtracts `b` from `a`         | `/api/calculate/subtract?a=5&b=3` | `2`      |
| `/api/calculate/multiply`    | GET    | `a` (int), `b` (int) | Multiplies two numbers         | `/api/calculate/multiply?a=5&b=3` | `15`     |
| `/api/calculate/divide`      | GET    | `a` (int), `b` (int) | Divides `a` by `b`             | `/api/calculate/divide?a=6&b=3` | `2.0`    |

### Error Handling
- **Division by Zero**: Returns a `400 Bad Request` response with the message `Division by zero is not allowed.`

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.