import java.io.File

def fileNames = [
        "pom.xml",
        "test-project-app",
        "test-project-web",
        "test-project-service",
        "test-project-persistence",
        "test-project-app/pom.xml",
        "test-project-web/pom.xml",
        "test-project-service/pom.xml",
        "test-project-persistence/pom.xml"
]

fileNames.each { fileName ->
    def file = new File(context.projectDir, fileName);
    assert file.exists() : "File ${file} does not exist"
}

// Verify that the project builds correctly
def buildLog = new File(basedir, "project/test-project/build.log").text
assert buildLog.contains("BUILD SUCCESS")

return true