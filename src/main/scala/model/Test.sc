import model._

val d = Deck.newDeck.shuffle

val h = d.cards.take(5)

val hand = PokerHand(h.head, h(1), h(2), h(3), h(4))

hand.score





