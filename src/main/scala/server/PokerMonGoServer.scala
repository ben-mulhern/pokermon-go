package server

import org.http4s.server.blaze.BlazeBuilder
import service.{PokerTableService}

object PokermonGoServer extends App {
  BlazeBuilder.bindHttp(Config.port, Config.host)
    .mountService(PokerTableService.pokerTableService)
    .run
    .awaitShutdown()
}