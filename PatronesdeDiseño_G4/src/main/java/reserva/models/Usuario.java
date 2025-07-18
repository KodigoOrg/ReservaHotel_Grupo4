package reserva.models;

import reserva.Observer.Observer;

//public class Usuario   {
//    private String nombre;
//
//    public Usuario(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//}

public class Usuario implements Observer {
    private final String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("[Notificación para " + nombre + "] " + mensaje);
    }
}