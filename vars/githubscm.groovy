//https://github.com/aleksei-bulgak/jenkins-shared-library-example/blob/master/src/by/bulgak/jenkins/lib/Checkout.groovy
//https://devopscube.com/create-jenkins-shared-library/

def call(Map stageParams) {

    checkout([
        $class: 'GitSCM',
        branches: [[name:  stageParams.branch ]],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
  }
