package reserva.Decorator;
import reserva.Factory.ServicioReserva;

public class SeguroDecorator implements ServicioReserva {
    private final ServicioReserva servicio;
    private final double costoSeguro;

    public SeguroDecorator(ServicioReserva servicio, double costoSeguro) {
        this.servicio = servicio;
        this.costoSeguro = costoSeguro;
    }

    @Override
    public void reservar() {
        servicio.reservar();
        System.out.println("Seguro agregado por $" + costoSeguro);
    }

    @Override
    public double getCosto() {
        return servicio.getCosto() + costoSeguro;
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " + Seguro";
    }
}