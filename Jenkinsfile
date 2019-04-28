pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
            	echo 'Checkout starts'
            	git checkout 'https://github.com/srhkansal/students.git'
            	echo 'Checkout ends'
            }
        }

        stage('build step') {
            steps {
            	echo 'build starts'
            	./gradlew buildß
                echo 'build ends'
            }
        }
    }

    

    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}