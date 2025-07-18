# 🧳 Sistema de Reservas en Línea - Patrones de Diseño

### 🧑‍💻 Autores
1-Mery Acevedo

2-Alejandro Ernesto Juarez Argumedo

3-Nestor Ivan Fabian Colocho


Sistema modular y extensible para realizar reservas de hoteles, vuelos y autos, implementando patrones de diseño creacionales, estructurales y de comportamiento en Java. 
Desarrollado como proyecto académico para demostrar el uso de patrones de diseño en Java.

### 🧩 Patrones de Diseño Implementados


| Tipo           | Patrones                    |
|----------------|-----------------------------|
| Creacionales   | Singleton, Factory, Builder |
| Estructurales  | Adapter, Facade, Decorator  |
| Comportamiento | Strategy, Observer, Command |

### 🧱 Arquitectura del Proyecto

reserva/
├── Builder/
├── Factory/
├── Strategy/
├── SingletonSistema/
├── Decorator/
├── Adapter/
├── Facade/
├── Observer/
├── Command/
├── Models/
└── Main.java

### 🚀 Instalación y Ejecución
#### ✅ Requisitos

    Java 8 o superior
    Terminal o IDE (IntelliJ, VS Code, etc.)

#### 📥 Clonar o descargar

```dos
> bash
> git clone https://github.com/KodigoOrg/ReservaHotel_Grupo4.git
> cd ReservaHotel_Grupo4
```



#### ▶️ Compilar y ejecutar
```dos
> bash
> 
> javac -d out $(find . -name "*.java")
> java -cp out reserva.Main
```



🧪 Uso desde Consola

    Al ejecutar Main, se mostrará un menú interactivo:

    === SISTEMA DE RESERVAS ===
    ¿Desea agregar servicio de hotel? (si/no): si
    ¿Desea seguro adicional? (si/no): si
    ¿Desea agregar servicio de auto? (si/no): si
    Seleccione método de pago (tarjeta, paypal): tarjeta
    Reserva realizada correctamente.

    Al finalizar, puedes:
        Ver todas las reservas
        Cancelar por ID
        Deshacer la última reserva gracias al patrón Command

#### 📦 Ejemplo de Salida

=== RESERVAS GUARDADAS ===
- ID: 1, Servicios: Hotel ($150), Auto ($25), Pago: pago tarjeta, Total: $190

¿Desea eliminar la última reserva? (si/no): si
[Notificación para admin] Última reserva elimiada.

📄 Licencia
Este proyecto es de código abierto y está disponible bajo la licencia MIT.
