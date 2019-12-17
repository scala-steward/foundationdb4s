import sbt._
import scala.collection.immutable.Seq

object Dependencies {
  lazy val allAkkaStreamsDependencies: Seq[ModuleID] = {
    val akkaVersion = "2.6.1"
    val akkaStreams = "com.typesafe.akka" %% "akka-stream" % akkaVersion
    val akkaStreamsTestKit = "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion

    val akkaStreamsDependencies = List(akkaStreams)
    val akkaStreamsTestDependencies = List(akkaStreamsTestKit).map(_ % Test)

    akkaStreamsDependencies ++ akkaStreamsTestDependencies
  }

  lazy val allCoreDependencies: Seq[ModuleID] = {
    val catsVersion = "2.0.0"
    val cats = "org.typelevel" %% "cats-core" % catsVersion
    val catsLaws = "org.typelevel" %% "cats-laws" % catsVersion

    val foundationDbVersion = "6.2.10"
    val foundationDb = "org.foundationdb" % "fdb-java" % foundationDbVersion

    val java8CompatVersion = "0.9.0"
    val java8Compat = "org.scala-lang.modules" %% "scala-java8-compat" % java8CompatVersion

    val mockitoVersion = "3.2.4"
    val mockito = "org.mockito" % "mockito-core" % mockitoVersion

    val scalaTestVersion = "3.1.0"
    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion

    val scalaTestPlusMockitoVersion = "1.0.0-M2"
    val scalaTestPlusMockito = "org.scalatestplus" %% "scalatestplus-mockito" % scalaTestPlusMockitoVersion

    val coreDependencies = List(cats, foundationDb, java8Compat)
    val coreTestDependencies =
      List(catsLaws, mockito, scalaTest, scalaTestPlusMockito).map(_ % Test)

    coreDependencies ++ coreTestDependencies
  }

  lazy val allSchemaDependencies: Seq[ModuleID] = {
    val shapelessVersion = "2.3.3"
    val shapeless = "com.chuusai" %% "shapeless" % shapelessVersion
    List(shapeless)
  }
}
