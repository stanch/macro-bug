name := "macro-bug"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3-RC1"

resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots")
)

addCompilerPlugin("org.scala-lang.plugins" % "macro-paradise" % "2.0.0-SNAPSHOT" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)