package service

import com.typesafe.config.ConfigFactory

object Config {
//  private val conf = ConfigFactory.load
//  val host = conf.getString("pokerserver.host")
//  val port = conf.getInt("pokerserver.port")
//  val url = conf.getString("pokerdb.url")
//  val user = conf.getString("pokerdb.username")
//  val password = conf.getString("pokerdb.password")


  val url = "jdbc:h2:file:C:\\Users\\finnk\\Documents\\Development\\pokermon-go\\data\\pokermon-go;IFEXISTS=TRUE;FILE_LOCK=NO;SCHEMA=default"
  val user = "sa"
  val password = ""

}