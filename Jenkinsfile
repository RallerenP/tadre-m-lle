pipeline {
    agent { dockerfile true }

    environment {
        DB_USER = credentials('DB_URL')
    }

    stages {
        stage('Build') {
            steps {
                sh "echo $DB_USER"
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