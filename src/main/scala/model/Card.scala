package model

/**
  * Created by mulhernb on 23/02/17.
  */
case class Card(suit: Suit, rank: Rank) extends Ordered[Card] {
  override def toString = s"$rank of $suit"
  def compare(that: Card) = this.rank.compare(that.rank)
}

sealed trait Suit
case object Spades extends Suit
case object Hearts extends Suit
case object Diamonds extends Suit
case object Clubs extends Suit

sealed trait Rank extends Ordered[Rank] {
  def value: Int
  def compare(that: Rank) = this.value - that.value
}
case object Two extends Rank {val value = 2}
case object Three extends Rank {val value = 3}
case object Four extends Rank {val value = 4}
case object Five extends Rank {val value = 5}
case object Six extends Rank {val value = 6}
case object Seven extends Rank {val value = 7}
case object Eight extends Rank {val value = 8}
case object Nine extends Rank {val value = 9}
case object Ten extends Rank {val value = 10}
case object Jack extends Rank {val value = 11}
case object Queen extends Rank {val value = 12}
case object King extends Rank {val value = 13}
case object Ace extends Rank {val value = 14}

case class Deck(cards: List[Card]) {
  def shuffle: Deck = Deck(util.Random.shuffle(cards))
  lazy val size: Int = cards.size
  lazy val nextCard: (Card, Deck) = (cards.head, Deck(cards.tail))
}

object Deck {
  val allSuits: List[Suit] = List(Spades, Hearts, Diamonds, Clubs)
  val allRanks: List[Rank] = List(Two, Three, Four, Five, Six, Seven, Eight,
    Nine, Ten, Jack, Queen, King, Ace)
  def newDeck: Deck = {
    val cards =
      for (s <- allSuits;
           r <- allRanks) yield Card(s, r)
    Deck(cards)
  }
}
