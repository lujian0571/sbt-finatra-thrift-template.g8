package $organization;format="normalize"$.$name;format="normalize"$

import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.finatra.thrift.filters._
import $organization;format="normalize"$.$name;format="normalize"$.controllers.$name;format="Camel"$Controller
import $organization;format="normalize"$.$name;format="normalize"$.filters.ExceptionTranslationFilter

object $name;format="Camel"$ServerMain extends $name;format="Camel"$Server

class $name;format="Camel"$Server extends ThriftServer {
  override val name = "$name;format="normalize"$-server"

  override def configureThrift(router: ThriftRouter) {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .filter[ExceptionTranslationFilter]
      .add[$name;format="Camel"$Controller]
  }
}
