import sbt._
import sbt.Keys._

object ProgrammingLanguageGeneratorBuild extends Build {

  lazy val programmingLanguageGenerator = Project(
    id = "ProgrammingLanguageGenerator",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "ProgrammingLanguageGenerator",
      organization := "com.krrrr38.programming.language.generator",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
    )
  )
}
