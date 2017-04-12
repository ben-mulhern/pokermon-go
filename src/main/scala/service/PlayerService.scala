package service

import model.Player
import dal.PlayerDal
//import com.typesafe.scalalogging._
import org.http4s._
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.server.blaze._
import org.json4s._
import org.json4s.native.Serialization.read
import ServiceUtilities._

// object PlayerService extends LazyLogging {
object PlayerService {

  val playerDal = new PlayerDal {}

  val playerService = HttpService {

    case req @ POST -> Root / "player" =>
      req.decode[String] { data =>
        //logger.info("Received request to create player: " + data)
        val p: Player = read[Player](data)
        httpJsonResponse(playerDal.createPlayer(p))
      }

    case GET -> Root / "player" / playerId =>
      //logger.info(s"Received request for player $playerId")
      println(s"Received request for player $playerId")
      val p = playerDal.getPlayer(playerId.toInt)
      println(s"Retrieved player $p from database")
      httpJsonResponse(p)

  }

}
