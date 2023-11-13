pipeline{
    agent any



    stages {


        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/Mohamedaziztrabelsi-5twin5-G6']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/5twin5-G6-SkyStation/5twin5-G6-SkyStation.git']]])
            }
        }


       stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  "
            }
        }



        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }


}

	    
        post {
success{
		mail bcc: '', body: '''Dear Med Aziz, 
we are happy to inform you that your pipeline build was successful. 
Great work ! 
-Jenkins Team-''', cc: '', from: 'mohmedaziz.trabelsi@esprit.tn', replyTo: '', subject: 'Build Finished - Success', to: 'mohmedaziz.trabelsi@esprit.tn'
		}
		
		failure{
mail bcc: '', body: '''Dear Med Aziz, 
we are sorry to inform you that your pipeline build failed. 
Keep working ! 
-Jenkins Team-''', cc: '', from: 'mohmedaziz.trabelsi@esprit.tn', replyTo: '', subject: 'Build Finished - Failure', to: 'mohmedaziz.trabelsi@esprit.tn'
		}
		
       always {
		
            cleanWs()
       }
    }

    
	
}
       
