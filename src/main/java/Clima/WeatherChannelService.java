package Clima;

import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherChannelService implements ClimaOnline {

    private static final String URL_TEMPLATE =
            "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&units=metric&APPID=%s";

    private final String apiKey;
    private final String ciudad;
    private final String pais;
    private final HttpClient http;

    public WeatherChannelService(String apiKey, String ciudad, String pais) {
        this.apiKey = apiKey;
        this.ciudad = ciudad;
        this.pais = pais;
        this.http = HttpClient.newHttpClient();
    }

    @Override
    public String temperatura() {
        String url = URL_TEMPLATE.formatted(ciudad, pais, apiKey);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    http.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException(
                        "OpenWeatherMap respondió con código: " + response.statusCode());
            }

            JSONObject json = new JSONObject(response.body());
            double temp = json.getJSONObject("main").getDouble("temp");

            return String.format("%.1f c", temp);

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al consultar temperatura", e);
        }
    }
}
