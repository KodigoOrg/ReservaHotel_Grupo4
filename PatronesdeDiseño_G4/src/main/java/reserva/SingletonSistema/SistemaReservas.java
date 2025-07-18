package reserva.SingletonSistema;

import reserva.models.Reserva;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Singleton: Gestionar única instancia del sistema de reservas
public class SistemaReservas {
    private static SistemaReservas instancia;
    private List<Reserva> reservas = new ArrayList<>();

    private SistemaReservas() {}

    public static SistemaReservas getInstancia() {
        if (instancia == null) {
            instancia = new SistemaReservas();
        }
        return instancia;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public boolean cancelarReservaPorId(int id) {
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva r = iterator.next();
            if (r.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}