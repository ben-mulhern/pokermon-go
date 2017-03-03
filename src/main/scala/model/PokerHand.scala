package model

/**
  * Created by mulhernb on 02/03/17.
  */
case class PokerHand (c1: Card, c2: Card, c3: Card, c4: Card, c5: Card) {

  private val h = List(c1, c2, c3, c4, c5).sortBy(_.rank.value).reverse

  if (h.distinct.size != 5) throw new Exception("Hand has duplicates!")

  private val orderedRanks: List[Rank] = h.map(_.rank)

  private val flush: Boolean = h.map(_.suit).distinct.size == 1

  private val aceLowStraight: Boolean = orderedRanks match {
    case List(Ace, Five, Four, Three, Two) => true
    case _ => false
  }

  private val straight: Boolean =
    aceLowStraight ||
      (orderedRanks.distinct.size == 5 &&
      orderedRanks(4).value - orderedRanks.head.value == 4)

  lazy val commonValues: List[(Int, Rank)] = orderedRanks.groupBy(x => x).mapValues(_.size).toList.map(x => (x._2, x._1)).sortBy(x => (x._1, x._2.value)).reverse

  lazy val score: PokerHandRanking = {

    // Royal flush
    if (flush && straight && !aceLowStraight && orderedRanks.head == Ace) RoyalFlush
    // Straight flush
    else if (flush && aceLowStraight) StraightFlush(Five)
    else if (flush && straight) StraightFlush(h.head.rank)
    // Four of a kind
    else if (commonValues.head._1 == 4)
      FourOfAKind(commonValues.head._2, commonValues(1)._2)
    // Full house
    else if (commonValues.head._1 == 3 && commonValues(1)._1 == 2)
      FullHouse(commonValues.head._2, commonValues(1)._2)
    // Flush
    else if (flush)
      Flush(h.head.rank, h(1).rank, h(2).rank, h(3).rank, h(4).rank)
    // Straight
    else if (aceLowStraight) Straight(Five)
    else if (straight) Straight(h.head.rank)
    // Three of a kind
    else if (commonValues.head._1 == 3)
      ThreeOfAKind(commonValues.head._2, commonValues(1)._2, commonValues(2)._2)
    // Two pair
    else if (commonValues.head._1 == 2 && commonValues(1)._1 == 2)
      TwoPair(commonValues.head._2, commonValues(1)._2, commonValues(2)._2)
    // Pair
    else if (commonValues.head._1 == 2)
      Pair(commonValues.head._2, commonValues(1)._2, commonValues(2)._2, commonValues(3)._2)
    // High card
    else HighCard(h.head.rank, h(1).rank, h(2).rank, h(3).rank, h(4).rank)

  }

}
