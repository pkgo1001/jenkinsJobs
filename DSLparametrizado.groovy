job ('ejemploDSL-MIO'){
  description ('Descripcion del trabajo')
  scm{
    git('https://github.com/pkgo1001/jenkins.git', 'main'){
      node ->
      	node / gitConfigName('pkgo1001')
      	node / gitConfigEmail('pokegoacc1001@gmail.com')
    }
  }
  parameters{
  	stringParam('nombre', defaultValue = 'Wilson', description = 'Descripcion del parametro')
    choiceParam('planewta', ['Tierra', 'Marte', 'Saturno'])
    booleanParam('agente', false)
  }
  triggers{
  	//cron ('H/2 * * * *')	 
  }
  steps{
  	shell("bash jobscript.sh")
  }
  publishers{
  	mailer('pokegoacc1001@gmail.com', true, true)
    slackNotifier{ //instruccione 
    }
    
  }
}
