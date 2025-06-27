package modelo;

import Interfaces.IVertice;

// Representa un lugar de la ciudad
public class Vertice implements IVertice {
    private String nombre;

    public Vertice(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertice)) return false;
        Vertice otro = (Vertice) obj;
        return this.nombre.equals(otro.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}