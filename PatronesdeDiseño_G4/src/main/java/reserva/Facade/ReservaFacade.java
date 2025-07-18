package reserva.Facade;

import reserva.Adapter.*;
import  reserva.Decorator.*;
import reserva.Facade.ReservaFacade;
import reserva.Buider.ReservaBuilder;
import reserva.Factory.ServicioFactory;
import reserva.Factory.ServicioReserva;
import reserva.SingletonSistema.SistemaReservas;
import reserva.Strategy.MetodoPago;
import reserva.models.Reserva;

import java.util.List;

public class ReservaFacade {
    private SistemaReservas sistema = SistemaReservas.getInstancia();

    public void crearReserva(List<String> tiposServicios, MetodoPago metodoPago, boolean conSeguro) {
        ReservaBuilder builder = new ReservaBuilder();

        for (String tipo : tiposServicios) {
            ServicioReserva servicio = ServicioFactory.crearServicio(tipo);
            if (conSeguro) {
                servicio = new reserva.Decorator.SeguroDecorator(servicio, 15.0);
            }
            builder.agregarServicio(servicio);
        }

        builder.conMetodoPago(metodoPago);
        Reserva reserva = builder.build();
        sistema.agregarReserva(reserva);
    }

    public List<Reserva> obtenerReservas() {
        return sistema.getReservas();
    }

    public boolean cancelarReserva(int id) {
        return sistema.cancelarReservaPorId(id);
    }
}