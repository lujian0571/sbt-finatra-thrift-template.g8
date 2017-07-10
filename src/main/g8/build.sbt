import sbt.Keys._

parallelExecution in ThisBuild := false

lazy val versions = new {
  val finatra = "2.11.0"
  val guice = "4.0"
  val logback = "1.2.3"
  val mockito = "2.7.22"
  val scalatest = "3.0.3"
  val scalacheck = "1.13.5"
  val specs2 = "3.8.9"
}

lazy val baseSettings = Seq(
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.12.2",
  ivyScala := ivyScala.value.map(_.copy(overrideScalaVersion = true)),
  libraryDependencies ++= Seq(
    "org.mockito" % "mockito-core" % versions.mockito % "test",
    "org.scalacheck" %% "scalacheck" % versions.scalacheck % "test",
    "org.scalatest" %% "scalatest" % versions.scalatest % "test",
    "org.specs2" %% "specs2-mock" % versions.specs2 % "test"
  ),
  resolvers ++= Seq(
    Resolver.mavenLocal,
    "Aliyun Maven" at "http://maven.aliyun.com/nexus/content/groups/public/",
    "Maven Center" at "http://repo1.maven.org/maven2/",
    Resolver.sonatypeRepo("releases")
  ),
  fork in run := true,
  assemblyMergeStrategy in assembly := {
    case "BUILD" => MergeStrategy.discard
    case "META-INF/io.netty.versions.properties" => MergeStrategy.last
    case other => MergeStrategy.defaultMergeStrategy(other)
  }
)

lazy val root = (project in file(".")).
  settings(
    name := "$name;format="normalize"$",
    organization := "$organization;format="normalize"$",
    moduleName := "$name;format="normalize"$",
    run := {
      (run in `server` in Compile).evaluated
    }
  ).
  aggregate(server)

lazy val server = (project in file("server")).
  settings(baseSettings).
  settings(
    name := "$name;format="normalize"$-server",
    moduleName := "$name;format="normalize"$-server",
    mainClass in (Compile, run) := Some("$organization;format="normalize"$.$name;format="normalize"$.$name;format="Camel"$ServerMain"),
    javaOptions ++= Seq(
      "-Dlog.service.output=/dev/stderr",
      "-Dlog.access.output=/dev/stderr"),
    libraryDependencies ++= Seq(
      "com.twitter" %% "finatra-thrift" % versions.finatra,
      "ch.qos.logback" % "logback-classic" % versions.logback,

      "com.twitter" %% "finatra-thrift" % versions.finatra % "test",
      "com.twitter" %% "inject-app" % versions.finatra % "test",
      "com.twitter" %% "inject-core" % versions.finatra % "test",
      "com.twitter" %% "inject-modules" % versions.finatra % "test",
      "com.twitter" %% "inject-server" % versions.finatra % "test",
      "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

      "com.twitter" %% "finatra-thrift" % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-app" % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-core" % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-server" % versions.finatra % "test" classifier "tests"
    )
  ).
  dependsOn(idl)

lazy val idl = (project in file("idl")).
  settings(baseSettings).
  settings(
    name := "$name;format="normalize"$-idl",
    moduleName := "$name;format="normalize"$-idl",
    scroogeThriftDependencies in Compile := Seq(
      "finatra-thrift_2.12"
    ),
    libraryDependencies ++= Seq(
      "com.twitter" %% "finatra-thrift" % versions.finatra
    )
  )
