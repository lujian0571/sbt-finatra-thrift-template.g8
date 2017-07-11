package $organization;format="normalize"$.$name;format="normalize"$.modules

import com.google.inject.{Provides, Singleton}
import com.twitter.finagle.client.DefaultPool
import com.twitter.finagle.Mysql
import com.twitter.inject.TwitterModule
import com.twitter.conversions.time._

object MysqlClientModule extends TwitterModule {

  private val hostFlag = flag("jdbc.$name;format="normalize"$.host", "localhost:3306", "Default database($name;format="normalize"$) ip:port")
  private val usernameFlag = flag("jdbc.$name;format="normalize"$.username", "root", "Default database($name;format="normalize"$) username")
  private val passwordFlag = flag("jdbc.$name;format="normalize"$.password", "", "Default database($name;format="normalize"$) password")
  private val schemaFlag = flag("jdbc.$name;format="normalize"$.schema", "$name;format="normalize"$", "Default database($name;format="normalize"$) schema")

  @Singleton
  @Provides
  def providesMysqlClient(): com.twitter.finagle.mysql.Client = {
    Mysql.client
      .withLabel("database-$name;format="normalize"$")
      .withCredentials(usernameFlag(), passwordFlag())
      .withDatabase(schemaFlag())
      .configured(DefaultPool.Param(
        low = 0, high = 10,
        idleTime = 5.seconds,
        bufferSize = 0,
        maxWaiters = Int.MaxValue))
      .newRichClient(hostFlag())
  }

}
