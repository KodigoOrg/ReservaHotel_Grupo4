package reserva.models;


import reserva.Strategy.MetodoPago;

public class PagoTarjeta implements MetodoPago {
    public void pagar(double monto) {
        System.out.println("Pago con tarjeta: $" + monto);
    }
    public String getDescripcion() {
        return "pago tarjeta";
    }
}