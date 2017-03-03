import model._

val d = Deck.newDeck.shuffle

val h = d.cards.take(5)

val hand = PokerHand(h.head, h(1), h(2), h(3), h(4))

hand.score

val testFlush1 = PokerHand(
  Card(Hearts, Two),
  Card(Hearts, Five),
  Card(Hearts, Seven),
  Card(Hearts, Four),
  Card(Hearts, King)
)

val testFlush2 = PokerHand(
  Card(Spades, Two),
  Card(Spades, Five),
  Card(Spades, Seven),
  Card(Spades, Four),
  Card(Spades, King)
)

testFlush1.equals(testFlush2)

testFlush1 == testFlush2
