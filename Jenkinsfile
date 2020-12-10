pipeline {
    agent {
        dockerfile true
    }

    environment {
        DB_URL = credentials('DB_URL')
        DB_USER = credentials('DB_USER')
        DB_PASS = credentials('DB_PASS')

        SSH_HOST = credentials('SSH_HOST')
        SSH_USER = credentials('SSH_USER')
        SSH_KEY = credentials('SSH_KEY')
    }

    stages {
        stage('Build') {
            steps {
                sh "chmod +x /tadre-moelle/mvnw"
                sh "/tadre-moelle/mvnw clean package"
            }
        }
        stage("Deploy") {
            steps {
                 sh "echo ${SSH_KEY} > keyfile.pem"
                 sh "sudo chmod 400 keyfile.pem"
                 sh "scp -i keyfile.pem  ${SSH_USER}@${SSH_HOST}/keyfile.pem"
            }
        }
    }

}