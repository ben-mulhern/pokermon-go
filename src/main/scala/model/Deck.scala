package model

/**
  * Created by finnk on 29/03/2017.
  */
case class Deck(cards: List[Card]) {
  def shuffle: Deck = Deck(util.Random.shuffle(cards))
  lazy val size: Int = cards.size
  lazy val nextCard: (Card, Deck) = (cards.head, Deck(cards.tail))

  private def internalDeal(noOfPlayers: Int, noOfCards: Int, hands: List[List[Card]]): (List[List[Card]], Deck)= {

    if (noOfCards == 0){
      (hands, this)
    }
    else {

      val (dealt, remainder) = this.cards.splitAt(noOfPlayers)

      val x = hands.zip(dealt).map(x => x._1 :+ x._2)

      Deck(remainder).internalDeal(noOfPlayers, noOfCards -1, x)
    }

  }

  def deal(noOfPlayers: Int, noOfCards: Int): (List[List[Card]], Deck)= {

    val players: List[List[Card]] =  List.fill(noOfPlayers)(Nil)

    internalDeal(noOfPlayers, noOfCards, players)
  }

}

object Deck {
  val allSuits: List[Suit] = List(Spades, Hearts, Diamonds, Clubs)
  val allRanks: List[Rank] = List(Two, Three, Four, Five, Six, Seven, Eight,
    Nine, Ten, Jack, Queen, King, Ace)

  def newDeck(packs: Int = 1): Deck = {
    val cards =
      for (s <- allSuits;
           r <- allRanks;
           p <- 1 to packs) yield Card(s, r)
    Deck(cards)
  }
}
