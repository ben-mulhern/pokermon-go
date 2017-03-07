package model

/**
  * Created by ben on 05/03/2017.
  */
object PokerGame {

  def bestHand(
    hole1: Card,
    hole2: Card,
    flop1: Card,
    flop2: Card,
    flop3: Card,
    turn: Card,
    river: Card): PokerHand = {

    val cards = List(hole1, hole2, flop1, flop2, flop3, turn, river)

    val possibleHands = cards.combinations(5).map(
      x => PokerHand(x.head, x(1), x(2), x(3), x(4))
    )

    possibleHands.max

  }
}
