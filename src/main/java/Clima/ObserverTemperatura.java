package Clima;

import java.time.LocalDateTime;

public interface ObserverTemperatura {
    void actualizar(String temperatura, LocalDateTime fechaHora);
}
