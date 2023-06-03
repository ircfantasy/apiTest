pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
//                 sh 'mvn clean package'
                sh "chmod +x mvnw && ./mvnw -B clean test"
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