package reserva.Buider;

import reserva.Factory.ServicioReserva;
import reserva.Strategy.MetodoPago;
import reserva.models.Reserva;

public class ReservaBuilder {
    private Reserva reserva = new Reserva();

    public ReservaBuilder agregarServicio(ServicioReserva servicio) {
        reserva.agregarServicio(servicio);
        return this;
    }

    public ReservaBuilder conMetodoPago(MetodoPago pago) {
        reserva.setMetodoPago(pago);
        return this;
    }

    public Reserva build() {
        return reserva;
    }
}
