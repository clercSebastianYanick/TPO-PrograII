package modelo;

import Interfaces.*;

import java.util.*;

// Esta clase guarda todos los lugares y conexiones
public class Grafo implements IGrafo {
    private Map<IVertice, List<IArista>> adyacentes;

    public Grafo() {
        adyacentes = new HashMap<>();
    }

    @Override
    public void agregarVertice(IVertice v) {
        adyacentes.putIfAbsent(v, new ArrayList<>());
    }

    @Override
    public void agregarArista(IVertice origen, IVertice destino, int peso) {
        adyacentes.get(origen).add(new Arista(destino, peso));
        adyacentes.get(destino).add(new Arista(origen, peso)); // no dirigido
    }

    @Override
    public Map<IVertice, Integer> dijkstra(IVertice inicio) {
        Map<IVertice, Integer> distancias = new HashMap<>();
        Set<IVertice> visitados = new HashSet<>();
        PriorityQueue<Map.Entry<IVertice, Integer>> cola = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (IVertice v : adyacentes.keySet()) {
            distancias.put(v, Integer.MAX_VALUE);
        }

        distancias.put(inicio, 0);
        cola.add(new AbstractMap.SimpleEntry<>(inicio, 0));

        while (!cola.isEmpty()) {
            IVertice actual = cola.poll().getKey();

            if (visitados.contains(actual)) continue;
            visitados.add(actual);

            for (IArista arista : adyacentes.get(actual)) {
                IVertice vecino = arista.getDestino();
                int nuevaDist = distancias.get(actual) + arista.getPeso();

                if (nuevaDist < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDist);
                    cola.add(new AbstractMap.SimpleEntry<>(vecino, nuevaDist));
                }
            }
        }

        return distancias;
    }
}