//https://github.com/vfarcic/jenkins-shared-libraries/blob/master/vars/ciK8sBuildImage.groovy
def call(image, sudo = true, tag) {

    prefix = ""
    if (sudo) {
        prefix = "sudo "
    }
    sh """${prefix}docker image build \
        -t ${image}:${tag} ."""

    //sh """${prefix}docker login \
    //        -u $USER -p $PASS"""
    }