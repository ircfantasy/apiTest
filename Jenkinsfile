pipeline {
  agent any
  stages{
       stage ('Build'){
        steps {
        echo "Building ..."
//           sh 'mvn clean package'
        }
         post {
           success {
             echo 'Archiving...'
//              archiveArtifacts artifacts:'**/target/*.war'
           }
         }
       }
       stage ('Deployment') {


       echo "Deploying..."
//          parallel{
//            stage ('Deploy to Staging'){
//              steps {
//                sh "cp **/target/*.war /home/ivan/programms/tomcat-staging/webapps"
//              }
//            }
//            stage ('Deploy to prod') {
//              steps {
//                sh "cp **/target/*.war /home/ivan/programms/tomcat-prod/webapps"
//              }
//            }
//          }
       }
    }
} 