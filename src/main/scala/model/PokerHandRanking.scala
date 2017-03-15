package model


sealed trait PokerHandRanking extends Ordered[PokerHandRanking]{
  def score: Int
  def compare(that: PokerHandRanking) = {

    this.score compare that.score
  }
}


case class HighCard(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking{
  def score = 1
  override def compare(that: PokerHandRanking) = {

    that match {
      case x: HighCard => (r1,r2,r3,r4,r5) compare (x.r1, x.r2, x.r3, x.r4, x.r5)
      case _ => super.compare(that)
    }
  }
}

case class Pair(pair: Rank, r1: Rank, r2: Rank, r3: Rank) extends PokerHandRanking{
  def score = 2
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: Pair => (pair, r1, r2, r3) compare(x.pair, x.r1, x.r2, x.r3)
      case _ => super.compare(that)
    }
  }
}

case class TwoPair(highPair: Rank, lowPair: Rank, r1: Rank) extends PokerHandRanking{
  def score = 3
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: TwoPair => (highPair, lowPair, r1) compare(x.highPair, x.lowPair, x.r1)
      case _ => super.compare(that)
    }
  }
}
case class ThreeOfAKind(triple: Rank, r1: Rank, r2: Rank) extends PokerHandRanking{
  def score = 4
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: ThreeOfAKind => (triple, r1, r2) compare(x.triple, x.r1, x.r2)
      case _ => super.compare(that)
    }
  }
}
case class Straight(highCard: Rank) extends PokerHandRanking{
  def score = 5
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: Straight => highCard compare x.highCard
      case _ => super.compare(that)
    }
  }
}
case class Flush(r1: Rank, r2: Rank, r3: Rank, r4: Rank, r5: Rank) extends PokerHandRanking{
  def score = 6
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: Flush => (r1, r2, r3, r4, r5) compare(x.r1, x.r2, x.r3, x.r4, x.r5)
      case _ => super.compare(that)
    }
  }
}
case class FullHouse(triple: Rank, pair: Rank) extends PokerHandRanking{
  def score = 7
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: FullHouse => (triple, pair) compare(x.triple, x.pair)
      case _ => super.compare(that)
    }
  }
}
case class FourOfAKind(quad: Rank, r1: Rank) extends PokerHandRanking{
  def score = 8
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: FourOfAKind => (quad, r1) compare(x.quad, x.r1)
      case _ => super.compare(that)
    }
  }
}
case class StraightFlush(highCard: Rank) extends PokerHandRanking{
  def score = 9
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: StraightFlush => highCard compare x.highCard
      case _ => super.compare(that)
    }
  }
}

case class RoyalFlush() extends PokerHandRanking{
  def score = 10
  override def compare(that: PokerHandRanking) = {
    that match {
      case x: RoyalFlush => 0
      case _ => super.compare(that)
    }
  }
}



