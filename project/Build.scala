import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "redis-test"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "org.projectlombok" % "lombok" % "0.11.8"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
