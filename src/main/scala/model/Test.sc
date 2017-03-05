import model._

val d = Deck.newDeck.shuffle

val c = d.cards.take(7)

PokerGame.bestHand(c.head, c(1), c(2), c(3), c(4), c(5), c(6))




