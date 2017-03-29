package dal

import sqlest._
import sqlest.ast._

import model._
import dal.table._
import dal.PokerTableExtractor._

trait PokerTableDal extends SqlestDb{

  //TODO: Change results to validation response

  def getPokerTable(id: Int): Option[PokerTable] = {

    val query =
      select
        .from(PokerTableTable)
        .where(PokerTableTable.id === id)

    query.extractHeadOption(pokerTableExtractor)

  }

  def createPokerTable(name: String, unitOfWager: String): Int ={

    database.withTransaction { implicit transaction =>
      val x = insert
        .into(PokerTableTable)
        .values(
          Setter(PokerTableTable.name, name),
          Setter(PokerTableTable.unitOfWager, unitOfWager)
        ).executeReturningKeys[Int](transaction, IntColumnType)

      x.head
    }

  }

  def joinTable(table: PokerTable, player: Player): Int ={

    //TODO: need to check table,player exists and record does not exist

    insert
      .into(PokerTablePlayerTable)
      .values(
        Setter(PokerTablePlayerTable.pokerTableId, table.id),
        Setter(PokerTablePlayerTable.playerId, player.id.get)
      ).execute



  }


}

