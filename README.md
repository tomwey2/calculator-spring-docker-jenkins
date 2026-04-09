# Calculator Spring Boot Application

A lightweight, **Spring Boot**-based calculator API designed for performing arithmetic operations. This application is containerized using **Docker**, and integrated with **Jenkins** for CI/CD, making it ideal for developers and businesses seeking a scalable and automated solution for arithmetic operations.

## Features

- **REST API** for performing basic arithmetic operations (addition, subtraction, multiplication, and division).
- **Containerized** using Docker for seamless deployment across environments.
- **CI/CD Pipeline** using Jenkins for automated builds, testing, and deployments.
- **Input Validation** to ensure robust and error-free operations.
- **Scalable** architecture ready for future enhancements.

## Technologies

| Technology      | Description                                                                                     |
|-----------------|-------------------------------------------------------------------------------------------------|
| **Spring Boot** | A Java-based framework used to build the REST API and handle HTTP requests/responses.          |
| **Docker**      | Containerization platform for packaging the application and its dependencies into a portable unit. |
| **Jenkins**     | Automation server for setting up CI/CD pipelines to streamline development and deployment.     |
| **Maven**       | Build automation tool for managing dependencies and building the project.                       |
| **PostgreSQL**  | Relational database management system (if used for storing application data).                   |
| **Lombok**      | Java library that reduces boilerplate code (e.g., getters, setters, constructors).              |

## Project Structure

```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application class that initializes the application.
│   │   │   ├── CalculatorController.java    # REST Controller handling HTTP requests for arithmetic operations.
│   │   │   ├── CalculatorService.java       # Business logic layer for performing arithmetic calculations.
│   │   │   ├── dto
│   │   │   │   └── SumRequest.java          # DTO for encapsulating input parameters for the `/sum` endpoint.
│   │   │   └── exception
│   │   │       ├── GlobalExceptionHandler.java  # Handles exceptions globally across the application.
│   │   │       └── InvalidInputException.java   # Custom exception for invalid input scenarios.
│   │   └── resources
│   │       ├── application.properties       # Configuration file for Spring Boot settings.
│   │       └── application-dev.properties   # Development-specific configuration.
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Tests for the main application context.
│           ├── CalculatorControllerIT.java     # Integration tests for the REST API endpoints.
│           ├── CalculatorControllerTest.java   # Unit tests for the controller layer.
│           ├── CalculatorServiceTest.java       # Unit tests for the service layer.
│           └── util
│               └── TestUtils.java               # Utility methods for testing.
├── Dockerfile                                # Docker configuration for containerizing the application.
├── Jenkinsfile                               # Jenkins pipeline configuration for CI/CD.
├── pom.xml                                   # Maven configuration for build and dependency management.
└── README.md                                 # Project documentation (this file).
```

---

## Prerequisites

Ensure the following tools are installed and configured on your system:

- **Java 21** (or higher) – Required to run the Spring Boot application.
- **Maven** – For building the project and managing dependencies.
- **Docker** (optional) – For containerizing and running the application in a Docker environment.
- **Jenkins** (optional) – For setting up CI/CD pipelines.
- **PostgreSQL** (if applicable) – For database operations (ensure it is running and accessible).

---

## Installation and Execution

### Local Execution

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
   cd calculator-spring-docker-jenkins
   ```

2. **Build the Application**:
   ```bash
   mvn clean install
   ```

3. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```
   The application will be available at `http://localhost:8080`.

   **Troubleshooting**:
   - If port `8080` is already in use, modify the `server.port` property in `application.properties`.
   - Ensure Java 21 is installed and the `JAVA_HOME` environment variable is set correctly.

---

### Docker Execution

1. **Build the Docker Image**:
   ```bash
   docker build -t calculator-spring-app .
   ```

2. **Run the Container**:
   ```bash
   docker run -p 8080:8080 calculator-spring-app
   ```
   The application will be available at `http://localhost:8080`.

   **Troubleshooting**:
   - Ensure Docker is running and you have permission to execute Docker commands.
   - If the container fails to start, check the logs using `docker logs <container-id>`.

