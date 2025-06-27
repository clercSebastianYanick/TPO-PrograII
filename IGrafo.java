package Interfaces;
import java.util.Map;
public interface IGrafo {
	 void agregarVertice(IVertice v);
	    void agregarArista(IVertice origen, IVertice destino, int peso);
	    Map<IVertice, Integer> dijkstra(IVertice inicio);
}
