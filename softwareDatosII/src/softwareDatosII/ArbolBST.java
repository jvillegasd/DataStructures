package softwareDatosII;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ArbolBST { //Arbol binario de busqueda, lo manejo como un grafo no dirigido

    private NodoBST raiz = null;
    private NodoBST aux = null;
    public JPanel panelDibujo = null;
    private Grafo arbolG = null;

    public ArbolBST(int dato, JPanel panelDibujo) {
        this.panelDibujo = panelDibujo;
        arbolG = new Grafo(false, panelDibujo);
        this.insertarNodo(dato);

    }

    public void insertarNodo(int dato) {
        NodoBST nuevonodo = new NodoBST(dato);
        arbolG.insertarNodo(dato + "");
        if (this.raiz == null) { //Añadir la raiz y pintarla
            this.raiz = nuevonodo;
            this.raiz.setPosX(panelDibujo.getWidth() / 2);
            this.raiz.setPosY(0);
            this.raiz.setNivel(0);
            dibujarArbol(this.raiz, false);
        } else if (!this.buscarDato(this.raiz, dato, false)) { //Añadir cualquier nodo y pintarlo
            this.aux = recorrerArbol(this.raiz, this.raiz, dato);
            nuevonodo.setPadre(aux);
            nuevonodo.setNivel(aux.getNivel() + 1);
            double exp = nuevonodo.getNivel() + 1;            
            int factor = (int) (panelDibujo.getWidth() / Math.pow(2, exp)); //Factor de separacion
            if (dato > this.aux.getDato()) {
                this.aux.setHd(nuevonodo);
                nuevonodo.setPosX((aux.getPosX()) + factor);
                System.out.println("Se agrego a la derecha, " + "Padre: " + this.aux.getDato());
            } else {
                this.aux.setHi(nuevonodo);
                nuevonodo.setPosX(aux.getPosX() - factor);
                System.out.println("Se agrego a la izquierda, " + "Padre: " + this.aux.getDato());
            }
            nuevonodo.setPosY(aux.getPosY() + 40);
            dibujarArbol(nuevonodo, false);
            NodoGrafo padre = arbolG.getNodoGrafo(aux.getDato() + "");
            NodoGrafo nodoActual = arbolG.getNodoGrafo(dato + "");
            arbolG.insertarArista(padre, nodoActual, 1, 0);
        }
    }

    public boolean buscarDato(NodoBST actual, int dato, boolean mostrarUI) {
        if (actual.getDato() == dato) {
            System.out.println("El dato si se encuentra en el arbol.");
            dibujarArbol(actual, mostrarUI);
            return true;
        } else {
            if (dato > actual.getDato()) {
                actual = actual.getHd();
            } else {
                actual = actual.getHi();
            }
        }
        if (actual == null) {
            System.out.println("El dato no se encuentra en el arbol.");
            return false;
        }
        return buscarDato(actual, dato, mostrarUI);
    }
    
    public NodoBST getNodo(NodoBST actual, int dato) {
        if (actual.getDato() == dato) {
            return actual;
        } else {
            if (dato > actual.getDato()) {
                actual = actual.getHd();
            } else {
                actual = actual.getHi();
            }
        }
        if (actual == null) {
            return null;
        }
        return getNodo(actual, dato);
    }

    private NodoBST recorrerArbol(NodoBST actual, NodoBST ant, int dato) {
        if (actual == null) {
            return ant;
        } else {
            if (dato > actual.getDato()) {
                ant = actual;
                actual = actual.getHd();
            } else {
                ant = actual;
                actual = actual.getHi();
            }
        }
        return recorrerArbol(actual, ant, dato);
    }

    public void recorridoPO(NodoBST actual) { //Pre-orden (Raiz-Izq-Der)
        if (actual != null) {
            System.out.print(actual.getDato() + ", ");
            recorridoPO(actual.getHi());
            recorridoPO(actual.getHd());
        }
    }

    public void recorridoIO(NodoBST actual) { //In-orden (Izq-Raiz-Der)
        if (actual != null) {
            recorridoIO(actual.getHi());
            System.out.print(actual.getDato() + ", ");
            recorridoIO(actual.getHd());
        }
    }

    public void recorridoPSO(NodoBST actual) { //Post-orden (Izq-Der-Raiz)
        if (actual != null) {
            recorridoPSO(actual.getHi());
            recorridoPSO(actual.getHd());
            System.out.print(actual.getDato() + ", ");
        }
    }

    public NodoBST eliminarNodo(NodoBST actual, int dato) {
        if (actual == null) {
            System.out.println("El elemento no se encuentra en el arbol");
            return null;
        }
        if (dato > actual.getDato()) { //Busco el nodo a eliminar
            actual.setHd(eliminarNodo(actual.getHd(), dato)); //Aprovecho la recursividad para resetear todos los enlaces
        } else {                                              //Tambien es porque java pasa por valor
            if (dato < actual.getDato()) {
                actual.setHi(eliminarNodo(actual.getHi(), dato));
            } else {
                if (dato == actual.getDato()) {
                    if (actual.getHi() == null && actual.getHd() == null) { //Caso nodo hoja
                        actual = null;
                    } else {
                        if (actual.getHi() != null && actual.getHd() != null) { //Caso nodo con dos hijos
                            NodoBST nodomasizq = masIzquierdo(actual.getHd());
                            actual.setDato(nodomasizq.getDato());
                            actual.setHd(eliminarNodo(actual.getHd(), nodomasizq.getDato()));
                        } else {
                            if (actual.getHi() != null) { //Caso nodo con un hijo
                                NodoBST basura = actual;
                                actual = actual.getHi();
                                actual.setPadre(basura.getPadre());
                                basura = null;
                            } else {
                                NodoBST basura = actual;
                                actual = actual.getHd();
                                actual.setPadre(basura.getPadre());
                                basura = null;
                            }
                        }
                    }
                }
            }
        }
        return actual;
    }

    private NodoBST masIzquierdo(NodoBST actual) { //Va a buscar al menor nodo de la sub-rama derecha
        if (actual.getHi() == null) {
            return actual;
        } else {
            return masIzquierdo(actual.getHi());
        }
    }

    public NodoBST getRaiz() {
        return this.raiz;
    }
    
    public void repintarArbol(NodoBST actual){
        if (actual != null) {
            dibujarArbol(actual, false);
            repintarArbol(actual.getHi());
            repintarArbol(actual.getHd());
            dibujarArbol(actual, false);
        }
    }
 

    private void dibujarArbol(NodoBST nodo, boolean mostrarUI) {
        Graphics g = panelDibujo.getGraphics();
        NodoBST padre = nodo.getPadre();
        if (mostrarUI) { //Pintar nodo buscado
            g.setColor(Color.BLUE);
            g.fillOval(nodo.getPosX(), nodo.getPosY(), 20, 20);
            g.setColor(Color.WHITE);
            g.drawString(nodo.getDato() + "", nodo.getPosX() + 3, nodo.getPosY() + 14);
            return;
        }

        if (padre != null) { //Evitar excepcion puntero nulo debido a la raiz
            g.drawLine(padre.getPosX() + 10, padre.getPosY() + 10, nodo.getPosX() + 10, nodo.getPosY() + 10);
        }
        if (padre != null) { //Repintar al padre por la linea
            g.setColor(Color.yellow);
            g.fillOval(padre.getPosX(), padre.getPosY(), 20, 20);
            g.setColor(Color.black);
            g.drawString(padre.getDato() + "", padre.getPosX() + 3, padre.getPosY() + 14);
        }
        g.setColor(Color.yellow);
        g.fillOval(nodo.getPosX(), nodo.getPosY(), 20, 20);
        g.setColor(Color.black);
        g.drawString(nodo.getDato() + "", nodo.getPosX() + 3, nodo.getPosY() + 14);
    }
    
    public void BFS(NodoBST nodoI){
        NodoGrafo nodoInicial = arbolG.getNodoGrafo(nodoI.getDato() + "");
        arbolG.bfsAlgorithm(nodoInicial, this);
    }
}
