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

case class PokerGame(players: List[Player]) {

  val s = PokerGameState.newGame(players)
  val s1 = s.revealFlop
  println(s"The flop is ${s1.flop}")
  val s2 = s1.revealTurn
  println(s"The turn is ${s2.turn.get}")
  val s3 = s2.revealRiver
  println(s"The river is ${s3.river.get}")

  val h = s3.hands.map(ph => (ph.player, PokerGame.bestHand(ph.hole1, ph.hole2, s3.flop.head, s3.flop(1), s3.flop(2), s3.turn.get, s3.river.get)))
  println("The player's best hands are:")
  h.foreach(x => println(s"${x._1.name} - ${x._2.score}"))

}

case class PlayerPokerHand(player: Player, hole1: Card, hole2: Card)
case class PokerGameState(hands: List[PlayerPokerHand], flop: List[Card], turn: Option[Card], river: Option[Card], deck: Deck) {

  def revealFlop: PokerGameState = {
    if (flop.nonEmpty) throw new Exception("Flop already revealed")
    val (f, d) = deck.dealCards(3)
    PokerGameState(hands, f, None, None, d)
  }

  def revealTurn: PokerGameState = {
    if (turn.nonEmpty) throw new Exception("Turn already revealed")
    if (flop.isEmpty) throw new Exception("Flop not revealed yet")
    val (t, d) = deck.nextCard
    PokerGameState(hands, flop, Some(t), None, d)
  }

  def revealRiver: PokerGameState = {
    if (river.nonEmpty) throw new Exception("River already revealed")
    if (turn.isEmpty) throw new Exception("Turn not revealed yet")
    val (r, d) = deck.nextCard
    PokerGameState(hands, flop, turn, Some(r), d)
  }
}

object PokerGameState {

  def newGame(players: List[Player]): PokerGameState = {
    val d = Deck.newDeck().shuffle
    val p = players.size
    val (holeCards, d2) = d.dealCards((p * 2))
    val hands = (0 until p).map(i => PlayerPokerHand(players(i), holeCards(i), holeCards(p + i))).toList
    PokerGameState(hands, Nil, None, None, d2)
  }

}

