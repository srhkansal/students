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

    

    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}