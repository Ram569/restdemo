pipeline {
    agent any

    environment {
          registry = "ramoji/restdemo:0.0.1"
          registryCredential = 'dockerHub'
          dockerImage = ''
    }

    stages {
        stage('Build and Test') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew clean build'
                }
            }
        }
        stage('Build Docker image') {
            steps {
                script {
                    dockerImage = docker.build registry
                }
            }
        }
        stage('Push image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy to minikube') {
            steps {
                script {
                    sh 'kubectl apply -f app.yaml'
                }
            }
        }
    }
    post {
        success {
            echo 'Successfully built'
        }
    }
}
