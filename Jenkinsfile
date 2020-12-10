pipeline {
    agent {
        dockerfile true
    }

    environment {
        DB_URL = credentials('DB_URL')
        DB_USER = credentials('DB_USER')
        DB_PASS = credentials('DB_PASS')
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
                sshagent(credentials: ['SSH_CREDENTIALS']) {
                    sh "ls /"
                    sh "ls /deploy/"
                    sh "scp -v -o StrictHostKeyChecking=no /deploy/tadre.tar ubuntu@3.238.174.161:/tadre/tadre.tar"
                    sh "ssh -v -o StrictHostKeyChecking=no ubuntu@3.238.174.161 'sudo docker load -i /tadre/tadre.tar'"
                }
            }
        }
    }

}