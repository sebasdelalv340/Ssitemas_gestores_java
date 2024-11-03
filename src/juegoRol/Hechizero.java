package juegoRol;

public class Hechizero extends Personaje {
    Hechizo hechizo;

    public Hechizero(String nombre, int ataque, Hechizo hechizo) {
        super(nombre, ataque);
        this.hechizo = hechizo;
    }

    @Override
    public int atacar() {
        ataque += hechizo.damage;
        return ataque;
    }
}