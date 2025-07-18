package reserva.Factory;


public class ServicioFactory {
    public static ServicioReserva crearServicio(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "hotel" -> new HotelReserva();
            case "vuelo" -> new VueloReserva();
            case "auto" -> new AutoReserva();
            default -> throw new IllegalArgumentException("Tipo inválido");
        };
    }
}