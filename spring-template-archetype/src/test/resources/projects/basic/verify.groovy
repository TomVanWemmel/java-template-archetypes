import java.io.File

// Verify that the project was generated correctly
assert new File(basedir, "project/test-project").exists()
assert new File(basedir, "project/test-project/pom.xml").exists()
assert new File(basedir, "project/test-project/test-project-app").exists()
assert new File(basedir, "project/test-project/test-project-web").exists()
assert new File(basedir, "project/test-project/test-project-service").exists()
assert new File(basedir, "project/test-project/test-project-persistence").exists()

// Verify that the pom.xml files were generated correctly
assert new File(basedir, "project/test-project/test-project-app/pom.xml").exists()
assert new File(basedir, "project/test-project/test-project-web/pom.xml").exists()
assert new File(basedir, "project/test-project/test-project-service/pom.xml").exists()
assert new File(basedir, "project/test-project/test-project-persistence/pom.xml").exists()

// Verify that the project builds correctly
def buildLog = new File(basedir, "project/test-project/build.log").text
assert buildLog.contains("BUILD SUCCESS")

return true