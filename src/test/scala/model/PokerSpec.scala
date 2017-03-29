package model

import org.scalatest.FlatSpec

/**
  * Created by finnk on 14/03/2017.
  */
class PokerSpec extends FlatSpec {


  "A set of cards containing Ace to 10 of the same suit" should "equal a Royal Flush" in {

    val l = List(Card(Hearts, Ace),Card(Hearts, Ten),Card(Hearts, Jack),Card(Hearts, Queen),Card(Hearts, King))

    assert(Poker.getHand(l) == RoyalFlush())
  }

  "A set of cards containing Ace to 10 of different suits" should "equal an Ace High Straight" in {

    val l = List(Card(Hearts, Ace),Card(Hearts, Ten),Card(Diamonds, Jack),Card(Hearts, Queen),Card(Hearts, King))

    assert(Poker.getHand(l) == Straight(Ace))

  }

  "A set of 4 cards " should "raise an error" in {

      val l = List(Card(Hearts, Ace),Card(Hearts, Ten),Card(Diamonds, Jack),Card(Hearts, Queen))


      assertThrows[Exception]{Poker.getHand(l)}

    }

  "A set of cards containing 5 to A of different suits" should "equal an Ace High Straight" in {

    val l = List(Card(Hearts, Five),Card(Hearts, Three),Card(Diamonds, Ace),Card(Hearts, Two),Card(Hearts, Four))

    assert(Poker.getHand(l) == Straight(Five))

  }

  "A set of cards containing 2 Fours" should "equal a Pair" in {

    val l = List(Card(Hearts, Four), Card(Hearts, Three),Card(Diamonds, Ace),Card(Hearts, Two),Card(Clubs, Four))

    assert(Poker.getHand(l) == Pair(Four, Ace, Three, Two))

  }

  "A set of cards containing 3 Eights" should "equal a Pair" in {

    val l = List(Card(Hearts, Eight), Card(Hearts, Three),Card(Diamonds, Eight),Card(Hearts, Two),Card(Clubs, Eight))

    assert(Poker.getHand(l) == ThreeOfAKind(Eight, Three, Two))

  }

  "A set of cards containing nothing" should "equal an high card" in {

    val l = List(Card(Hearts, Ace),Card(Hearts, Ten),Card(Diamonds, Two),Card(Hearts, Queen),Card(Hearts, King))

    assert(Poker.getHand(l) == HighCard(Ace, King, Queen, Ten, Two))

  }

  "A Full House" should "beat a flush"  in  {

    assert(FullHouse(Three, Two) > Flush(Ace, King, Queen, Ten, Two) )

  }

  "A Full House" should "lose to a Straightflush"  in  {

    assert(FullHouse(Three, Two) < StraightFlush(Queen) )

  }

  "Two pair" should "lose to a 4 of a kind"  in  {

    assert(TwoPair(Three, Two, King) < FourOfAKind(Queen, Ace) )

  }

  "Two pair Ace Three" should "beat Two Pair King Queen"  in  {

    assert(TwoPair(Ace, Three, Four) > TwoPair(King,Queen, Ace) )

  }

  "A Royal Flush" should "equal a royal flush"  in  {

    assert((RoyalFlush() compare RoyalFlush() ) == 0)


  }

  "Grouping a list of 2 cards" should "do something" in {

    val l = List(Card(Hearts, Ten),Card(Spades, Ten),Card(Diamonds, Two),Card(Hearts, Two),Card(Clubs, Two))

    assert(Poker.group(l) == List((3, Two),(2, Ten) ) )

  }

}
