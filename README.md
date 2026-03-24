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
The application currently provides the following REST API endpoint:

### Addition
- **Endpoint**: `GET /sum`
- **Description**: Adds two integers and returns the result as a JSON object.
- **Parameters**:
  - `a` (integer, required): First operand. Must be a valid integer within the range of `[-2147483648, 2147483647]`.
  - `b` (integer, required): Second operand. Must be a valid integer within the range of `[-2147483648, 2147483647]`.
- **Example Request**:
  ```bash
  curl "http://localhost:8080/sum?a=5&b=3"
  ```
  > **Note**: Special characters in parameters should be URL-encoded.

- **Response**:
  - **Success (200 OK)**:
    ```json
    {
      "result": 8
    }
    ```
  - **Content-Type**: `application/json`

- **Error Handling**:
  - **400 Bad Request**: Returned if either `a` or `b` is missing or not a valid integer.
    ```json
    {
      "error": "Invalid input",
      "message": "Parameter 'a' must be a valid integer.",
      "status": 400
    }
    ```
  - **400 Bad Request**: Returned if the result exceeds the integer range.
    ```json
    {
      "error": "Arithmetic overflow",
      "message": "The result exceeds the maximum or minimum integer value.",
      "status": 400
    }
    ```

- **Additional Notes**:
  - The endpoint supports both positive and negative integers.
  - The endpoint does not support floating-point numbers or non-numeric inputs.
  - For edge cases like large numbers, ensure the result stays within the integer range to avoid overflow errors.

## Future Endpoints
The following endpoints are planned for future improvements:

### Subtraction
- **Endpoint**: `GET /subtract`
- **Description**: Subtracts two integers and returns the result.
- **Parameters**:
  - `a` (integer): First operand
  - `b` (integer): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/subtract?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  2
  ```

### Multiplication
- **Endpoint**: `GET /multiply`
- **Description**: Multiplies two integers and returns the result.
- **Parameters**:
  - `a` (integer): First operand
  - `b` (integer): Second operand
- **Example Request**:
  ```bash
  curl "http://localhost:8080/multiply?a=5&b=3"
  ```
- **Response**:
  ```plaintext
  15
  ```

### Division
- **Endpoint**: `GET /divide`
- **Description**: Divides two integers and returns the result.
- **Parameters**:
  - `a` (integer): First operand
  - `b` (integer): Second operand
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