pipeline {
     agent any

     stages {
        stage("Checkout") {
            steps {
                git url: "https://github.com/tomwey2/calculator-spring-docker-jenkins.git",
                    branch: "master"
            }
        }
    }
 }