package juegoRol;

import consola.Consola;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();
        Guerrero guerrero = new Guerrero("Enno", 6);
        Hechizo hechizo = new Hechizo("Fuego", 2);
        Hechizero hechizero = new Hechizero("Gandalf", 5, hechizo);

        while (guerrero.vida > 0 && hechizero.vida > 0) {
            Personaje personaje = Math.random() < 0.5 ? guerrero : hechizero; // Elegir aleatoriamente un personaje

            if (personaje == guerrero) {
                hechizero.recibirDamage(personaje.atacar());
            } else {
                guerrero.recibirDamage(hechizero.atacar());
            }

            consola.imprimirTexto(hechizero.nombre + " - Vida: " + hechizero.vida, true);
            consola.imprimirTexto(guerrero.nombre + " - Vida: " + guerrero.vida, true);
        }

        if (guerrero.vida <= 0) {
            consola.imprimirTexto(hechizero.nombre + " ha ganado.", true);
        } else {
            consola.imprimirTexto(guerrero.nombre + " ha ganado.", true);
        }
    }
}