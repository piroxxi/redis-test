# So well. What I've looked at :


### Play Redis Plugin
https://github.com/typesafehub/play-plugins/tree/master/redis
  This is a play plugin, bringing Jedis(The Java equivalent of 
  Sedis) and Sedis (The Scala equivalent of Jedis) to play in a 
  (quite) transparent way. 
  As far as I know, it's not supposed to managed object mapping
  except with serialization.

  Note: this one is available this way :
  "com.typesafe" %% "play-plugins-redis" % "2.0.4" (see project/Build.scala)
  This also requires to add a little configuration of this play
  plugin.


### Jedis
https://github.com/xetorthio/jedis
  So this is Jedis, a simple way to execute Redis traditional
  commands in directly in Java. Basicaly you can do SET and GET
  quite easily. But still no ORM.

  Note: this one is available this way :
  "redis.clients" % "jedis" % "2.1.0" (see project/Build.scala)

### JOhm
https://github.com/xetorthio/johm
  So here we start to talk real business, this is an ORM for redis.
  Version tested : 0.5.0 (https://github.com/downloads/xetorthio/johm/johm-0.5.0.jar)
  
  
# Want to see some code? 
It starts here :
https://github.com/piroxxi/redis-test/blob/master/app/controllers/Application.java

# Implementation with JOhm :
There is a branch for that :
https://github.com/piroxxi/redis-test/tree/with-JOhm
