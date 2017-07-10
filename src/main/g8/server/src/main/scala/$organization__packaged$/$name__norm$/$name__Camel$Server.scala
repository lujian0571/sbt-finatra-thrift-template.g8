package $organization;format="word,normalize"$.$name;format="word,normalize"$

import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.finatra.thrift.filters._

object $name;format="Camel"$ServerMain extends $name;format="Camel"$Server

class $name;format="Camel"$Server extends ThriftServer {
  override val name = "example-server"

  override def configureThrift(router: ThriftRouter) {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .filter[ExceptionTranslationFilter]
      .add[PingController]
  }
}
