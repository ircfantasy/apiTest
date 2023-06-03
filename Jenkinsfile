pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
            try{
            sh "mvn --version"
                      }catch(IOException e){
                      sh "sudo apt-get -y install maven"
                    }
                sh 'mvn clean package'
//                 sh "chmod +x mvnw && ./mvnw -B clean test"
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