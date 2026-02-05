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

## API Endpoints
The application provides the following REST API endpoint:

### Sum
| **Method** | **Endpoint** | **Description** |
|------------|--------------|------------------|
| `GET`      | `/sum`        | Adds two integers and returns the result. |

#### Parameters
| **Name** | **Type** | **Required** | **Description** |
|----------|----------|--------------|------------------|
| `a`      | integer  | Yes          | First operand.   |
| `b`      | integer  | Yes          | Second operand.  |

#### Responses
| **Status Code** | **Description** |
|----------------|------------------|
| `200 OK`        | Successfully returns the sum of `a` and `b`. |
| `400 Bad Request` | Missing or invalid parameters. |

#### Example Requests
1. **Success Example**:
   ```bash
   curl "http://localhost:8080/sum?a=5&b=3"
   ```
   **Response**:
   ```plaintext
   8
   ```

2. **Negative Numbers Example**:
   ```bash
   curl "http://localhost:8080/sum?a=-5&b=3"
   ```
   **Response**:
   ```plaintext
   -2
   ```

3. **Zero Values Example**:
   ```bash
   curl "http://localhost:8080/sum?a=0&b=0"
   ```
   **Response**:
   ```plaintext
   0
   ```

4. **Large Numbers Example**:
   ```bash
   curl "http://localhost:8080/sum?a=999999999&b=1"
   ```
   **Response**:
   ```plaintext
   1000000000
   ```

#### Error Handling
1. **Missing Parameter**:
   ```bash
   curl "http://localhost:8080/sum?a=5"
   ```
   **Response**:
   ```plaintext
   400 Bad Request: Required parameter 'b' is not present.
   ```

2. **Invalid Parameter Type**:
   ```bash
   curl "http://localhost:8080/sum?a=abc&b=3"
   ```
   **Response**:
   ```plaintext
   400 Bad Request: Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'
   ```

## Testing
The application includes unit tests for the calculation logic and integration tests for the API. Run the tests using:
```bash
mvn test
```

## Future Enhancements
- Add support for more arithmetic operations (e.g., subtraction, multiplication, division).
- Implement logging for API requests and responses.
- Add Swagger/OpenAPI documentation for the API.

## License
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.