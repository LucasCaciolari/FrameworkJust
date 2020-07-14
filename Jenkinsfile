pipeline {
    agent any
    stages {
        stage('Tests') {
            steps {
                script {
                    if (isUnix()) {
                        dir('src/test/web_drivers') {
                            sh 'chmod +x chromedriver'
                            sh 'chmod +x geckodriver'
                        }
                        withEnv(['DISPLAY=:1']) {
                            sh 'Xvfb :1 -screen 0 1366x768x16 &'
                            sh 'mvn clean test -Dbrowser=chrome'
                        }
                    } else {
                        bat 'mvn clean test -Dbrowser=chrome'
                    }
                    archiveArtifacts artifacts: '**', onlyIfSuccessful: false
                }
            }
        }
        stage('Report') {
                    steps {
                        cucumber '**/*.json'
                         publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/cucumber-reports', reportFiles: 'report.html', reportName: 'Extent Report', reportTitles: 'ExtentReports'])
                    }
                }
    }
}
