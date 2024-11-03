package reservasHotel;

public class Reserva {
    Cliente cliente;
    Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }
}