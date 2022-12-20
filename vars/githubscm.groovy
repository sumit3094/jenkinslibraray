//https://github.com/aleksei-bulgak/jenkins-shared-library-example/blob/master/src/by/bulgak/jenkins/lib/Checkout.groovy

def checkoutIfExists(String repository, String branch) {
//def checkoutIfExists(String repository, String branches, def credentials = ['token': 'abc-token', 'usernamePassword': 'abc']) {
   // assert credentials['token']
    //assert credentials['usernamePassword']
  //  def sourceAuthor = author
    def sourceRepository = getForkedProjectName(defaultAuthor, repository, sourceAuthor, credentials['token']) ?: repository
    // Checks source group and branch (for cases where the branch has been created in the author's forked project)
    def repositoryScm = getRepositoryScm(sourceRepository, author, branches, credentials['usernamePassword'])
    if (repositoryScm == null) {
        // Checks target group and and source branch (for cases where the branch has been created in the target project itself
        repositoryScm = getRepositoryScm(repository, defaultAuthor, branches, credentials['usernamePassword'])
        sourceAuthor = repositoryScm ? defaultAuthor : author
    }
    if (repositoryScm != null && (!mergeTarget || hasPullRequest(defaultAuthor, repository, author, branches, credentials['token']))) {
        if (mergeTarget) {
            mergeSourceIntoTarget(sourceRepository, sourceAuthor, branches, repository, defaultAuthor, defaultBranches, credentials['usernamePassword'])
        } else {
            checkout repositoryScm
        }
    } else {
        checkout(resolveRepository(repository, defaultAuthor, defaultBranches, false, credentials['usernamePassword']))
    }
}