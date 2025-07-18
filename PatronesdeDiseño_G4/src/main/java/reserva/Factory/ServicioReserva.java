package reserva.Factory;


// Factory Method: Crear instancias de servicios
public interface ServicioReserva {
    String getDescripcion();
    void reservar();
    double getCosto();
}
