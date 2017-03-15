import model._

//
//util.Random.setSeed(56)
//

val d = Deck.newDeck

val c = d.shuffle.cards.take(5)

Poker.group(c)

Poker.getHand(c)
