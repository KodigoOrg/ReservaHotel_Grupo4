package reserva.Factory;


class AutoReserva implements ServicioReserva {
    public void reservar() {
        System.out.println("Reserva de auto realizada.");
    }

    @Override
    public double getCosto() {
        return 25;
    }

    public String getDescripcion() {
        return "Auto";
    }
}