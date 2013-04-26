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
    "redis.clients" % "jedis" % "2.0.0" //2.0.0 -> JOhm dependency (johm fork by alilozano)
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
