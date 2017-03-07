package model

/**
  * Created by mulhernb on 23/02/17.
  */
sealed trait PokerHandRanking extends Ordered[PokerHandRanking] {
  def value: (Int, Int, Int, Int, Int, Int)
  def compare(that: PokerHandRanking) = {
    lazy val t1 = this.value._1 - that.value._1
    lazy val t2 = this.value._2 - that.value._2
    lazy val t3 = this.value._3 - that.value._3
    lazy val t4 = this.value._4 - that.value._4
    lazy val t5 = this.value._5 - that.value._5
    lazy val t6 = this.value._6 - that.value._6

    if (t1 != 0) t1
    else if (t2 != 0) t2
    else if (t3 != 0) t3
    else if (t4 != 0) t4
    else if (t5 != 0) t5
    else if (t6 != 0) t6
    else 0
  }

  def equals(that: PokerHandRanking) = (this.compare(that) == 0)
}

case class HighCard(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking {
  val value = (1, r1.value, r2.value, r3.value, r4.value, r5.value)
}
case class Pair(pair: Rank, r1: Rank, r2: Rank, r3: Rank) extends PokerHandRanking{
  val value = (2, pair.value, r1.value, r2.value, r3.value, 0)
}
case class TwoPair(highPair: Rank, lowPair: Rank, r1: Rank) extends PokerHandRanking{
  val value = (3, highPair.value, lowPair.value, r1.value, 0, 0)
}
case class ThreeOfAKind(triple: Rank, r1: Rank, r2: Rank) extends PokerHandRanking{
  val value = (4, triple.value, r1.value, r2.value, 0, 0)
}
case class Straight(highCard: Rank) extends PokerHandRanking{
  val value = (5, highCard.value, 0, 0, 0, 0)
}
case class Flush(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking{
  val value = (6, r1.value, r2.value, r3.value, r4.value, r5.value)
}
case class FullHouse(triple: Rank, pair: Rank) extends PokerHandRanking{
  val value = (7, triple.value, pair.value, 0, 0, 0)
}
case class FourOfAKind(quad: Rank, r1: Rank) extends PokerHandRanking{
  val value = (8, quad.value, r1.value, 0, 0, 0)
}
case class StraightFlush(highCard: Rank) extends PokerHandRanking{
  val value = (9, highCard.value, 0, 0, 0, 0)
}
object RoyalFlush extends PokerHandRanking{
  val value = (10, 0, 0, 0, 0, 0)
}


