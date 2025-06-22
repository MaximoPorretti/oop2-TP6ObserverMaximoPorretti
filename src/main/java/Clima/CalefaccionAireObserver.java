package Clima;
import java.time.LocalDateTime;

public class CalefaccionAireObserver implements ObserverTemperatura {

    @Override
    public void actualizar(String temperatura, LocalDateTime fechaHora) {
        try {
            double valor = Double.parseDouble(
                    temperatura.replace(" c", "").replace(",", "."));

            System.out.println(fechaHora + " - Temperatura actual: " + valor + "°C");

            if (valor < 12) {
                System.out.println("Hace frío, se encenderá la caldera.");
            } else if (valor > 17) {
                System.out.println("Hace calor, se encenderá el aire acondicionado.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Error al interpretar temperatura: " + temperatura);
        }
    }
}
