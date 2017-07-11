package $organization;format="normalize"$.$name;format="normalize"$.modules

import com.google.inject.{Provides, Singleton}
import com.twitter.finagle.{Redis, redis}
import com.twitter.inject.TwitterModule

object RedisClientModule extends TwitterModule {

  private val serversFlag = flag("redis.servers", "127.0.0.1:6379", "Default redis host:port")

  @Singleton
  @Provides
  def providesRedisClient(): redis.Client = {
    Redis.client
      .withLabel("redis-$name;format="normalize"$")
      .newRichClient(serversFlag())
  }

  //      val sessionCacheKey = Buf.Utf8.apply(s"key")
  //      redisClient.lRange(sessionCacheKey, 0L, -1L).onSuccess(list => {
  //        //list.filter()
  //      })
}
