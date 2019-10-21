pipeline {
  agent any
  stages {
    stage('Unit Test') {
      steps {
        bat(label: 'Test running', script: 'mvn test')
        echo 'Hello Testing done'
        bat 'mvn test'
      }
    }
    stage('SonarQube') {
      steps {
        bat 'mvn sonar:sonar  -Dsonar.host.url=http://localhost:9000   		-Dsonar.login=268905bb8bb3507bc82cf06acf9bd7f9bb9635be'
      }
    }
    stage('Maven Build') {
      steps {
        bat(label: 'Maven Build of war file', script: '		mvn clean install			mvn clean install -DskipTests=false					mvn package				')
      }
    }
    stage('Docker Image Build') {
      steps {
        bat(label: 'Docker Image build', script: 'docker build -t jenkinsdemoapp:latest .')
      }
    }
    stage('Deploy Image') {
      steps {
        bat(label: 'Docker Image Run', script: 'docker run -d -p 9090:9090 jenkinsdemoapp:latest')
      }
    }
  }
}