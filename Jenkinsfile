pipeline {
    agent any

    tools {
        maven 'Maven-3'
    }

    environment {
        DOCKER_IMAGE = "shrunkhood/mini-full-stack-demo"
        IMAGE_TAG = "${BUILD_NUMBER}"
        CONTAINER_NAME ="mini-full-stack"
    }
    environment {
        DB_PASS = credentials('RDS_DB_PASSWORD')
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:$IMAGE_TAG .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push $DOCKER_IMAGE:$IMAGE_TAG
                        docker logout
                    '''
                }
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    echo "Stopping old container..."
                    docker stop $CONTAINER_NAME || true
                    docker rm $CONTAINER_NAME || true

                    echo "Pulling latest image..."
                    docker pull $DOCKER_IMAGE:$IMAGE_TAG

                    echo "Running new container..."
                    docker run -d -e DB_PASS=$DB_PASS -p 8081:8080 --name $CONTAINER_NAME $DOCKER_IMAGE:$IMAGE_TAG

                    echo "Listing running containers..."
                    docker ps
                '''
            }
        }
    }
}
