package reserva.Adapter;
import reserva.Factory.ServicioReserva;

public class ServicioExternoAdapter implements ServicioReserva {
    private final ServicioExternoExterno servicioExterno;

    public ServicioExternoAdapter(ServicioExternoExterno servicioExterno) {
        this.servicioExterno = servicioExterno;
    }

    @Override
    public void reservar() {
        servicioExterno.reservarServicio();
    }

    @Override
    public double getCosto() {
        return servicioExterno.obtenerPrecio();
    }

    @Override
    public String getDescripcion() {
        return servicioExterno.obtenerNombre();
    }
}

// Clase externa (simulada)
class ServicioExternoExterno {
    public void reservarServicio() {
        System.out.println("Reserva realizada desde sistema externo.");
    }

    public double obtenerPrecio() {
        return 120.0;
    }

    public String obtenerNombre() {
        return "Servicio Externo Adaptado";
    }
}