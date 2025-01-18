job('ejemplo-job-DSL') {
	description('Job DSL de ejemplo jenkins')
  	scm {
      git('https://github.com/quirogaleandro/jenkins-DSL.git,'main') { node -> 
        node / gitConfigName('quirogaleandro')
        node / gitConfigEmail('quirogaleandrob@gmail.com')
      }
    }
  	triggers { 
      cron ('H/7 * * * *')
    }
  	steps {
    	shell("bash jobscript.sh")
    }
  	publishers {
    	mailer('benjaminlbq12@gmail.com', true, true)
    }
}