name := "secp256k1jni"

version := "0.1.0"

scalaVersion := "2.13.1"

organization := "org.scash"

//autoScalaLibrary := false // exclude scala-library from dependencies
//crossPaths := false // drop off Scala suffix from artifact names.

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

libraryDependencies ++= List(
  "org.scodec" %% "scodec-bits" % "1.1.14" % "test",
  "dev.zio" %% "zio-test" % "1.0.0-RC18-1" % "test",
  "dev.zio" %% "zio-test-sbt" % "1.0.0-RC18-1" % "test",
  "org.scijava" % "native-lib-loader" % "2.3.4" withSources () withJavadoc ()
)
