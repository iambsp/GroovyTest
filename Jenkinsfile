pipeline{
    agent any
    stages{
        
        stage('Checking Docker Status')
        {
            steps{
                sh '''#!/bin/bash

                    if docker run hello-world | grep -q 'Hello from Docker!'; then
                        echo "Docker is Up and Running Fine!"
                    else
                        exit 1
                    fi
                    '''
        }
        }
        stage('Cleaning Docker Container')
        {
        parallel{

        stage ("Stop Container"){
            steps{
                ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Stop_Container.yml'
                echo '*************Container has been stopped Successfully*************'
            }
            
        }
        stage ("Remove Container"){
            steps{
                ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Remove_Container.yml'
                echo '*************Container has been removed Successfully*************'
            }
            
        }
        }
        }
        stage ("Remove Docker Image"){
            steps{
                ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Remove_Image.yml'
                echo '*************Image has been removed Successfully*************'
            }
            
        }
        stage ("Build Docker Image"){
            steps{
                //ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Build_Image.yml'
                sh 'docker build -t webapp /var/jenkins_home/ansible/ --no-cache'
                echo '*************Image Built Successfully*************'
            }
            
        }
        stage ("Run Docker Container"){
            steps{
                //ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Run_Container.yml'
                sh 'docker run -d -p 8989:8080 --name workout webapp'
                echo '*************Container Running Successfully*************'
            }
            
        }
    }
}
