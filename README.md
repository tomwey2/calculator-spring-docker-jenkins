# Calculator Spring Boot Application mit Docker und Jenkins

Dieses Projekt ist eine einfache **Calculator Spring Boot-Anwendung**, die grundlegende mathematische Operationen wie Addition, Subtraktion, Multiplikation und Division über eine REST-API bereitstellt. Die Anwendung ist mit **Docker** containerisiert und verwendet **Jenkins** für die Automatisierung von Build, Test und Deployment.

--- 

## 📌 Projektübersicht
- **Spring Boot**: Backend-Anwendung für einen einfachen Taschenrechner mit REST-API.
- **Docker**: Containerisierung der Anwendung für einfache Bereitstellung und Skalierung.
- **Jenkins**: CI/CD-Pipeline zur Automatisierung von Build, Test und Deployment.
- **Maven**: Build-Tool für die Verwaltung von Abhängigkeiten und Build-Prozessen.

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

## 📡 API-Endpunkte
Die Anwendung stellt folgende REST-Endpunkte bereit:

| Endpunkt | Methode | Beschreibung | Beispiel
|----------|---------|--------------|---------
| `/api/calculate/add` | GET | Addition zweier Zahlen | `/api/calculate/add?a=5&b=3` → `8`
| `/api/calculate/subtract` | GET | Subtraktion zweier Zahlen | `/api/calculate/subtract?a=5&b=3` → `2`
| `/api/calculate/multiply` | GET | Multiplikation zweier Zahlen | `/api/calculate/multiply?a=5&b=3` → `15`
| `/api/calculate/divide` | GET | Division zweier Zahlen | `/api/calculate/divide?a=6&b=3` → `2`

--- 

## 🧪 Tests
Die Anwendung enthält Unit-Tests für die `CalculatorService`-Klasse. Um die Tests auszuführen, verwende:
```bash
mvn test
```

--- 

## 🤝 Mitwirken
1. Forke das Repository.
2. Erstelle einen neuen Branch (`git checkout -b feature/neue-funktion`).
3. Committe deine Änderungen (`git commit -am 'Füge neue Funktion hinzu'`).
4. Pushe den Branch (`git push origin feature/neue-funktion`).
5. Erstelle einen Pull Request.

--- 

## 📄 Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Siehe die [LICENSE](LICENSE)-Datei für weitere Informationen.

--- 

## ❓ Support
Falls du Fragen oder Feedback hast, öffne bitte ein Issue im Repository oder kontaktiere den Projektinhaber.