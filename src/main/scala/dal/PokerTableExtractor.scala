package dal

import model._
import sqlest._
import dal.table._
/**
  * Created by finnk on 26/03/2017.
  */
object PokerTableExtractor {


  lazy val pokerTableExtractor = extract[PokerTable](
    id = PokerTableTable.id,
    name = PokerTableTable.name,
    unitOfWager = PokerTableTable.unitOfWager

  )
}