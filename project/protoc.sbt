addSbtPlugin("com.thesamet" % "sbt-protoc" % "0.99.17")

resolvers += Resolver.bintrayRepo("beyondthelines", "maven")

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "compilerplugin"          % "0.7.4",
  "beyondthelines"         %% "grpcmonixgenerator"      % "0.0.8"
)

