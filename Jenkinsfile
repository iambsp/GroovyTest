node {
    
    def mvn_version = 'MAVEN_HOME'
           def uploadSpec = """{
           "files": [
               {
               "pattern": "target/BSP-SNAPSHOT-1.1.${BUILD_NUMBER}.war",
                   "target": "libs-snapshot-local/com/workout/BSP/1.1.${BUILD_NUMBER}-SNAPSHOT/"
               }
               ]
           }"""
                  stage('CheckOut From GIT'){
        git 'https://topgear-training-gitlab.wipro.com/BH371006/WorkFinalOut_Groovy'
        echo '*************CheckedOut from GIT Successfully*************'
    }
    stage ("Unit Testing"){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        sh "${mvnHome}/bin/mvn test -Dtest=AppTest.java"
	echo '*************Unit Test was Successful************'
	        jacoco()

        step([$class: 'JUnitResultArchiver', testResults: 'target/surefire-reports/*.xml'])
        
    echo '*************Report Generated************'    

    }

    stage('SonarQube PreBuild Analysis'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        withSonarQubeEnv('scan') {
            sh "${mvnHome}/bin/mvn sonar:sonar -Dsonar.projectName=WorkOutQuality${BUILD_NUMBER} -Dv=${BUILD_NUMBER}"
            echo '*************Prebuild Analysis was Successful************'
        }
    }
    stage('Compile-Package'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        sh "${mvnHome}/bin/mvn compile"
        echo '*************Compiled Successfully*************'
    }
    
    
    stage('Building WAR file'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        sh "${mvnHome}/bin/mvn install -U -DskipTests -Dmaven.main.skip -Dv=${BUILD_NUMBER}"
        echo '*************Build WAR Successfully*************'
    }
    
    stage("Starting Tom")
    {
    step([$class: 'AnsiblePlaybookBuilder', additionalParameters: '', ansibleName: 'ansible 2.4.2.0', becomeUser: '', credentialsId: '', forks: 5, limit: '', playbook: '/home/osgdev/ansilab/tomcat.yml', skippedTags: '', startAtTask: '', sudo: true, sudoUser: 'osgdev', tags: '', vaultCredentialsId: ''])
    }

    stage ("Integration Testing"){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        sh "${mvnHome}/bin/mvn test -Dtest=IntTest.java"

    }

    stage("Shutingdown Tom")
    {
        step([$class: 'AnsiblePlaybookBuilder', additionalParameters: '', ansibleName: 'ansible 2.4.2.0', becomeUser: '', credentialsId: '', forks: 5, limit: '', playbook: '/home/osgdev/ansilab/shut.yml', skippedTags: '', startAtTask: '', sudo: true, sudoUser: 'osgdev', tags: '', vaultCredentialsId: ''])
    } 

    stage('SonarQube PostBuild Analysis'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven'
        withSonarQubeEnv('scan') {
            sh "${mvnHome}/bin/mvn sonar:sonar -Dsonar.projectName=WorkOutQuality${BUILD_NUMBER} -Dv=${BUILD_NUMBER}"
            echo '*************Postbuild Analysis was Successful*************'
        }
    }
    stage("Quality Gate Check"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
                  echo '*************Quality Gate Check was Successful*************' 
              }
          }
      }
               stage('Uploading to Artifactory') {
               withEnv( ["PATH+MAVEN=${tool mvn_version}/bin/"] ) {
                                 script {
                                        def server = Artifactory.server 'artifact' 
                                        server.bypassProxy = true
                                        def buildInfo = server.upload spec: uploadSpec
                                        echo '*************Uploaded artifacts to Artifactory was Successful*************'
                                        }
                    }
                
}
                stage('Download Artifacts') {
                    script {
                        sh "rm -rf /home/osgdev/BSP/Artifacts/*.war"
                        echo '*********Removed the Old WAR files*********'
         sh "wget http://10.199.7.220:5040/artifactory/libs-snapshot-local/com/workout/BSP/1.1.${BUILD_NUMBER}-SNAPSHOT/BSP-SNAPSHOT-1.1.${BUILD_NUMBER}.war -P /home/osgdev/BSP/Artifacts"
         echo '**********Artifacts Downloaded Successfully**********'
    }
}

}
