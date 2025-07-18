package reserva;

import reserva.Command.CrearReservaCommand;
import reserva.Facade.ReservaFacade;
import reserva.Observer.Notificador;
import reserva.Strategy.MetodoPago;
import reserva.models.PagoTarjeta;
import reserva.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ReservaFacade facade = new ReservaFacade();
        Usuario usuario = new Usuario("admin");

        Notificador notificador = new Notificador();
        notificador.agregar(usuario);

        System.out.println("=== SISTEMA DE RESERVAS ===");

        boolean continuar = true;
        List<CrearReservaCommand> comandos = new ArrayList<>();

        while (continuar) {
            List<String> tiposSeleccionados = new ArrayList<>();

            for (String tipo : List.of("hotel", "vuelo", "auto")) {
                System.out.print("¿Desea agregar servicio de " + tipo + "? (si/no): ");
                if (sc.nextLine().equalsIgnoreCase("si")) {
                    tiposSeleccionados.add(tipo);
                }
            }

            if (tiposSeleccionados.isEmpty()) {
                System.out.println("No se agregaron servicios. Cancelando reserva.\n");
            } else {
                System.out.print("¿Desea seguro adicional? (si/no): ");
                boolean conSeguro = sc.nextLine().equalsIgnoreCase("si");

                System.out.print("Seleccione método de pago (tarjeta, paypal): ");
                String metodo = sc.nextLine();

                MetodoPago pago = new PagoTarjeta(); // Puedes agregar PayPal más adelante

                CrearReservaCommand comando = new CrearReservaCommand(facade, tiposSeleccionados, pago, conSeguro);
                comando.ejecutar();
                comandos.add(comando);

                notificador.notificar("Reserva creada exitosamente.");
                System.out.println("Reserva realizada correctamente.\n");
            }

            System.out.print("¿Desea realizar otra reserva? (si/no): ");
            continuar = sc.nextLine().equalsIgnoreCase("si");
        }

        // Mostrar todas las reservas
        System.out.println("\n=== RESERVAS GUARDADAS ===");
        facade.obtenerReservas().forEach(r -> System.out.println("- " + r.getResumen()));

        // Deshacer última reserva
        if (!comandos.isEmpty()) {
            System.out.print("\n¿Desea eliminar la última reserva? (si/no): ");
            if (sc.nextLine().equalsIgnoreCase("si")) {
                comandos.get(comandos.size() - 1).deshacer();
                //comandos.getLast().deshacer();
                notificador.notificar("Última reserva eliminada.");
            }
        }

        // Cancelar por ID
        System.out.print("\n¿Desea cancelar una reserva? Ingrese el ID o 0 para salir: ");
        int idCancelar = Integer.parseInt(sc.nextLine());
        if (idCancelar > 0) {
            boolean cancelada = facade.cancelarReserva(idCancelar);
            if (cancelada) {
                notificador.notificar("Reserva cancelada correctamente.");
            } else {
                System.out.println("No se encontró una reserva con ese ID.");
            }

            System.out.println("\n=== RESERVAS ALMACENADAS USUARIO " + usuario.getNombre() + " ===");
            facade.obtenerReservas().forEach(r -> System.out.println("- " + r.getResumen()));
        }

        sc.close();
    }
}