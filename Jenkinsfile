pipeline {
    agent any
    stages {
        stage('Checkout external proj') {
	    	steps {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/srhkansal/students.git']]])
	    	}
		}

		stage('build project') {
	    	steps {
	    		gradle --stop
	        	sh './gradlew build'
	        	gradle --stop
	    	}
		}

		stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('My SonarQube Server') {
              	gradle --stop
                sh './gradlew sonarqube'
                gradle --stop
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }	
	}

    post { 
        always {
            echo 'I will always say Hello again!'
        }
    }
}