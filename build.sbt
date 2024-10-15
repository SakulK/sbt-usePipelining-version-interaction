val scala3Version = "3.5.1"

logLevel := Level.Debug

ThisBuild / usePipelining := true

lazy val root = project
  .in(file("."))
  .settings(
    name := "sbt-usePipelining-version-interaction",
    version := "0.2.0-SNAPSHOT",
    scalaVersion := scala3Version,
  )
