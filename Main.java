package Main;

import Interfaces.*;
import modelo.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IGrafo ciudad = new Grafo();

        // Creamos los lugares de la ciudad
        IVertice plaza = new Vertice("Plaza Central");
        IVertice escuela = new Vertice("Escuela");
        IVertice supermercado = new Vertice("Supermercado");
        IVertice hospital = new Vertice("Hospital");
        IVertice estacion = new Vertice("Estación de tren");

        // Los agregamos al grafo
        ciudad.agregarVertice(plaza);
        ciudad.agregarVertice(escuela);
        ciudad.agregarVertice(supermercado);
        ciudad.agregarVertice(hospital);
        ciudad.agregarVertice(estacion);

        // Conectamos los lugares con distancias (en km)
        ciudad.agregarArista(plaza, escuela, 5);
        ciudad.agregarArista(plaza, supermercado, 10);
        ciudad.agregarArista(escuela, hospital, 4);
        ciudad.agregarArista(supermercado, hospital, 2);
        ciudad.agregarArista(hospital, estacion, 6);
        ciudad.agregarArista(escuela, estacion, 15);

        // Ejecutamos Dijkstra desde Plaza Central
        Map<IVertice, Integer> distancias = ciudad.dijkstra(plaza);

        // Mostramos resultados
        for (Map.Entry<IVertice, Integer> entry : distancias.entrySet()) {
            System.out.println("Distancia desde Plaza Central a " +
                entry.getKey().getNombre() + ": " + entry.getValue() + " km");
        }
    }
}
