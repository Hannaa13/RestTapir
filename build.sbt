name := "RestTapir"

version := "0.1"

scalaVersion := "2.13.2"

val akkaVersion = "2.6.3"
val akkaHttpVersion = "10.1.11"
val tapirVersion = "0.14.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "io.circe" %% "circe-parser" % "0.13.0-RC1",
  "io.circe" %% "circe-generic" % "0.13.0-RC1",
  "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided",
  "com.softwaremill.sttp.tapir" %% "tapir-core" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-akka-http-server" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-akka-http" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-redoc-akka-http" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-swagger-ui-http4s" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-redoc-http4s" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-openapi-docs" % tapirVersion,
  "com.softwaremill.sttp.tapir" %% "tapir-openapi-circe-yaml" % tapirVersion

)

