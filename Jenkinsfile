pipeline {
    agent any
    stages {
        stage('Checkout external proj') {
	    	steps {
	        	checkout([$class: 'GitSCM', branches: [[name: '*/release-students']], userRemoteConfigs: [[url: 'https://github.com/srhkansal/students.git']]])
	    	}
		}

		stage('build project') {
	    	steps {
	        	sh './gradlew build --status'
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