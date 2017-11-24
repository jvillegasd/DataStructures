package softwareDatosII;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;

public class Ordenamientos {

    private JPanel panelDibujo;
    private List<int[]> resultados = new ArrayList<>();
    private List<String> quickSortR = new ArrayList<>(); //Para guardar las iteraciones del quickSort

    public Ordenamientos(JPanel panelDibujo) {
        this.panelDibujo = panelDibujo;
    }

    public int[] insertSort(int[] vector, int tam) {
        if (tam < 2) {
            return vector;
        }
        resultados.clear();
        int numero, j;
        for (int i = 1; i < tam; i++) {
            numero = vector[i];
            j = i - 1;
            while ((j >= 0) && (numero < vector[j])) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = numero;
            int[] copia = new int[tam];
            System.arraycopy(vector, 0, copia, 0, tam);
            resultados.add(copia);
        }
        imprimirResultados(tam);
        return vector;
    }

    public int[] selectSort(int[] vector, int tam) {
        if (tam < 2) {
            return vector;
        }
        resultados.clear();
        int menor;
        for (int i = 0; i < tam; i++) {
            menor = i;
            for (int j = i + 1; j < tam; j++) {
                if (vector[j] < vector[menor]) {
                    menor = j;
                }
            }
            int aux = vector[menor];
            vector[menor] = vector[i];
            vector[i] = aux;
            int[] copia = new int[tam];
            System.arraycopy(vector, 0, copia, 0, tam);
            resultados.add(copia);
        }
        imprimirResultados(tam);
        return vector;
    }

    public int[] shellSort(int vector[], int tam) {
        int aux;
        boolean cambios;
        for (int salto = tam / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = salto; i < tam; i++) {
                    if (vector[i - salto] > vector[i]) {
                        aux = vector[i];
                        vector[i] = vector[i - salto];
                        vector[i - salto] = aux;
                        cambios = true;
                    }
                }
                if (cambios) {
                    int[] copia = new int[tam];
                    System.arraycopy(vector, 0, copia, 0, tam);
                    resultados.add(copia);
                }
            }
        }
        imprimirResultados(tam);
        return vector;
    }

    public int[] quickSort(int[] vector, int primero, int ultimo, int tam) {
        resultados.clear();
        if (ultimo - primero < 2) {
            return vector;
        }
        quickSortR.clear();
        vector = qs(vector, primero, ultimo, tam);
        imprimirResultados(tam);
        
        return vector;
    }

    private int[] qs(int[] vector, int primero, int ultimo, int tam) {
        int index = (primero + ultimo) / 2;
        int pivote = vector[index];
        int i = primero, j = ultimo;

        while (i <= j) {
            while (vector[i] < pivote) { //Busca elementos mayores que el pivote
                i++;
            }
            while (vector[j] > pivote) { //Busca elementos menores que el pivote
                j--;
            }
            String array = Arrays.toString(vector);
            array = array.replace(" ", "");
            quickSortR.add(array);
            if (i <= j) {
                int aux = vector[i];
                vector[i] = vector[j];
                vector[j] = aux;
                i++;
                j--;
            }
        }
        if (primero < j) {
            quickSort(vector, primero, j, tam);
        }
        if (ultimo > i) {
            quickSort(vector, i, ultimo, tam);
        }
        return vector;
    }

    public void imprimirResultados(int tam) {
        int length = resultados.size();
        String iteracion = "";
        Graphics g = panelDibujo.getGraphics();
        int x = 3;
        int y = 20;
        if (!quickSortR.isEmpty()) {
            length = quickSortR.size();
        }
        for (int i = 0; i < length; i++) {
            if (!quickSortR.isEmpty()) {
                iteracion = "[";
                int subTam = 0;
                for (int j = 0; j < 10000; j++) {
                    if(Character.isDigit(quickSortR.get(i).charAt(j))){
                        while(Character.isDigit(quickSortR.get(i).charAt(j))){
                            iteracion += quickSortR.get(i).charAt(j);
                            j++;
                        }
                        subTam++;
                        if(subTam != tam) iteracion += ", ";
                    }
                    if(subTam == tam){
                        iteracion += "]";
                        break;
                    }
                }
            } else {
                iteracion = Arrays.toString(resultados.get(i));
            }
            if (i % 5 == 0) {
                try {
                    Thread.sleep(3000);
                    g.clearRect(0, 0, panelDibujo.getWidth(), panelDibujo.getHeight());
                    panelDibujo.revalidate();
                    y = 20;
                } catch (InterruptedException ex) {

                }
            }
            g.drawString("Iteracion " + (i + 1), x, y);
            g.drawString(iteracion, x, y + 20);
            y += 40;
        }
    }
}
