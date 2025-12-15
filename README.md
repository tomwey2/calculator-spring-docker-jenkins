# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator implemented as a Spring Boot application, exposed via a REST API. The project is containerized using Docker and uses Jenkins for CI/CD.

## Technologies
- **Spring Boot**: Framework for the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automated builds and deployments.
- **Maven**: Build tool and dependency management.

## Features
The application provides a REST API for basic arithmetic operations. Currently, the following operation is supported:
- **Addition**: `/sum` endpoint for adding two numbers.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main class for the Spring Boot application
│   │   │   ├── CalculatorController.java    # REST controller for the API
│   │   │   └── CalculatorService.java       # Logic for arithmetic operations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Tests for the application
│           └── CalculatorServiceTest.java       # Tests for arithmetic logic
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project description
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
3. Build the application with Maven:
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
2. Start the container:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

### CI/CD with Jenkins
The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is properly configured to execute the pipeline.

## Tests
The application includes unit tests for arithmetic logic and integration tests for the API. To run the tests, use the following command:
```bash
mvn test
```

## REST API Endpoints
The application currently exposes the following REST API endpoint:

### Addition
- **Endpoint**: `GET /sum`
- **Description**: Adds two numbers and returns the result.
- **Parameters**:
  - `a` (required, integer): First number
  - `b` (required, integer): Second number
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```

## Future Enhancements
The following endpoints are planned for future implementation:
- **Subtraction**: `GET /subtract?a={a}&b={b}`
- **Multiplication**: `GET /multiply?a={a}&b={b}`
- **Division**: `GET /divide?a={a}&b={b}`

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for more information.