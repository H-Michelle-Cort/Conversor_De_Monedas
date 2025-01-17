/*import java.util.Map;

public record Moneda(Map<String, Double> conversion_rates) {

    // Método: Obtener la tasa de conversión
    public Double obtenerTasaDeConversion(String moneda) {
        if (conversion_rates != null && conversion_rates.containsKey(moneda)) {
            return conversion_rates.get(moneda);
        } else {
            throw new RuntimeException("Error: Tasa de conversión no encontrada para la moneda: " + moneda);
        }
    }
}*/

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class Moneda {

    // Asegúrate de que el nombre del campo coincida con la respuesta de la API
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    // Método getter para el mapa de tasas de conversión
    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    // Método para obtener la tasa de conversión de una moneda específica
    public Double obtenerTasaDeConversion(String monedaDestino) {
        if (conversionRates != null && conversionRates.containsKey(monedaDestino)) {
            return conversionRates.get(monedaDestino);
        } else {
            throw new RuntimeException("Moneda destino no soportada: " + monedaDestino);
        }
    }
}






