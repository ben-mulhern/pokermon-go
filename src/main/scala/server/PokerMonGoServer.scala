package server

import org.http4s.server.blaze.BlazeBuilder
import service.{PlayerService}

object PokermonGoServer extends App {
  println("Starting web server")
  BlazeBuilder.bindHttp(Config.port, Config.host)
    .mountService(PlayerService.playerService)
    .run
    .awaitShutdown()
}