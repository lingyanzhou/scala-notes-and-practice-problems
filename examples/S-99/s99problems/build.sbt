name:="S99-problems"
organization:="lzhou.scala"
version:="0.0.1-SNAPSHOT"
scalaVersion:="2.11.8"


val scala_version = "2.11.8"
val scala_compat_version = "2.11"

libraryDependencies += "org.scala-lang" % "scala-library" % scala_version
libraryDependencies += "junit" % "junit" % "4.11" % "test"
libraryDependencies += "org.scalatest" % s"scalatest_${scala_compat_version}" % "3.0.1" % "test"
libraryDependencies += "org.scalamock" % s"scalamock-scalatest-support_${scala_compat_version}" % "3.5.0" % "test"
