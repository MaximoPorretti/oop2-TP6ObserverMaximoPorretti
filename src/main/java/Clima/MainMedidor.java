package Clima;

public class MainMedidor {
    public static void main(String[] args) {
        String apiKey = "8a9570fc8297f70c365b4b93508818dc";
        String ciudad = "Viedma";
        String pais = "AR";

        ClimaOnline clima = new WeatherChannelService(apiKey, ciudad, pais);
        Medidor medidor = new Medidor(clima);


        medidor.agregarObservador(new LoggerTemperatura("log_temperaturas.txt"));
        medidor.agregarObservador(new CalefaccionAireObserver());


        medidor.leerTemperatura();
    }
}

