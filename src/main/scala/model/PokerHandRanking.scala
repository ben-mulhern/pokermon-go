package model

/**
  * Created by mulhernb on 23/02/17.
  */
sealed trait PokerHandRanking

case class HighCard(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking
case class Pair(pair: Rank, r1: Rank, r2: Rank, r3: Rank) extends PokerHandRanking
case class TwoPair(highPair: Rank, lowPair: Rank, r1: Rank) extends PokerHandRanking
case class ThreeOfAKind(triple: Rank, r1: Rank, r2: Rank) extends PokerHandRanking
case class Straight(highCard: Rank) extends PokerHandRanking
case class Flush(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking
case class FullHouse(triple: Rank, pair: Rank) extends PokerHandRanking
case class FourOfAKind(quad: Rank, r1: Rank) extends PokerHandRanking
case class StraightFlush(highCard: Rank) extends PokerHandRanking
object RoyalFlush extends PokerHandRanking

