package juegoRol;

import java.util.Random;

public abstract class Personaje {
    String nombre;
    int ataque;
    int vida;

    public Personaje(String nombre, int ataque) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.vida = 100; // Valor predeterminado
    }

    public int atacar() {
        Random random = new Random();
        ataque += random.nextInt(10) + 1;
        return ataque;
    }

    public void recibirDamage(int damage) {
        vida -= damage;
        if (vida < 0) {
            vida = 0;
        }
    }
}