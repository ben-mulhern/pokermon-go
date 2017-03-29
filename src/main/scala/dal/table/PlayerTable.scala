package dal.table

import sqlest._

/**
  * Created by finnk on 26/03/2017.
  */
class PlayerTable(alias: Option[String]) extends Table("player", alias){

  val id   = column[Option[Int]]("player_id")
  val name = column[String]("player_name")
  val username  = column[String]("username")
  val email_address = column[String]("email_address")

}

object PlayerTable extends PlayerTable(None)