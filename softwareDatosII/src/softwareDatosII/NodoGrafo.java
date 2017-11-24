package softwareDatosII;

import java.util.ArrayList;
import java.util.List;

public class NodoGrafo {

    private String info;
    private List<AristaGrafo> aristasAdj = null;
    private int distancia;
    private boolean esVisitado;
    private boolean esDescubierto;

    public NodoGrafo(String info) {
        this.info = info;
        aristasAdj = new ArrayList<AristaGrafo>();
    }

    public List<AristaGrafo> getAristasAdj() {
        return aristasAdj;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getInfo() {
        return info;
    }

    public void setIsVisited(boolean esVisitado) {
        this.esVisitado = esVisitado;
    }

    public boolean getIsVisited() {
        return esVisitado;
    }

    public void setIsDiscovered(boolean esDescubierto) {
        this.esDescubierto = esDescubierto;
    }

    public boolean getIsDiscovered() {
        return esDescubierto;
    }

    public boolean Equals(NodoGrafo nodo) //"Overwrite" Equals() function
    {
        if (info.equals(nodo.getInfo())) {
            return true;
        }
        return false;
    }

    public void startDijkstra(int vertexNumber) {
        distancia = Integer.MAX_VALUE;
        esVisitado = false;
    }

    public void startBFS() {
        distancia = Integer.MAX_VALUE;
        esVisitado = false;
        esDescubierto = false;
    }
}