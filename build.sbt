name := "secp256k1jni"

version := "1.1.3"

lazy val scala212 = "2.12.10"
lazy val scala213 = "2.13.1"
lazy val supportedScala = List(scala212, scala213)

scalaVersion in ThisBuild := scala213

organization := "org.scash"
scmInfo := Some(
  ScmInfo(
    url("https://github.com/scala-cash/secp256k1jni"),
    "git@github.com:scala-cash/secp256k1jni.git"
  )
)
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

bintrayPackageLabels := Seq("bitcoin", "bitcoin cash", "p2p", "blockchain")
bintrayOrganization := Some("scala-cash")
bintrayRepository := "io"

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

libraryDependencies ++= List(
  "dev.zio" %% "zio-test" % "1.0.0-RC18-1" % "test",
  "dev.zio" %% "zio-test-sbt" % "1.0.0-RC18-1" % "test",
  "org.scijava" % "native-lib-loader" % "2.3.4"
)

crossScalaVersions := supportedScala

Compile / unmanagedResourceDirectories += baseDirectory.value / "natives"
