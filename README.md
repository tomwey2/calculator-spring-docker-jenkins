# Calculator Spring Boot Application mit Docker und Jenkins

Dieses Projekt ist eine einfache **Calculator Spring Boot-Anwendung**, die mit **Docker** containerisiert und über **Jenkins** automatisiert gebaut, getestet und bereitgestellt wird.

---

## 📌 Projektübersicht
- **Spring Boot**: Backend-Anwendung für einen einfachen Taschenrechner.
- **Docker**: Containerisierung der Anwendung für einfache Bereitstellung.
- **Jenkins**: CI/CD-Pipeline zur Automatisierung von Build, Test und Deployment.

---

## 🛠️ Voraussetzungen
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Jenkins](https://www.jenkins.io/)

---

## 🚀 Installation und Ausführung

### 1. Projekt klonen
```bash
git clone https://github.com/tomwey2/calculator-spring-docker-jenkins.git
cd calculator-spring-docker-jenkins
```

### 2. Anwendung lokal ausführen
```bash
mvn spring-boot:run
```
Die Anwendung ist dann unter [http://localhost:8080](http://localhost:8080) erreichbar.

### 3. Docker-Image bauen und ausführen
```bash
docker build -t calculator-spring-app .
docker run -p 8080:8080 calculator-spring-app
```

### 4. Jenkins-Pipeline einrichten
1. Jenkins auf deinem Server oder lokal installieren.
2. Ein neues Jenkins-Projekt erstellen und die `Jenkinsfile` aus diesem Repository verwenden.
3. Die Pipeline ausführen, um Build, Test und Deployment zu automatisieren.

---

## 📂 Projektstruktur
```
calculator-spring-docker-jenkins/
├── src/
│   ├── main/
│   │   ├──