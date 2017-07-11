package $organization;format="normalize"$.$name;format="normalize"$.modules

import com.google.inject.{Provides, Singleton}
import com.twitter.finagle.client.DefaultPool
import com.twitter.finagle.{Memcached, memcached}
import com.twitter.inject.TwitterModule
import com.twitter.conversions.time._

object MemcachedClientModule extends TwitterModule {

  private val serversFlag = flag("memcached.severs", "127.0.0.1:11211", "Default memcached ip:port")

  @Singleton
  @Provides
  def providesMemcachedClient(): memcached.Client = {
    Memcached.client
      .withLabel("memcached-$name;format="normalize"$")
      .configured(DefaultPool.Param(
        low = 0, high = 10,
        idleTime = 5.seconds,
        bufferSize = 0,
        maxWaiters = Int.MaxValue))
      .newRichClient(serversFlag())
  }

  //memcachedClient.set(k, 1, Time.fromSeconds(3600), Buf.Utf8.apply(k))
  //Buf.Utf8.unapply(buf)

}
