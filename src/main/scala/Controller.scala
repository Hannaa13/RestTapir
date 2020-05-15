import akka.http.scaladsl.server.Route
import sttp.tapir._
import sttp.tapir.json.circe._
import sttp.tapir.server.akkahttp._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import io.circe.generic.auto._
import sttp.tapir.docs.openapi._
import sttp.tapir.openapi.circe.yaml._

class Controller(service: Service) {
  val circleEndpoint: Endpoint[Double, String, Result, Nothing] =
    endpoint
      .errorOut(stringBody)
      .in("math")
      .get
      .in(query[Double]("area"))
      .out(anyJsonBody[Result])

  def routes: Route = {
    def areaLogic(area: Double) = Future {
      Right[String, Result](service.getArea(area))
    }

    circleEndpoint.toRoute(areaLogic)
  }

  val docs: String = circleEndpoint.toOpenAPI("Circle Area", "1.0").toYaml
}
