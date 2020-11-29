pipeline {
    agent { dockerfile true }

    stages {
        stage('Build') {
            steps {
                sh "/tadre-m-lle/mvnw clean package"
            }
        }

        stage("Deploy") {
            steps {
                sh "echo deploying"
            }
        }
    }

}