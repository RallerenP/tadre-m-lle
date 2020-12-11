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
                sh "cd /tadre-moelle/ && git pull origin rallerenp-dev" // Jenkins uses a cached Dockerfile, so I have to pull manually.
                sh "/tadre-moelle/mvnw clean package"
            }
        }
        stage('Prepare Deployment') {
            steps {
                sh "mkdir /deploy/"
                sh "cp /var/jenkins_home/workspace/tadre/target/tadre-moelle-0.0.1-SNAPSHOT.jar /deploy/app.jar"
                sh "cp /tadre-moelle/prep/Dockerfile /deploy/" 
                sh "docker rmi tadre:latest || true"
                sh "docker build -t tadre:latest /deploy/"
                sh "docker save -o /deploy/tadre.tar tadre:latest"
            }
        }
        stage("Deploy") {
            steps {
                sshagent(credentials: ['SSH_CREDENTIALS']) {
                    sh "ls /"
                    sh "ls /deploy/"
                    sh "ssh -v -o StrictHostKeyChecking=no ubuntu@34.235.77.148 'sudo rm -rf /tadre/ && sudo mkdir /tadre && sudo chmod 777 /tadre'"
                    sh "scp -v -o StrictHostKeyChecking=no /deploy/tadre.tar ubuntu@34.235.77.148:/tadre/tadre.tar"
                    sh "ssh -v -o StrictHostKeyChecking=no ubuntu@34.235.77.148 'sudo docker stop tadre || true && sudo docker rm tadre || true && sudo docker rmi tadre:latest || true && sudo docker load < /tadre/tadre.tar && sudo docker create --name tadre -p 8081:8081 -v /tmp/:/datapath/ --env DB_URL=\${DB_URL} --env DB_USER=\${DB_USER} --env DB_PASS=\${DB_PASS} tadre:latest && sudo docker start tadre'"
                }
            }
        }
    }

}