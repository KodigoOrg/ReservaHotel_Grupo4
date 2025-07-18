package reserva.Command;

import reserva.Facade.ReservaFacade;
import reserva.Strategy.MetodoPago;

import java.util.List;

public class CrearReservaCommand implements Command {
    private final ReservaFacade facade;
    private final List<String> servicios;
    private final MetodoPago metodo;
    private final boolean conSeguro;

    public CrearReservaCommand(ReservaFacade facade, List<String> servicios, MetodoPago metodo, boolean conSeguro) {
        this.facade = facade;
        this.servicios = servicios;
        this.metodo = metodo;
        this.conSeguro = conSeguro;
    }

    @Override
    public void ejecutar() {
        facade.crearReserva(servicios, metodo, conSeguro);
    }

    @Override
    public void deshacer() {
        // Simplificado: cancela la última reserva
        int ultimoId = facade.obtenerReservas()
                .stream()
                .reduce((a, b) -> b)
                .map(r -> r.getId())
                .orElse(-1);
        facade.cancelarReserva(ultimoId);
    }
}