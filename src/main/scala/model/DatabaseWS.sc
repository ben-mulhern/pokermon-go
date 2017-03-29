//import dal.PokerTableDal
import dal._
import model._

val pt = new PokerTableDal {}

val table = pt.getPokerTable(1)

//pt.createPokerTable("Test", "Chips")

val p = new PlayerDal {}

val player = p.getPlayer(1)

//val player = Player(None, "Karl", "Karl", "test.test@test.test")

//p.createPlayer(player)


//pt.joinTable(table.get, player.get)