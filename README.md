# Calculator Spring Boot Application 🧮

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.0-green)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-20.10.7-blue)](https://www.docker.com/)
[![Jenkins](https://img.shields.io/badge/Jenkins-2.332.2-orange)](https://www.jenkins.io/)

A simple calculator application built with **Spring Boot**, containerized with **Docker**, and deployed using **Jenkins** for CI/CD. This project provides a REST API for basic arithmetic operations.

## Features
- REST API for addition, subtraction, multiplication, and division.
- Dockerized for easy deployment.
- Jenkins pipeline for automated builds and deployments.
- Unit and integration tests for reliability.

## Technologies
- **Spring Boot 3.1.0**: Java framework for building the application.
- **Docker 20.10.7**: Containerization of the application.
- **Jenkins 2.332.2**: CI/CD pipeline automation.
- **Maven**: Build tool and dependency management.

## Prerequisites
Ensure you have the following installed:
- **Java 11+** (Recommended: OpenJDK 11)
- **Maven 3.8.6+**
- **Docker 20.10.7+**
- **Jenkins 2.332.2+** (Optional, for CI/CD)

## Installation and Execution
### 1. Clone the Repository
```bash
git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
cd calculator-spring-docker-jenkins
```

### 2. Local Execution
#### Build the Application
```bash
mvn clean install
```

#### Run the Application
```bash
mvn spring-boot:run
```
The application will start and be available at:
👉 [http://localhost:8080](http://localhost:8080)

### 3. Docker Execution
#### Build the Docker Image
```bash
docker build -t calculator-spring-app .
```

#### Run the Container
```bash
docker run -p 8080:8080 calculator-spring-app
```
The application will be available at:
👉 [http://localhost:8080](http://localhost:8080)

### 4. CI/CD with Jenkins
The project includes a `Jenkinsfile` for automated builds and deployments. To use it:
1. Set up a Jenkins server.
2. Create a new pipeline job and point it to this repository.
3. Configure Jenkins to use the `Jenkinsfile` for the pipeline.

## API Documentation
The application provides the following endpoints:

### Addition
- **Endpoint**: `GET /api/calculate/add?a={a}&b={b}`
- **Example**: `GET /api/calculate/add?a=5&b=3`
- **Response**: `8`

### Subtraction
- **Endpoint**: `GET /api/calculate/subtract?a={a}&b={b}`
- **Example**: `GET /api/calculate/subtract?a=5&b=3`
- **Response**: `2`

### Multiplication
- **Endpoint**: `GET /api/calculate/multiply?a={a}&b={b}`
- **Example**: `GET /api/calculate/multiply?a=5&b=3`
- **Response**: `15`

### Division
- **Endpoint**: `GET /api/calculate/divide?a={a}&b={b}`
- **Example**: `GET /api/calculate/divide?a=6&b=3`
- **Response**: `2`

### Error Handling
- If division by zero is attempted, the API returns a `400 Bad Request` with an error message.

## Testing
Run the tests using Maven:
```bash
mvn test
```

### Test Coverage
- Unit tests for `CalculatorService`.
- Integration tests for `CalculatorController`.

## Project Structure
```
.
├── src
│   ├── main
│   │   ├── java/com/tomwey2/calculator
│   │   │   ├── CalculatorApplication.java  # Main Spring Boot application
│   │   │   ├── CalculatorController.java    # REST API endpoints
│   │   │   └── CalculatorService.java       # Business logic
│   │   └── resources
│   │       └── application.properties       # Configuration
│   └── test
│       └── java/com/tomwey2/calculator
│           ├── CalculatorApplicationTests.java  # Application tests
│           └── CalculatorServiceTest.java       # Service tests
├── Dockerfile                                # Docker configuration
├── Jenkinsfile                               # Jenkins pipeline
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

## Contributing
Contributions are welcome! Follow these steps:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

## License
This project is licensed under the **MIT License**. See [LICENSE](LICENSE) for details.

## Troubleshooting
### Common Issues
1. **Port 8080 already in use**:
   - Solution: Stop the conflicting service or change the port in `application.properties`.
2. **Docker build fails**:
   - Solution: Ensure Docker is running and you have sufficient permissions.
3. **Maven build fails**:
   - Solution: Check your Java and Maven versions and ensure they meet the requirements.

### Need Help?
Open an issue on GitHub or contact the maintainers.