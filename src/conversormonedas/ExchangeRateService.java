package conversormonedas;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private static final String API_KEY = "7e82b7e4bfff9c25ef75768f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public ExchangeRateResponse obtenerTasasDeCambio(String base) {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL + base))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
            //System.out.println("Respuesta de la API: " + respuesta.body());
            // Usar Gson para convertir la respuesta JSON en un objeto ExchangeRateResponse
            Gson gson = new Gson();
            return gson.fromJson(respuesta.body(), ExchangeRateResponse.class);

        } catch (Exception e) {
            System.err.println("Error al obtener datos de la API: " + e.getMessage());
            return null;
        }
    }
}
