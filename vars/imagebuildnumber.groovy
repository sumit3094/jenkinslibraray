import java.text.SimpleDateFormat

def call() {
    currentBuild.displayName = ${app_name}-new Date().format("yyyyMMdd'T'HHmm") + "-" + env.BUILD_NUMBER
}