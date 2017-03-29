package dal

import model._
import sqlest._
import dal.table._
/**
  * Created by finnk on 26/03/2017.
  */
object PlayerExtractor {

  lazy val playerExtractor = extract[Player](
    id = PlayerTable.id,
    name = PlayerTable.name,
    username = PlayerTable.username,
    email = PlayerTable.email_address

  )
}