package $organization;format="normalize"$.$name;format="normalize"$.modules

import com.twitter.inject.TwitterModule

object ServicesModule extends TwitterModule {

  override val modules = Seq(
    MemcachedClientModule,
    RedisClientModule,
    MysqlClientModule
  )

}
