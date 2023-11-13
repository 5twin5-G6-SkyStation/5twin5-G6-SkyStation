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


/*
         stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }
*/


    /*    stage('Code Quality Check via SonarQube') {
            steps{

             		sh " mvn clean verify sonar:sonar -Dsonar.projectKey=cicd -Dsonar.projectName='cicd' -Dsonar.host.url=http://172.10.0.140:9000 -Dsonar.token=sqp_967f7ce856cba9eaaff2c1d53a4c9da867b1b7eb"

            }
        }


        stage('Publish to Nexus') {
            steps {


  sh 'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=gestion-station-ski -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=maven-releases -Durl=http://172.10.0.140:8081/repository/maven-releases/ -Dfile=target/gestion-station-ski-1.0.jar'

            }
        }

stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t azizoss/5twin5-g6-skystation:mohamedaziztrabelsi-5Twin5-g6 .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {
				sh 'docker login -u azizoss --password dckr_pat_v9UjMySVbpzx2SmxlGfY7MsMik8'
                                            }
		  }
	    
	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push azizoss/5twin5-g6-skystation:mohamedaziztrabelsi-5Twin5-g6 '
                                            }
		  }


		   stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up -d'
                                    }
                                }
                            }

	    



     
}
*/
	    
        post {

		
       always {
		
            cleanWs()
       }
    }

    
	
}
       
