package $organization;format="normalize"$.$name;format="normalize"$

import $organization;format="normalize"$.$name;format="normalize"$.ping.thriftscala.$name;format="Camel"$Service
import com.twitter.finatra.thrift.EmbeddedThriftServer
import com.twitter.inject.server.FeatureTest
import com.twitter.util.Future

class $name;format="Camel"$ServerFeatureTest extends FeatureTest {

  override val server = new EmbeddedThriftServer(new $name;format="Camel"$Server)

  val client = server.thriftClient[$name;format="Camel"$Service[Future]](clientId = "client123")

  test("service#respond to ping") {
    client.ping().value should be("pong")
  }
}
