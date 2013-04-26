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
    //"redis.clients" % "jedis" % "2.1.0",
    "redis.clients" % "jedis" % "1.5.1",
    "com.typesafe" %% "play-plugins-redis" % "2.0.4"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
