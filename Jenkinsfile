pipeline {
    agent { dockerfile true }

    environment {
        DB_URL = credentials('DB_URL')
        DB_USER = credentials('DB_USER')
        DB_PASS = credentials('DB_PASS')
    }

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