pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/yourusername/product-catalog-service.git'
            }
        }
        
        stage('Build') {
            steps {
                script {
                    sh "${MAVEN_HOME}/bin/mvn clean install"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                // Add your deployment steps here
                // For example:
                // sh "scp target/product-catalog-service.jar user@hostname:/path/to/deploy"
                // sh "ssh user@hostname 'sudo systemctl restart product-catalog-service'"
            }
        }
    }
    
    post {
        success {
            echo 'Build and deployment successful!'
        }
        failure {
            echo 'Build or deployment failed!'
            // Add any cleanup or notification steps here
        }
    }
}
