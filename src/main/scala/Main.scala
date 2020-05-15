import akka.http.scaladsl.server.Route
import scala.concurrent.ExecutionContext.Implicits.global
import sttp.tapir.swagger.akkahttp.SwaggerAkka
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import scala.concurrent.Await
import scala.concurrent.duration._
import com.softwaremill.macwire._

object Main extends App {
  val service = wire[Service]
  val controller = wire[Controller]

  def startServer(route: Route, yaml: String): Unit = {
    val routes = route ~ new SwaggerAkka(yaml).routes
    implicit val actorSystem: ActorSystem = ActorSystem()
    Await.result(Http().bindAndHandle(routes, "localhost", 8080), 1.minute)
  }

  startServer(controller.routes, controller.docs)
}