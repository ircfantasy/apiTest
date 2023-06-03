pipeline {
    agent any
    stages {
        stage('Check Maven') {
            steps {
               sh 'echo $PATH'
                }
            }
        stage('Build') {
            steps {
               sh "/usr/local/Cellar/maven/3.8.2/bin/mvn clean test"
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