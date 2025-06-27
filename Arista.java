package modelo;

import Interfaces.IArista;
import Interfaces.IVertice;

// Representa una calle entre dos lugares con un peso (distancia)
public class Arista implements IArista {
    private IVertice destino;
    private int peso;

    public Arista(IVertice destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public IVertice getDestino() {
        return destino;
    }

    @Override
    public int getPeso() {
        return peso;
    }
}
