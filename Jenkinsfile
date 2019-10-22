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
					mvn clean install -DskipTests=true
					mvn package
				'''
		}
	}  

    
    
  }
}