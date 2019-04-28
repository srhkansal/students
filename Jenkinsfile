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
	        	sh './gradlew clean build'
	    	}
		}
    }

	stage('SonarQube analysis') {
	    withSonarQubeEnv('My SonarQube Server') {
	        sh './gradlew sonarqube'
	    } // SonarQube taskId is automatically attached to the pipeline context
	  }

   stage("Quality Gate"){
    timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
        error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}

    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}