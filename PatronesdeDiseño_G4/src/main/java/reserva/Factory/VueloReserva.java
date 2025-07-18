package reserva.Factory;


class VueloReserva implements ServicioReserva {
    public void reservar() {
        System.out.println("Reserva de vuelo realizada.");
    }

    @Override
    public double getCosto() {
        return 500;
    }

    public String getDescripcion() {
        return "Vuelo";
    }
}