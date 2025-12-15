# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator implemented as a Spring Boot application, exposed via a REST API. The project is containerized using Docker and includes a Jenkins pipeline for CI/CD.

## Technologies
- **Spring Boot**: Framework for the Java application.
- **Docker**: Containerization of the application.
- **Jenkins**: Automated builds and deployments.
- **Maven**: Build tool and dependency management.

## Functionality
The application currently provides a REST API for basic arithmetic operations. The API is accessible via HTTP endpoints.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class
│   │   │   ├── CalculatorController.java    # REST controller for the API
│   │   │   └── CalculatorService.java       # Business logic for calculations
│   │   └── resources
│   │       └── application.properties       # Application configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           └── CalculatorServiceTest.java       # Service logic tests
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
3. Build the application with Maven:
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
The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is configured to execute the pipeline.

## Tests
The application includes unit tests for the calculator logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## REST API Endpoints
The application currently exposes the following endpoint:

### Sum
- **Endpoint**: `GET /sum?a={a}&b={b}`
- **Description**: Returns the sum of two integers.
- **Parameters**:
  - `a` (integer, required): First operand.
  - `b` (integer, required): Second operand.
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
- **Example Response**:
  ```plaintext
  8
  ```

## Future Improvements
The following enhancements are planned for future versions:
1. **Additional Operations**: Extend the API to support subtraction, multiplication, and division.
2. **Standardized Endpoints**: Update the endpoint paths to follow a consistent pattern (e.g., `/api/calculate/add`, `/api/calculate/subtract`).
3. **Error Handling**: Improve error handling for invalid inputs (e.g., division by zero).
4. **Swagger/OpenAPI Documentation**: Add API documentation for easier exploration and testing.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.