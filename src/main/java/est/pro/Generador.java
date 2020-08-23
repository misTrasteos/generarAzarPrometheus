package est.pro;

import io.prometheus.client.Counter;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Generador {

    private static final Counter contador = Counter.build().name("contador_total").help("Nº de ejecuciones.").register();

    @Scheduled(every="10s")
    void generarMetrica() {
        System.out.println("Voy a generar una métrica pardiéz");

        contador.inc();
    }//

}//clase
