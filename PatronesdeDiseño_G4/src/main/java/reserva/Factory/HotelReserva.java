package reserva.Factory;

class HotelReserva implements ServicioReserva {
    public void reservar() {
        System.out.println("Reserva de hotel realizada.");
    }

    @Override
    public double getCosto() {
        return 150;
    }

    public String getDescripcion() {
        return "Hotel";
    }

}