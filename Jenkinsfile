pipeline {
    agent {
        docker { 
            image 'maven:3.9.9-eclipse-temurin-17-alpine'
        }
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Install Dependencies') {
            steps {
                sh './mvnw install -DskipTests'
            }
        }
        
        stage('Run Gatling Tests') {
            steps {
                sh './mvnw gatling:test -Dgatling.simulationClass=com.awesome.testing.BasicSimulation'
            }
        }
    }
    
    post {
        always {
            // Archive Gatling reports
            archiveArtifacts artifacts: 'target/gatling/**/*', fingerprint: true
            
            // Publish Gatling reports
            gatlingArchive()
        }
        failure {
            echo 'Tests failed! Check the Gatling reports for details.'
        }
    }
}