package model

/**
  * Created by finnk on 26/03/2017.
  */
case class PokerTable(
  id: Int, 
  name: String, 
  chipCurrencyExchangeRate: String,
  players: List[Player],
  rounds: List[Round]
)
