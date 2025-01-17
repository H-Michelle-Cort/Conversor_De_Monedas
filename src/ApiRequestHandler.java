import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequestHandler {

    //Método: Consulta de monedas
    public Moneda consultaMoneda(String codigoIso){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/c473581c5f5e722761ecd0f4/latest/" + codigoIso);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println("Respuesta de la API: " + response.body());
            return new Gson().fromJson(response.body(), Moneda.class);

        }catch (Exception e){
            throw new RuntimeException("Error: Conversión no admitida");
        }

    }

}