#!groovy
pipeline {
    agent any
    tools {
        maven 'MVN3'
    }
    environment {
        // SERVER_DEV_SFE_CREDENTIAL = credentials('server.sfe.credential')
        PATH_BACKEND_API_WS = "${WORKSPACE}/upb/upb/"
    }
    stages {
        stage('Descargando de repositorio.') {
            steps {
                sh 'rm -rf *'
                checkout scm
            }
        }


        stage('Compilando..') {
            parallel {
                stage("Compilando backend"){
                    stages{
                        stage("Compilando Backend") {
                            steps {
                                ws(env.PATH_BACKEND_API_WS) {
                                    sh 'mvn clean compile'
                                }
                            }
                        }

                        stage('Junit') {
                            steps {
                                ws(env.PATH_BACKEND_API_WS) {
                                    sh 'mvn clean'
                                }
                            }
                        }

                        stage('SonarQube') {
                            steps {
                                dir(env.PATH_BACKEND_API_WS) {
                                    withSonarQubeEnv('SonarQube') {
                                        sh 'mvn clean package sonar:sonar -Dmaven.test.skip=true'
                                    }
                                }
                            }
                        }
                        stage("Verificando Calidad") {
                            steps {
                                timeout(time: 1, unit: 'HOURS') {
                                    waitForQualityGate abortPipeline: true
                                }
                            }
                        }

                    }
                }
            }
         }






        stage('Desplegando artefactos') {
          parallel {
            stage("Desplegando en desarrollo"){
                when {
                  branch 'main'  //only run these steps on the master branch
                }
                stages{
                    stage('Compilando para despliegue') {
                        steps {
                            ws(env.PATH_BACKEND_API_WS) {
                                sh "mvn clean package -Dmaven.test.skip=true"
                            }
                        }
                    }
                }
            }
          }
        }


        stage('Archivar resultados') {
            steps {
                step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
            }
        }
    }
    post {
        failure {
            mail to: 'rlaredo@mc4.com.bo', cc: "", charset: "UTF-8",
                    subject: ": ${currentBuild.fullDisplayName}",
                    body: "Se genero un error al ejecutor de tareas de jenkins. ${env.BUILD_URL}"
        }

        success {
            mail to: 'rlaredo@mc4.com.bo', cc: "", charset: "UTF-8",
                    subject: ": ${currentBuild.fullDisplayName}",
                    body: "La aplicación se ejecutó exitosamente" +
                            "" +
                            " ${env.BUILD_URL}"
        }

    }
}
