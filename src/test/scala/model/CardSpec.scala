package model

import org.scalatest.FlatSpec

class CardSpec extends FlatSpec {

  "A new deck" should "have 52 cards" in {
    assert(Deck.newDeck().size == 52)
  }

  "A new deck" should "have 52 unique cards" in {
    assert(Deck.newDeck().cards.distinct.size == 52)
  }

  "A new 2 pack deck" should "have 52 cards" in {
    assert(Deck.newDeck(2).size == 104)
  }

  "A new 2 pack deck" should "have 52 unique cards" in {
    assert(Deck.newDeck(2).cards.distinct.size == 52)
  }


}