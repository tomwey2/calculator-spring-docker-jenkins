pipeline {
     agent any

     stages {
        stage("compile") {
            steps {
                sh "./mvnw compile"
            }
        }
        stage("Unit test") {
            steps {
                sh "./mvnw test"
            }
        }
        stage("Code coverage") {
            steps {
                sh "./mvnw verify -DskipTests"
                publishHTML (target: [
                    reportDir: "target/site/jacoco",
                    reportFiles: "index.html",
                    reportName: "JaCoCo Report"
                ])
            }
        }
        stage("Static code analysis") {
            steps {
                sh "./mvnw checkstyle:checkstyle"
                publishHTML (target: [
                    reportDir: "target/reports",
                    reportFiles: "checkstyle.html",
                    reportName: "Checkstyle Report"
                ])
            }
        }
    }
 }