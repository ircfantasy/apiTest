pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    try {
                        sh "mvn --version"
                    } catch (Exception e) {
                        sh "sudo apt-get -y install maven"
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