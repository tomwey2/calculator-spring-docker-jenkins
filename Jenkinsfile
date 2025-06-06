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
    }
 }