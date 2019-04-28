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

		stage('Sonarqube') {
		    steps {
		        withSonarQubeEnv('sonarqube') {
		            sh './gradlew sonarqube'
		        }
		        timeout(time: 10, unit: 'MINUTES') {
		            waitForQualityGate abortPipeline: true
		        }
		    }
		}ß    
}

    post { 
        always { ßß
            echo 'I will always say Hello again!'
        }
    }
}