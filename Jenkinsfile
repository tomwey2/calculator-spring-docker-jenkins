pipeline {
     agent any
     environment {
        GHCR_CREDENTIALS = credentials("tomwey2-ghcr")
     }
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
        stage("Docker build") {
            steps {
                sh "docker build -t ghcr.io/tomwey2/calculator:latest ."
                sh "docker login --username $GHCR_CREDENTIALS_USR --password $GHCR_CREDENTIALS_PSW ghcr.io"
                sh "docker push ghcr.io/tomwey2/calculator:latest"
            }
        }
    }
    post {
        always {
            sh "docker logout"
        }
    }
 }