import java.text.SimpleDateFormat

def call(app_name) {
    //currentBuild.displayName = new SimpleDateFormat("yy.MM.dd").format(new Date()) + "-" + env.BUILD_NUMBER
    //currentBuild.displayName = new Date().format("yyyyMMdd'T'HHmm")+ "-" + env.BUILD_NUMBER
    echo "Hey ${app_name}, Testing Demo"
    currentBuild.displayName = ${app_name}+ "-" + env.BUILD_NUMBER
}