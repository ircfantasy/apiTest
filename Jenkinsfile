pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    try {
                        sh "mvn --version"
                    } catch (Exception e) {
                        def mvnHome = tool 'Maven'
                        sh "/usr/local/Cellar/maven/3.8.2/bin/mvn clean package"
                    }
                }
                sh 'mvn clean package'
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