def call(Map config) { 

    def buildId = "${config.imageVersion}-${timeStamp}"
        sh """
        docker build -t "${config.imageName}:${buildId}" docker/
        """

}
