package dal.table

import sqlest._

/**
  * Created by finnk on 22/03/2017.
  */
class PokerTableTable(alias: Option[String]) extends Table("poker_table", alias){

    val id   = column[Int]("poker_table_id")
    val name = column[String]("poker_table_name")
    val unitOfWager   = column[String]("unit_of_wager")

}

object PokerTableTable extends PokerTableTable(None)
