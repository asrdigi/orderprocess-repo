pipeline {
  agent any
  stages {
	stage('Unit Test') {
	   steps {
	       bat label: 'Test running', script: '''mvn test'''
	       echo 'Hello Testing done'
       }
   	}
 	stage('SonarQube'){
       steps{
           bat label: '', script: '''mvn sonar:sonar \
		 -Dsonar.host.url=http://localhost:9000 \
 		-Dsonar.login=fe6b4bc970fe649ae912b67c76430a21d1b5e03e'''
       }
   }
	stage('Maven Build'){
		steps{
				bat label:'Maven Build of war file', script:'''
					mvn clean install -DskipTests=false
					mvn package
				'''
		}
	}
=======
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
>>>>>>> f8e1e3728bfec7381bab5da7057cce07e00f15a5
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