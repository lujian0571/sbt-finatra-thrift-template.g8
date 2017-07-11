package $organization;format="normalize"$.$name;format="normalize"$

import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import com.twitter.finatra.thrift.filters._
import com.twitter.finatra.thrift.modules.ClientIdWhitelistModule
import $organization;format="normalize"$.$name;format="normalize"$.controllers.$name;format="Camel"$Controller
import $organization;format="normalize"$.$name;format="normalize"$.filters.ExceptionTranslationFilter
import $organization;format="normalize"$.$name;format="normalize"$.modules.ServicesModule

object $name;format="Camel"$ServerMain extends $name;format="Camel"$Server

class $name;format="Camel"$Server extends ThriftServer {
  override val name = "$name;format="normalize"$-server"

  override val modules = Seq(
    ClientIdWhitelistModule,
    ServicesModule
  )

  override def configureThrift(router: ThriftRouter) {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[StatsFilter]
      .filter[ExceptionTranslationFilter]
      .filter[ClientIdWhitelistFilter]
      .add[$name;format="Camel"$Controller]
  }
}
