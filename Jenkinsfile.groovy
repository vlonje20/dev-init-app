pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        JAVA_HOME = tool name: 'Java', type: 'jdk'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vlonje20/https://github.com/vlonje20/jenkins-CICD.git'
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Static Code Analysis with SonarQube') {
            steps {
                withSonarQubeEnv('http://localhost:9000') {
                    sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
                }
            }
        }

        stage('Deploy to Nexus') {
            steps {
                script {
                    def server = Artifactory.server 'http://localhost:8081'
                    def rtMaven = Artifactory.newMavenBuild()
                    rtMaven.deployer server: server, releaseRepo: 'jenkins-app-releases', snapshotRepo: 'jenkins-app-snapshots'
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
                sh "curl -T target/*.war http://vin:drama@http://localhost:8080/manager/text/deploy?path=/jenkins-app-pipeline"
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
  
##


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
  

====================================

pipeline {
    agent any

    environment {
  maven3.9.6 = "MAVEN_HOME"
}

    stages {
  stage('git clone') {
    steps {
      git 'https://github.com/vlonje20/jenkins-CICD.git'
    }
  }
  
  stage('Build') {
     steps {
      sh "${MAVEN_HOME}/bin/mvn clean install"
    }
  }
}

}


============================

node{
  def mavenHome = tool name: 'maven3.9.6'
  stage('CodeClone') {
    git credentialsId: 'git-cred', url: 'https://github.com/vlonje20/jenkins-CICD.git'
  }
  stage('mavenBuild') {
    sh "${mavenHome}/bin/mvn clean package"
  }

  stage('CodeQuality') {
    sh "${mavenHome}/bin/mvn sonar:sonar"
  // execute the CodeQuality report with sonar
  }
  stage('emailQualityIssues') {
    emailext body: '''Thanks

Vin Technologies''', recipientProviders: [developers()], subject: 'status of build', to: 'allinovin88@gmail.com'
  }

   stage('UploadNexus') {
    sh "${mavenHome}/bin/mvn deploy"
    //mvn deploy  are uploaded in to nexus
  }

  stage('DeployTomcat') {
    deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:8080/')], contextPath: null, war: 'target/*war'
  }
  stage('emailDeployIssues') {
    emailext body: '''Thanks

Vin Technologies''', recipientProviders: [developers()], subject: 'status of build', to: 'allinovin88@gmail.com'
  }
}

