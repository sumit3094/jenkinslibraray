//def repoUrl = checkout(scm).GIT_URL
String determineRepoName() {
    return scm.getUserRemoteConfigs()[0].getUrl().tokenize('/')[3].split("\\.")[0]
}