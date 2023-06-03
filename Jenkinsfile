pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
               sh "/usr/local/Cellar/maven/3.8.2/bin/mvn clean package"
            }
        }
        stage('Test') {
            steps {
                echo "Testing..."
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying..."
            }
        }
    }
}