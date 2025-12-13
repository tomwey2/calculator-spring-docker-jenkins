# Calculator Spring Boot Application with Docker and Jenkins

A simple calculator implemented as a Spring Boot application, exposed via a REST API. The project is containerized using Docker and includes a Jenkins pipeline for CI/CD.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation and Execution](#installation-and-execution)
  - [Local Execution](#local-execution)
  - [Docker Execution](#docker-execution)
  - [Development Mode](#development-mode)
- [CI/CD with Jenkins](#cicd-with-jenkins)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Troubleshooting](#troubleshooting)

## Features
- REST API for basic arithmetic operations: addition, subtraction, multiplication, and division.
- Containerized using Docker for easy deployment.
- CI/CD pipeline using Jenkins for automated builds and deployments.
- Unit and integration tests for reliability.

## Technologies
- **Java 11**: Programming language.
- **Spring Boot 2.x**: Framework for building the application.
- **Maven**: Build tool and dependency management.
- **Docker**: Containerization platform.
- **Jenkins**: Automation server for CI/CD.

## Prerequisites
Ensure the following tools are installed on your system:
- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://docs.docker.com/get-docker/)
- [Jenkins](https://www.jenkins.io/doc/book/installing/) (optional, for CI/CD)

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

   To stop and remove the container:
   ```bash
   docker stop <container_id>
   docker rm <container_id>
   ```

### Development Mode
You can also run the application in your preferred IDE (e.g., IntelliJ IDEA or Eclipse):
1. Open the project in your IDE.
2. Run the `CalculatorApplication` class as a Java application.

## CI/CD with Jenkins
The project includes a `Jenkinsfile` for setting up a CI/CD pipeline. To use it:
1. Ensure Jenkins is installed and running.
2. Create a new pipeline job in Jenkins and point it to this repository.
3. Jenkins will automatically build, test, and deploy the application based on the pipeline configuration.

## API Endpoints
The application provides the following endpoints:

| Operation      | Endpoint                          | Example Request                     | Example Response |
|-----------------|-----------------------------------|-------------------------------------|------------------|
| Addition        | `GET /api/calculate/add?a={a}&b={b}` | `GET /api/calculate/add?a=5&b=3`    | `8`              |
| Subtraction     | `GET /api/calculate/subtract?a={a}&b={b}` | `GET /api/calculate/subtract?a=5&b=3` | `2`              |
| Multiplication  | `GET /api/calculate/multiply?a={a}&b={b}` | `GET /api/calculate/multiply?a=5&b=3` | `15`             |
| Division        | `GET /api/calculate/divide?a={a}&b={b}` | `GET /api/calculate/divide?a=6&b=3` | `2`              |

## Testing
Run the tests using Maven:
```bash
mvn test
```

To generate a test report:
```bash
mvn surefire-report:report
```
The report will be available in the `target/site/surefire-report.html` file.

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch to your fork.
4. Open a pull request to the `main` branch of this repository.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Troubleshooting
- **Port Conflict**: If port `8080` is already in use, stop the conflicting service or change the port in `application.properties`.
- **Docker Issues**: Ensure Docker is running and you have the necessary permissions.
- **Build Failures**: Check the Maven output for errors and ensure all dependencies are correctly resolved.