---

### CI/CD with Jenkins

The project includes a `Jenkinsfile` for automated build and deployment pipelines. Ensure Jenkins is properly configured to execute the pipeline.

1. **Set Up Jenkins**:
   - Install Jenkins and configure the necessary plugins (e.g., Docker, Pipeline).
   - Create a new pipeline job and point it to the `Jenkinsfile` in the repository.

2. **Run the Pipeline**:
   - Trigger the pipeline to build, test, and deploy the application automatically.

---

## API Endpoints

The application provides the following REST API endpoints for arithmetic operations:

| Endpoint       | Method | Description                          |
|----------------|--------|--------------------------------------|
| `/sum`         | GET    | Adds two integers and returns the result. |
| `/subtract`    | GET    | Subtracts two integers and returns the result. |
| `/multiply`    | GET    | Multiplies two integers and returns the result. |
| `/divide`      | GET    | Divides two integers and returns the result. |

---

### Detailed Endpoint Documentation

#### Addition (`/sum`)

- **Endpoint**: `GET /sum`
- **Method**: GET
- **Description**: Adds two integers and returns the result.
- **Parameters**:

  | Parameter | Type    | Required | Description          |
  |-----------|---------|----------|----------------------|
  | `a`       | integer | Yes      | First operand        |
  | `b`       | integer | Yes      | Second operand       |

- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/sum?a=5&b=3"
  ```

- **Response Example**:
  ```json
  {
    "result": 8
  }
  ```

- **Error Responses**:
  - `400 Bad Request`: If `a` or `b` is not an integer or is missing.

---

#### Subtraction (`/subtract`)

- **Endpoint**: `GET /subtract`
- **Method**: GET
- **Description**: Subtracts two integers and returns the result.
- **Parameters**:

  | Parameter | Type    | Required | Description          |
  |-----------|---------|----------|----------------------|
  | `a`       | integer | Yes      | First operand        |
  | `b`       | integer | Yes      | Second operand       |

- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/subtract?a=5&b=3"
  ```

- **Response Example**:
  ```json
  {
    "result": 2
  }
  ```

- **Error Responses**:
  - `400 Bad Request`: If `a` or `b` is not an integer or is missing.

---

#### Multiplication (`/multiply`)

- **Endpoint**: `GET /multiply`
- **Method**: GET
- **Description**: Multiplies two integers and returns the result.
- **Parameters**:

  | Parameter | Type    | Required | Description          |
  |-----------|---------|----------|----------------------|
  | `a`       | integer | Yes      | First operand        |
  | `b`       | integer | Yes      | Second operand       |

- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/multiply?a=5&b=3"
  ```

- **Response Example**:
  ```json
  {
    "result": 15
  }
  ```

- **Error Responses**:
  - `400 Bad Request`: If `a` or `b` is not an integer or is missing.

---

#### Division (`/divide`)

- **Endpoint**: `GET /divide`
- **Method**: GET
- **Description**: Divides two integers and returns the result.
- **Parameters**:

  | Parameter | Type    | Required | Description          |
  |-----------|---------|----------|----------------------|
  | `a`       | integer | Yes      | First operand        |
  | `b`       | integer | Yes      | Second operand       |

- **Request Example**:
  ```bash
  curl -X GET "http://localhost:8080/divide?a=6&b=3"
  ```

- **Response Example**:
  ```json
  {
    "result": 2
  }
  ```

- **Error Responses**:
  - `400 Bad Request`: If `a` or `b` is not an integer, is missing, or if `b` is zero.

---

## Testing

The application includes unit tests and integration tests to ensure reliability and correctness.

### Running Tests

- **Unit Tests**:
  ```bash
  mvn test
  ```

- **Integration Tests**:
  ```bash
  mvn verify
  ```

- **Generate Test Reports**:
  ```bash
  mvn surefire-report:report
  ```
  Reports are generated in the `target/site/surefire-report.html` directory.

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.
