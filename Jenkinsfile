node {
    agent any

    stage('Build') {
        withMaven {
            sh "mvn clean package"
        }
    }

    stage("Deploy") {
        sh "echo Deploying..."
    }
}