# Calculator Spring Boot Docker Jenkins

Ein einfaches, aber leistungsfähiges Projekt, das einen Taschenrechner als Spring Boot-Anwendung implementiert. Das Projekt ist mit Docker containerisiert und nutzt Jenkins für CI/CD (Continuous Integration/Continuous Deployment).

## 📌 Features
- **Spring Boot**: Backend-Implementierung des Taschenrechners mit REST-API.
- **Docker**: Containerisierung der Anwendung für einfache Bereitstellung.
- **Jenkins**: Automatisierte Builds, Tests und Deployments.
- **REST-API**: Einfache HTTP-Endpunkte für mathematische Operationen.

## 🛠 Technologien
- **Java 17**: Programmiersprache für die Backend-Logik.
- **Spring Boot 3.x**: Framework für die Webanwendung.
- **Docker**: Containerisierung der Anwendung.
- **Jenkins**: CI/CD-Pipeline für Automatisierung.
- **Maven**: Build-Tool für die Abhängigkeitsverwaltung.

## 🚀 Schnellstart

### Voraussetzungen
- [Docker](https://www.docker.com/) installiert
- [Jenkins](https://www.jenkins.io/) (optional, für CI/CD)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (falls lokal entwickelt wird)
- [Maven](https://maven.apache.org/) (falls lokal gebaut wird)

### Anwendung starten
1. **Docker-Image bauen und starten**
   ```bash
   docker build -t calculator-spring .
   docker run -p 8080:8080 calculator-spring
   ```
2. **API aufrufen**
   Die Anwendung stellt eine REST-API bereit, die unter `http://localhost:8080/api/calculate` erreichbar ist. Beispielaufruf:
   ```bash
   curl -X POST http://localhost:8080/api/calculate -H "Content-Type: application/json" -d '{"num1": 5, "num2": 3,