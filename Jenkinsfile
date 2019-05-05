pipeline {
    agent any
    stages {
        stage('Checkout external proj') {
	    	steps {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/srhkansal/us01_students.git']]])
	    	}
		}

		stage('build project') {
	    	steps {
	        	sh './gradlew build --status'
	    	}
		}

		stage("build & SonarQube analysis") {
            agent any
            steps {
              withSonarQubeEnv('SonarQube') {
              	sh './gradlew sonarqube --stacktrace'
              }
            }
          }
          //stage("Quality Gate") {
            //steps {
              //timeout(time: 1, unit: 'HOURS') {
                //waitForQualityGate abortPipeline: false
              //}
            //}
          //}
	}

    post { 
        always {
            echo 'I will always say Hello again!'
        }
    }
}