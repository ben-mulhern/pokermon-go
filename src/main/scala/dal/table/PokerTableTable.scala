/*
package dal.table

import sqlest._

/**
  * Created by finnk on 22/03/2017.
  */
class PokerTableTable(alias: Option[String]) extends Table("poker_table", alias){

    val id   = column[Int]("poker_table_id")
    val name = column[String]("poker_table_name")
    val chipCurrencyExchangeRate = colmun[Int]("chip_currency_exchange_rate")
    val active = column[Boolean]("active")(BooleanYNColumnType)

}

object PokerTableTable extends PokerTableTable(None)
*/