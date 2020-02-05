import sbt.Keys.publish

name := "secp256k1jni"

organization := "org.scash"

version := "0.0.1"

autoScalaLibrary := false // exclude scala-library from dependencies

crossPaths := false // drop off Scala suffix from artifact names.

//skip in publish := true

//sbt documents recommend setting scalaversion to a fixed value
//to avoid double publishing
//https://www.scala-sbt.org/1.x/docs/Cross-Build.html
crossScalaVersions := {
  List("2.12.7")
}

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scmInfo := Some(ScmInfo(url("https://github.com/scala-cash/secp256k1jni"), "git@github.com:scala-cash/secp256k1jni.git"))

ThisBuild / githubOwner := "scala-cash"
ThisBuild / githubRepository := "secp256k1jni"

ThisBuild / githubTokenSource := Some(TokenSource.GitConfig("github.token"))