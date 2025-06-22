package Clima;
;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private String temperatura;
    private final ClimaOnline clima;
    private final List<ObserverTemperatura> observadores = new ArrayList<>();

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public void agregarObservador(ObserverTemperatura obs) {
        this.observadores.add(obs);
    }

    public String leerTemperatura() {
        this.temperatura = this.clima.temperatura();
        LocalDateTime ahora = LocalDateTime.now();
        for (ObserverTemperatura obs : observadores) {
            obs.actualizar(this.temperatura, ahora);
        }
        return this.temperatura;
    }
}
