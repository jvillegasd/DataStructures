package softwareDatosII;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Grafo { //Mi implementacion de grafos, el codigo inicialmente lo hize en C#

    private List<NodoGrafo> nodos = null;
    private List<AristaGrafo> aristas = null;
    private boolean esDirigido = false;
    private JPanel panelDibujo = null;

    public Grafo(boolean esDirigido, JPanel panelDibujo) {
        nodos = new ArrayList<NodoGrafo>();
        aristas = new ArrayList<AristaGrafo>();
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

    public void dijkstra(NodoGrafo nodoInicial) {
        ColaPrioridad priorityQueue = new ColaPrioridad();
        priorityQueue.pushMinHeap(nodoInicial);
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
                    calculateDistance(actualNodoGrafo, nodoAdj, weight, priorityQueue);
                }
            }
        }
    }

    public void BFS(NodoGrafo nodoInicial, ArbolBST arbol) {
        ColaPrioridad priorityQueue = new ColaPrioridad();
        priorityQueue.pushMinHeap(nodoInicial);
        for (NodoGrafo node : nodos) {
            node.startBFS();
        }
        nodoInicial.setDistancia(0);
        int dato = Integer.parseInt(nodoInicial.getInfo());
        NodoBST nodoBST = arbol.getNodo(arbol.getRaiz(), dato);
        dibujarCamino(nodoBST); //Pintar el nodo inicial
        while (priorityQueue.Count() != 0) {
            NodoGrafo nodoActual = priorityQueue.removeMinHeap();
            nodoActual.setIsVisited(true);
            for (AristaGrafo arista : nodoActual.getAristasAdj()) {
                NodoGrafo nodoAdj = arista.getNodoFinal();
                if (!nodoAdj.getIsDiscovered()) {
                    calculateDistance(nodoActual, nodoAdj);
                    nodoAdj.setIsDiscovered(true);
                    priorityQueue.pushMinHeap(nodoAdj);
                    dato = Integer.parseInt(nodoAdj.getInfo());
                    nodoBST = arbol.getNodo(arbol.getRaiz(), dato);
                    dibujarCamino(nodoBST); //Pintar hijos del nodo actual
                }
            }
        }
    }

    private void calculateDistance(NodoGrafo actualNodoGrafo, NodoGrafo nodoAdj, int weight, ColaPrioridad priorityQueue) //Uso del Dijkstra
    {
        if (actualNodoGrafo.getDistancia() + weight < nodoAdj.getDistancia()) {
            nodoAdj.setDistancia(actualNodoGrafo.getDistancia() + weight);
            priorityQueue.pushMinHeap(nodoAdj);
        }
    }

    private void calculateDistance(NodoGrafo actualNodo, NodoGrafo nodoAdj) //Uso del BFS
    {
        if (actualNodo.getDistancia() + 1 < nodoAdj.getDistancia()) {
            nodoAdj.setDistancia(actualNodo.getDistancia() + 1);
        }
    }

    private void dibujarCamino(NodoBST nodo) {
        Graphics g = panelDibujo.getGraphics();
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
