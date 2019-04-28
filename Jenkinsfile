pipeline {
    agent any
    stages {
        stage('Checkout external proj') {
	    	steps {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/srhkansal/students.git']]])
	    	}
		}
    }

    

    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}