package softwareDatosII;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Grafo { //Mi implementacion de grafos, el codigo inicialmente lo hize en C#

    private List<NodoGrafo> nodos = null;
    private List<AristaGrafo> aristas = null;
    private List<NodoGrafo> caminoPadre = null;
    private List<NodoGrafo> caminoHijo = null;
    private boolean esDirigido = false;
    private JPanel panelDibujo = null;

    public Grafo(boolean esDirigido, JPanel panelDibujo) {
        nodos = new ArrayList<NodoGrafo>();
        aristas = new ArrayList<AristaGrafo>();
        caminoPadre = new ArrayList<NodoGrafo>();
        caminoHijo = new ArrayList<NodoGrafo>();
        this.esDirigido = esDirigido;
        this.panelDibujo = panelDibujo;
    }

    public void insertarNodo(String info) {
        NodoGrafo nuevoNodo = new NodoGrafo(info);
        boolean found = false;
        for (NodoGrafo node : this.nodos) {
            if (node.Equals(nuevoNodo)) {
                found = true;
                break;
            }
        }
        if (!found) {
            this.nodos.add(nuevoNodo);
        }
    }

    public void insertarArista(NodoGrafo nodoInicial, NodoGrafo nodoFinal, int weight, int cont) {
        AristaGrafo nuevaArista = new AristaGrafo(nodoInicial, nodoFinal, weight);
        boolean found = false;
        for (AristaGrafo arista : aristas) {
            if (arista.Equals(nuevaArista)) {
                found = true;
                break;
            }
        }
        if (!found) {
            if (esDirigido) {
                nodoInicial.getAristasAdj().add(nuevaArista);
                aristas.add(nuevaArista);
            } else {
                if (cont == 0) {
                    nodoInicial.getAristasAdj().add(nuevaArista);
                    insertarArista(nodoFinal, nodoInicial, weight, 1);
                    aristas.add(nuevaArista);
                } else {
                    nodoInicial.getAristasAdj().add(nuevaArista);
                    aristas.add(nuevaArista);
                }
            }
        }

    }

    public NodoGrafo getNodoGrafo(String info) {
        for (NodoGrafo node : nodos) {
            if (node.getInfo().equals(info)) {
                return node;
            }
        }
        return null;
    }

    public void dijkstraAlgorithm(NodoGrafo nodoInicial) {
        ColaPrioridad priorityQueue = new ColaPrioridad();
        priorityQueue.pushMinHeap(nodoInicial);
        caminoPadre.clear();
        caminoHijo.clear();
        for (NodoGrafo node : nodos) {
            node.startDijkstra(nodos.size());
        }
        nodoInicial.setDistancia(0);
        while (priorityQueue.Count() != 0) {
            NodoGrafo actualNodoGrafo = priorityQueue.removeMinHeap();
            actualNodoGrafo.setIsVisited(true);
            for (AristaGrafo arista : actualNodoGrafo.getAristasAdj()) {
                NodoGrafo nodoAdj = arista.getNodoFinal();
                if (!nodoAdj.getIsVisited()) {
                    int weight = arista.getPeso();
                    calculateDistance(actualNodoGrafo, nodoAdj, weight, priorityQueue, caminoPadre, caminoHijo);
                }
            }
        }
    }

    public void bfsAlgorithm(NodoGrafo nodoInicial, ArbolBST arbol) {
        ColaPrioridad priorityQueue = new ColaPrioridad();
        priorityQueue.pushMinHeap(nodoInicial);
        caminoPadre.clear();
        caminoHijo.clear();
        for (NodoGrafo node : nodos) {
            node.startBFS(nodos.size());
        }
        nodoInicial.setDistancia(0);
        while (priorityQueue.Count() != 0) {
            NodoGrafo nodoActual = priorityQueue.removeMinHeap();
            nodoActual.setIsVisited(true);
            int dato = Integer.parseInt(nodoActual.getInfo());
            NodoBST nodoBST = arbol.getNodo(arbol.getRaiz(), dato);
            dibujarCamino(nodoBST); //Ir dibujando cada nodo que sale de la cola de prioridad
            for (AristaGrafo arista : nodoActual.getAristasAdj()) {
                NodoGrafo nodoAdj = arista.getNodoFinal();
                if (!nodoAdj.getIsDiscovered()) {
                    calculateDistance(nodoActual, nodoAdj, caminoPadre, caminoHijo);
                    nodoAdj.setIsDiscovered(true);
                    priorityQueue.pushMinHeap(nodoAdj);
                }
            }
        }
    }

    private void calculateDistance(NodoGrafo actualNodoGrafo, NodoGrafo nodoAdj, int weight, ColaPrioridad priorityQueue, List<NodoGrafo> pPath, List<NodoGrafo> cPath) //Uso del Dijkstra
    {
        if (actualNodoGrafo.getDistancia() + weight < nodoAdj.getDistancia()) {
            nodoAdj.setDistancia(actualNodoGrafo.getDistancia() + weight);
            pPath.add(actualNodoGrafo);
            cPath.add(nodoAdj);
            priorityQueue.pushMinHeap(nodoAdj);
        }
    }

    private void calculateDistance(NodoGrafo actualNodoGrafo, NodoGrafo nodoAdj, List<NodoGrafo> pPath, List<NodoGrafo> cPath) //Uso del BFS
    {
        if (actualNodoGrafo.getDistancia() + 1 < nodoAdj.getDistancia()) {
            nodoAdj.setDistancia(actualNodoGrafo.getDistancia() + 1);
            pPath.add(actualNodoGrafo);
            cPath.add(nodoAdj);
        }
    }

    private void dibujarCamino(NodoBST nodo) {
        Graphics g = panelDibujo.getGraphics();
        NodoBST padre = nodo.getPadre();
        g.setColor(Color.BLUE);
        g.fillOval(nodo.getPosX(), nodo.getPosY(), 20, 20);
        g.setColor(Color.WHITE);
        g.drawString(nodo.getDato() + "", nodo.getPosX() + 3, nodo.getPosY() + 14);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
        }
    }
}
