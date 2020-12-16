pipeline{
    agent any
    stages{
        stage ("Deploy"){
            steps{
                ansiblePlaybook installation: 'ansible', inventory: 'localhost', playbook: '/var/jenkins_home/ansible/Deploy.yml'
            }
            
        }
    }
}
