pipeline {
    agent any

    environment {
        IMAGE_NAME = 'chaerish/skala-spring-stock'
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh './gradlew clean bootJar'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $IMAGE_NAME:$IMAGE_TAG ."
                sh "docker tag $IMAGE_NAME:$IMAGE_TAG $IMAGE_NAME:latest"
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-hub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh "docker push $IMAGE_NAME:$IMAGE_TAG"
                    sh "docker push $IMAGE_NAME:latest"
                }
            }
        }

        stage('Deploy') {
            steps {
                sh "docker stop spring-app || true"
                sh "docker rm spring-app || true"
                sh "docker run -d --name spring-app -p 8080:8080 $IMAGE_NAME:latest"
            }
        }
    }

    post {
        always {
            sh 'docker logout'
        }
    }
}
