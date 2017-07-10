package $organization;format="normalize"$.$name;format="normalize"$.controllers

import $organization;format="normalize"$.$name;format="normalize"$.thriftscala.$name;format="Camel"$Service
import $organization;format="normalize"$.$name;format="normalize"$.thriftscala.$name;format="Camel"$Service.Ping
import com.twitter.finatra.thrift.Controller
import com.twitter.util.Future
import javax.inject.Singleton

@Singleton
class $name;format="Camel"$Controller
  extends Controller
  with $name;format="Camel"$Service.BaseServiceIface {

  	override val ping = handle(Ping) { args: Ping.Args =>
  		info(s"Responding to ping thrift call")
  		Future.value("pong")
  	}
}
