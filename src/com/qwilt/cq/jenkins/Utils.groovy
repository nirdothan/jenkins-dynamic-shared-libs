package com.qwilt.cq.jenkins
class Utils implements Serializable {
  
  def steps
  def buildScript
  
  Utils(steps,script) {
    this.steps = steps
    this.buildScript=script
  }


  

   def shell(){  
     steps.sh  "sh ${this.buildScript}"
  }
  

  
  def direct(){  
    steps.sh  this.buildScript
  }
  
  def map(Map config){
    steps.sh "java ${config.cmd}"
  }
  
  def dir(Map config){
    steps.dir ("${config.dir}"){ 
      steps.echo 'hello' 
      steps.sh "${config.cmd}"
    }
  
  }
  
  static def mvn(script, args) {
    script.sh "${script.tool 'Maven'}/bin/mvn -s ${script.env.HOME}/jenkins.xml -o ${args}"
  }
  
  
  
}
