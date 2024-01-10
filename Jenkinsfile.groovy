
pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        JAVA_HOME = tool name: 'Java', type: 'jdk'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/your-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Static Code Analysis with SonarQube') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
                }
            }
        }

        stage('Deploy to Nexus') {
            steps {
                script {
                    def server = Artifactory.server 'NexusServer'
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.deployer server: server, releaseRepo: 'releases', snapshotRepo: 'snapshots'
                    rtMaven.tool = MAVEN_HOME
                    rtMaven.deployer.deployArtifacts = true
                    rtMaven.deployer.deployBuildInfo = true
                    rtMaven.run pom: 'pom.xml', goals: 'clean deploy'
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                // Write steps to deploy to Tomcat here
                // For example, using curl to deploy a WAR file
                sh "curl -T target/*.war http://tomcat_username:password@tomcat_url/manager/text/deploy?path=/myapp"
            }
        }
    }

    post {
        always {
            // Clean up, notifications, or other actions to execute regardless of build result
        }
        success {
            // Actions to execute only if the build is successful
        }
        failure {
            // Actions to execute only if the build fails
        }
    }
}
  
