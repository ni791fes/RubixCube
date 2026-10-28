val scala3Version = "3.10.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "RubixCube",
    version := "0.1.0-SNAPSHOT",
    coverageExcludedFiles := ".*Main;.*rotations",

    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.3.6" % Test,
      "org.scalactic" %% "scalactic" % "3.2.14",
      "org.scalatest" %% "scalatest" % "3.2.14" % Test
    )
  )
