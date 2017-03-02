package model

/**
  * Created by finnk on 02/03/2017.
  */
object Poker {

  def group(cards: List[Card]): List[(Int, Rank )] = {
    //cards.groupBy(_.rank).map{ case (value, items) => (items.length, value) }.toList.sorted.reverse
    cards.groupBy(_.rank).toList.map(a => (a._2.length, a._1)).sortBy(z => (z._1, z._2) ).reverse
  }

  def isFlush(cards: List[Card]): Boolean = {
    cards.groupBy(x => x.suit).size == 1
  }

  def getHand(cards: List[Card]): PokerHandRanking = {

    val flush = isFlush(cards)

    group(cards) match {

      case (1, Ace) :: (1, _) :: (1, _) :: (1, _) :: (1, Ten) :: Nil if flush => RoyalFlush()

      case (1, a) :: (1, _) :: (1, _) :: (1, _) :: (1, e) :: Nil if (a.value == e.value + 4) && flush => StraightFlush(a)
      case (1, Ace) :: (1, Five) :: (1, Four) :: (1, Three) :: (1, Two) :: Nil if flush => StraightFlush(Five)

      case (4, a) :: (1, b) :: Nil => FourOfAKind(a, b)

      case (3, a) :: (2, b) :: Nil => FullHouse(a, b)

      case (1, a) :: (1, b) :: (1, c) :: (1, d) :: (1, e) :: Nil if flush => Flush(a, b, c, d, e)

      case (1, a) :: (1, _) :: (1, _) :: (1, _) :: (1, e) :: Nil if a.value == e.value + 4 => Straight(a)
      case (1, Ace) :: (1, Five) :: (1, Four) :: (1, Three) :: (1, Two) :: Nil => Straight(Five)

      case (3, a) :: (1, b) :: (1, c) :: Nil => ThreeOfAKind(a, b, c)

      case (2, a) :: (2, b) :: (1, c) :: Nil => TwoPair(a, b, c)

      case (2, a) :: (1, b) :: (1, c) :: (1, d) :: Nil => Pair(a, b, c, d)

      case (1, a) :: (1, b) :: (1, c) :: (1, d) :: (1, e) :: Nil => HighCard(a, b, c, d, e)

      case _ => throw new Exception("Impossible hand")
    }

  }

}
