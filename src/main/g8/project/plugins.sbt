resolvers ++= Seq(
  Classpaths.sbtPluginSnapshots,
  Classpaths.sbtPluginReleases,
  Resolver.mavenLocal,
  "Aliyun Maven" at "http://maven.aliyun.com/nexus/content/groups/public/",
  Resolver.sonatypeRepo("snapshots")
)
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("com.twitter" % "scrooge-sbt-plugin" % "4.19.0")
