scalaVersion := "2.12.4"

resolvers += Resolver.bintrayRepo("beyondthelines", "maven")

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value,
  grpcmonix.generators.GrpcMonixGenerator() -> (sourceManaged in Compile).value
)

val scalapbVersion = scalapb.compiler.Version.scalapbVersion

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime"       % scalapbVersion % "protobuf",
  // for gRPC
  "io.grpc"                %  "grpc-netty"            % "1.8.0",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc"  % scalapbVersion,
  // for JSON conversion
  "com.thesamet.scalapb" %% "scalapb-json4s"        % "0.7.0",
  // for GRPC Monix
  "beyondthelines"         %% "grpcmonixruntime"      % "0.0.8"
)

scalacOptions in ThisBuild ++= Seq("-unchecked", "-deprecation")

