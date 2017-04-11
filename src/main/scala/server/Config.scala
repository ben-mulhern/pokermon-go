package server

import com.typesafe.config.ConfigFactory

object Config {
  private val conf = ConfigFactory.load
  val host = conf.getString("pokermongoserver.host")
  val port = conf.getInt("pokermongoserver.port")
  val url = conf.getString("pokermongodb.url")
  val user = conf.getString("pokermongodb.username")
  val password = conf.getString("pokermongodb.password")
}