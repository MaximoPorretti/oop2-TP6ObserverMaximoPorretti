package Clima;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerTemperatura implements ObserverTemperatura {

    private final String ruta;

    public LoggerTemperatura(String rutaArchivo) {
        this.ruta = rutaArchivo;
    }

    @Override
    public void actualizar(String temperatura, LocalDateTime fechaHora) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta, true))) {
            pw.println(fechaHora + " - " + temperatura);
        } catch (IOException e) {
            System.err.println("Error escribiendo log: " + e.getMessage());
        }
    }
}
