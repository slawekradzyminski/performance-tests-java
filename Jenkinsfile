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
                sh 'mvn -B -q install -DskipTests'
            }
        }
        
        stage('Run Gatling Tests') {
            steps {
                sh 'mvn -B -q gatling:test "-Dgatling.simulationClass=com.awesome.testing.CISimulation"'
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'target/gatling/**/*', fingerprint: true
            
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/gatling',
                reportFiles: '**/index.html',
                reportName: 'Gatling Report'
            ])
        }
        failure {
            echo 'Tests failed! Check the Gatling reports for details.'
        }
    }
}