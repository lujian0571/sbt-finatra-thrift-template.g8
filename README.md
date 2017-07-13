

## Usage

```sbt new lujian0571/sbt-finatra-thrift-template.g8```



## Dir 

```bash
$ sbt new lujian0571/sbt-finatra-thrift-template.g8
Creates a giter8 project template. 

name [myproject]: ping
organization [com.example]: com.example

Template applied in ./ping

$ tree ping
ping
├── README.md
├── build.sbt
├── idl
│   └── src
│       └── main
│           └── thrift
│               └── ping.thrift
├── project
│   ├── build.properties
│   └── plugins.sbt
└── server
    └── src
        ├── main
        │   ├── resources
        │   │   ├── client_whitelist.yml
        │   │   └── logback.xml
        │   └── scala
        │       └── com
        │           └── example
        │               └── ping
        │                   ├── PingServer.scala
        │                   ├── controllers
        │                   │   └── PingController.scala
        │                   ├── filters
        │                   │   └── ExceptionTranslationFilter.scala
        │                   └── modules
        │                       ├── MemcachedClientModule.scala
        │                       ├── MysqlClientModule.scala
        │                       ├── RedisClientModule.scala
        │                       └── ServicesModule.scala
        └── test
            ├── resources
            │   └── logback-test.xml
            └── scala
                └── com
                    └── example
                        └── ping
                            ├── PingServerFeatureTest.scala
                            └── PingServerStartupTest.scala
```
