pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Check out the source code from Git
                
                 git 'https://github.com/YeliasAhmed/LombokBuilderPatternJavaUnirestLibrary.git'
            }
        }

        stage('Build') {
            steps {
                // Build your Java project here
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests if applicable
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy your application if applicable
                // This can vary depending on your project
                 sh 'Deploy'
            }
        }
    }
}
