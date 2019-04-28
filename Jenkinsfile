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
    }
    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}