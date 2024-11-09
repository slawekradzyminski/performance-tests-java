pipeline {
    agent {
        docker { 
            image 'maven:3.9.9-eclipse-temurin-21'
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
                sh 'mvn install -DskipTests'
            }
        }
        
        stage('Run Gatling Tests') {
            steps {
                sh 'mvn gatling:test "-Dgatling.simulationClass=com.awesome.testing.BasicSimulation"'
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