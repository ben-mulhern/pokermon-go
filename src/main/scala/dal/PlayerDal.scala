package dal

import sqlest._
import sqlest.ast._

import model._
import dal.table.PlayerTable
import dal.PlayerExtractor._

trait PlayerDal extends SqlestDb{


  def getPlayer(id: Int): Option[Player] = {

    val query =
      select
        .from(PlayerTable)
        .where(PlayerTable.id === id)

    query.extractHeadOption(playerExtractor)

  }

  def createPlayer(player: Player): Int ={

    database.withTransaction { implicit transaction =>
      val x = insert
        .into(PlayerTable)
        .values(
          PlayerTable.name -> player.name,
          PlayerTable.username -> player.username,
          PlayerTable.email_address -> player.email
        ).executeReturningKeys[Int](transaction, IntColumnType)

      x.head
    }

  }
}