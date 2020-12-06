pipeline {
    agent {
        dockerfile true
        args: "-v /var/run/docker.sock:/var/run/docker.sock"
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
                sh "echo $DB_URL"
                sh "echo $DB_USER"
                sh "echo $DB_PASS"
                sh "chmod +x /tadre-moelle/mvnw"
                sh "/tadre-moelle/mvnw clean package"
            }
        }
        stage("Deploy") {
            steps {
                sh "ls"
//                 sh "echo ${SSH_KEY} > keyfile.pem"
//                 sh "sudo chmod 400 keyfile.pem"
//                 sh "scp -i keyfile.pem ${SSH_USER}@${SSH_HOST}/"
            }
        }
    }

}