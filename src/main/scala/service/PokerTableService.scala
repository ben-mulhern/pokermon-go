package service

import model.PokerTable
import dal.PokerTableDal
import com.typesafe.scalalogging._
import org.http4s._
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.server.blaze._
import org.json4s._
import org.json4s.native.Serialization.read
import ServiceUtilities._

object PokerTableService extends LazyLogging {

  val pokerTableDal = new PokerTableDal {}

  val pokerTableService = HttpService {

    case req @ POST -> Root / "poker-table" =>
      req.decode[String] { data =>
        logger.info("Received request to create this poker table: " + data)
        val a: Artist = read[Artist](data)
        httpJsonResponse(artistDal.createArtist(a2))
      }

  }

}
