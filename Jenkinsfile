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
               sh "mvn clean test"
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