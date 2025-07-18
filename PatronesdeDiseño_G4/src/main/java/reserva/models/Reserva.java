package reserva.models;

import reserva.Factory.ServicioReserva;
import reserva.Strategy.MetodoPago;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private ServicioReserva servicio;
    private MetodoPago metodoPago;
    private static int contadorID = 1;
    private int id;
    private List<ServicioReserva> servicios = new ArrayList<>();


    public Reserva() {
        this.id = contadorID++;
    }
    public int getId() {
        return id;
    }

    public void setServicio(ServicioReserva servicio) {
        this.servicio = servicio;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void agregarServicio(ServicioReserva servicio) {
        servicios.add(servicio);
    }

    public double getTotal() {
        return servicios.stream().mapToDouble(ServicioReserva::getCosto).sum();
    }

    public void procesar() {
        for (ServicioReserva s : servicios) {
            s.reservar();
        }
        metodoPago.pagar(getTotal());
    }

    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", Servicios: ");
        for (ServicioReserva s : servicios) {
            sb.append(s.getDescripcion()).append(" ($").append(s.getCosto()).append("), ");
        }
        sb.append("Pago: ").append(metodoPago.getDescripcion());
        sb.append(", Total: $").append(getTotal());
        return sb.toString();
    }

}
