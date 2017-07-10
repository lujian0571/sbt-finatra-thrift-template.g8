package $organization;format="normalize"$.$name;format="normalize"$

import com.google.inject.Stage
import com.twitter.finatra.thrift.EmbeddedThriftServer
import com.twitter.inject.server.FeatureTest

class $name;format="Camel"$ServerStartupTest extends FeatureTest {

  val server = new EmbeddedThriftServer(
    twitterServer = new $name;format="Camel"$Server,
    stage = Stage.PRODUCTION)

  test("server#startup") {
    server.assertHealthy()
  }
}
