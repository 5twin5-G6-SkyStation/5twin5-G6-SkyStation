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




	    
        post {

		
       always {
		
            cleanWs()
       }
    }

    
	
}
       
