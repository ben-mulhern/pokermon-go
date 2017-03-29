import model._


val a = util.Random.nextInt()

util.Random.setSeed(a)


val d = Deck.newDeck()

val c = d.shuffle.cards.take(5)

Poker.group(c)

Poker.getHand(c)


util.Random.setSeed(a)


val e = Deck.newDeck()

val f = e.shuffle.cards.take(5)

