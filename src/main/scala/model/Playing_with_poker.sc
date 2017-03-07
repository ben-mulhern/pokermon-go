import model._


def ShowCard(c: Card): Card = {
  c
}

val c1: Card = Card(Hearts,Eight)
val c2: Card = Card(Hearts,Nine)
val c3: Card = Card(Hearts,Ten)
val c4: Card = Card(Hearts,Jack)




//Return 1 if CardOne rank is better than CardTwo rank
//Return 0 otherwise
def IsWin(CardOne: Card, CardTwo: Card): Boolean = {
  CardOne.rank > CardTwo.rank
}

//Return 1 if CardOne rank is equal to CardTwo rank
//Return 0 otherwise
def IsDraw(CardOne: Card, CardTwo: Card): Boolean = {
  CardOne.rank == CardTwo.rank
}

//Players have two cards each. High Card wins
//1 if player one wins
//0 otherwise
def TwoCardsEachDoesPlayerOneWin(c11: Card,c12: Card,c21: Card,c22: Card) : Boolean = {
  (IsWin(c11,c21) && IsWin(c11,c22)) | (IsWin(c12,c21) && IsWin(c12,c22))
}

IsDraw(c1,c1)
IsDraw(c1,c2)
IsDraw(c2,c1)

IsWin(c1,c1)
IsWin(c1,c2)
IsWin(c2,c1)

TwoCardsEachDoesPlayerOneWin(c1,c2,c3,c4)
TwoCardsEachDoesPlayerOneWin(c1,c3,c2,c4)
TwoCardsEachDoesPlayerOneWin(c1,c4,c2,c3)

