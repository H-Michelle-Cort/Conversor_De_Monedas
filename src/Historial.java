import java.util.ArrayList;
import java.util.List;

public class Historial {

    private final List<String> historial;

    public Historial() {
        historial = new ArrayList<>();
    }

    public void agregarConversion(String conversion) {
        historial.add(conversion);
    }

    // Mostrar el historial de conversiones
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Sin conversiones registradas.");
        } else {
            System.out.println("Historial de conversiones:");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }

}
