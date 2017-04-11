package dal.table

import sqlest._

/**
  * Created by finnk on 26/03/2017.
  */
class PlayerTable(alias: Option[String]) extends Table("player", alias) {

  val id   = column[Int]("player_id")
  val name = column[String]("player_name")
  val username  = column[String]("username")
  val emailAddress = column[String]("email_address")
  val cashOnAccount = column[Double]("cash_on_account")
  val passwordSalt = column[String]("password_salt")
  val passwordHash = column[String]("password_hash")

}

object PlayerTable extends PlayerTable(None)