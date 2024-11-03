package reservasHotel;

import consola.Consola;

import java.util.ArrayList;
import java.util.List;

class GestorReservar {
    Consola consola;
    List<Reserva> reservas;

    public GestorReservar(Consola consola) {
        this.consola = consola;
        this.reservas = new ArrayList<>();
    }

    public void realizarReserva() {
        Cliente cliente = infoCliente();
        int numHabitacion = (int) (Math.random() * (520 - 101 + 1)) + 101;
        Tipo tipo = Math.random() < 0.5 ? Tipo.INDIVIDUAL : Tipo.DOBLE;
        reservas.add(new Reserva(cliente, new Habitacion(numHabitacion, tipo)));
    }

    public void cancelarReserva() {
        Cliente cliente = infoCliente();
        Reserva reserva = reservas.stream()
                .filter(r -> r.cliente.equals(cliente))
                .findFirst()
                .orElse(null);
        if (reserva != null) {
            reservas.remove(reserva);
            consola.imprimirTexto("Reserva cancelada.", true);
        } else {
            consola.imprimirTexto("No se ha encontrado ninguna reserva con dicho cliente.", true);
        }
    }

    public void mostrarReservas() {
        reservas.forEach(reserva -> consola.imprimirTexto(reserva.toString(), true));
    }

    private Cliente infoCliente() {
        consola.imprimirTexto("Nombre del cliente: ", false);
        String nombre = consola.pedirString();
        consola.imprimirTexto("DNI del cliente: ", false);
        String dni = consola.pedirString();
        return new Cliente(nombre, dni);
    }
}