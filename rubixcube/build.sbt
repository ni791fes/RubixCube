val scala3Version = "3.10.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "RubixCube",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.3.6" % Test,
      "org.scalatest" %% "scalatest" % "3.2.20" % Test,
      "org.scalatestplus" %% "scalacheck-1-19" % "3.2.20.0" % Test
    )
  )

