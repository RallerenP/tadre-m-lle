node {
    agent { dockerfile true }

    stage('Build') {
        sh "/tadre-m-lle/mvnw clean package"
    }

    stage("Deploy") {
        sh "echo Deploying..."
    }
}