pipeline{
    agent any
    stages{
        stage ("Deployment"){
            steps{
                ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Deploy.yml'
            }
            
        }
    }
}
