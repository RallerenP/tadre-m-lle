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
        stage('Prepare Deployment') {
            steps {
                sh "mkdir /deploy/"
                sh "cp /var/jenkins_home/workspace/tadre/target/tadre-moelle-0.0.1-SNAPSHOT.jar /deploy/app.jar"
                sh "cp /tadre-moelle/prep/Dockerfile /deploy/"
                sh "docker build -t tadre:latest /deploy/"
                sh "docker save -o /deploy/tadre.tar tadre:latest"
            }
        }
        stage("Deploy") {
            
            steps {
                sh "ls /"
                sh "ls /deploy/"
                sh "echo ${SSH_KEY} > keyfile.pem"
                sh "cat keyfile.pem"
                sh "sudo chmod 400 keyfile.pem"
                sh "scp -i keyfile.pem /deploy/tadre.tar ${SSH_USER}@${SSH_HOST}:/tadre/ "
            }
        }
    }

}