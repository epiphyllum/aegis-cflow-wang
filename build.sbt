name := "aegis-cflow-wang"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.reactivex.rxjava2" % "rxjava" % "2.0.3",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value
)

lazy val settings = net.virtualvoid.sbt.graph.Plugin.graphSettings
