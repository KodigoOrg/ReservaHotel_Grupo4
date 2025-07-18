package reserva.Observer;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
    private final List<Observer> observadores = new ArrayList<>();

    public void agregar(Observer o) {
        observadores.add(o);
    }

    public void notificar(String mensaje) {
        for (Observer o : observadores) {
            o.actualizar(mensaje);
        }
    }
}