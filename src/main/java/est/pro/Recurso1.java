package est.pro;

import io.prometheus.client.Counter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/recurso1")
public class Recurso1 {

    private static final Counter peticiones = Counter.build()
            .labelNames("metodo", "path")
            .name("ejecuciones_total")
            .help("Número de ejecuciones")
            .register();

    //Counter.build().name("requests_total").help("Total requests.").register();



    @GET
    @Path("/hola/")
    @Produces(MediaType.TEXT_PLAIN)
    public String saludar() {
        peticiones.labels("GET", "/recurso1/hola").inc();

        return "hola cara cola";
    }//saludar


    @GET
    @Path("/adios/")
    @Produces(MediaType.TEXT_PLAIN)
    public String despedir() {
        peticiones.labels("GET", "/recurso1/adios").inc();

        return "adios cara cola";
    }//despedir

}//recurso