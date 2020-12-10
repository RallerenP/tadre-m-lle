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
        stage('Prepare') {
            steps {
                sh "mkdir /deploy/"
                sh "ls /tadre-moelle"
                sh "cp /var/jenkins_home/workspace/tadre/target/tadre-moelle-0.0.1-SNAPSHOT.jar /deploy/app.jar"
                sh "cp /tadre-moelle/prep/Dockerfile /deploy/"
                sh "sudo docker build -t tadre:latest"
                sh "sudo docker save tadre:latest > tadre.tar"
                sh "ls /deploy/"
            }
        }

        stage("Deploy") {
            steps {
                sh 'ls /var/jenkins_home/workspace/tadre/target/'
                 //sh "echo ${SSH_KEY} > keyfile.pem"
                 //sh "sudo chmod 400 keyfile.pem"
                 //sh "scp -i keyfile.pem  ${SSH_USER}@${SSH_HOST}/keyfile.pem /tadre-moelle/target/"
            }
        }
    }

}