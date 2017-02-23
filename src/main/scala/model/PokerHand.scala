package model

/**
  * Created by mulhernb on 23/02/17.
  */
sealed trait PokerHandRanking

class HighCard(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking
class Pair(pair: Rank, r1: Rank, r2: Rank, r3: Rank) extends PokerHandRanking
class TwoPair(highPair: Rank, lowPair: Rank, r1: Rank) extends PokerHandRanking
class ThreeOfAKind(triple: Rank, r1: Rank, r2: Rank) extends PokerHandRanking
class Straight(highCard: Rank) extends PokerHandRanking
class Flush(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking
class FullHouse(triple: Rank, pair: Rank) extends PokerHandRanking
class FourOfAKind(quad: Rank, r1: Rank) extends PokerHandRanking
class StraightFlush(highCard: Rank) extends PokerHandRanking
class RoyalFlush extends PokerHandRanking

