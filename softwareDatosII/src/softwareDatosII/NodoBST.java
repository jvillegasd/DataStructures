package softwareDatosII;

public class NodoBST {

    private int dato = 0;
    private NodoBST hi = null; //Hijo izquierdo
    private NodoBST hd = null; //Hijo derecho
    private NodoBST padre = null;
    private int nivel;
    private int posX = 0, posY = 0;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public NodoBST(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoBST getHi() {
        return hi;
    }

    public void setHi(NodoBST hi) {
        this.hi = hi;
    }

    public NodoBST getHd() {
        return hd;
    }

    public void setHd(NodoBST hd) {
        this.hd = hd;
    }

    public NodoBST getPadre() {
        return padre;
    }

    public void setPadre(NodoBST padre) {
        this.padre = padre;
    }
}