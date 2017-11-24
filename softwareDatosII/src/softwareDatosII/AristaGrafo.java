package softwareDatosII;

public class AristaGrafo {

    private NodoGrafo nodoInicial = null;
    private NodoGrafo nodoFinal = null;
    private int peso = 0;

    public AristaGrafo(NodoGrafo nodoInicial, NodoGrafo nodoFinal, int peso) {
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
        this.peso = peso;
    }

    public NodoGrafo getNodoInicial() {
        return this.nodoInicial;
    }

    public NodoGrafo getNodoFinal() {
        return this.nodoFinal;
    }

    public int getPeso() {
        return this.peso;
    }

    public boolean Equals(AristaGrafo edge) //"Overwrite" Equals() function
    {
        if (this.nodoInicial.getInfo().equals(edge.getNodoInicial().getInfo()) && this.nodoFinal.getInfo().equals(edge.getNodoFinal().getInfo())) {
            return true;
        }
        return false;
    }
}
