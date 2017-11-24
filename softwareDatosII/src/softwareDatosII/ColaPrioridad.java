package softwareDatosII;

import java.util.ArrayList;
import java.util.List;

public class ColaPrioridad { //Cola de prioridad implementada por mi, usa el Min Heap

    private List<NodoGrafo> queue = null;

    public ColaPrioridad() {
        queue = new ArrayList<NodoGrafo>();
    }

    public void pushMinHeap(NodoGrafo node) {
        queue.add(node);                                                    
        int index = queue.size() - 1;                                        
        while (index > 0 && queue.get(index).getDistancia() < queue.get((index - 1) / 2).getDistancia()) 
        {                                                                                                                              
            NodoGrafo auxNode = queue.get(index);
            queue.set(index, queue.get((index - 1) / 2));
            queue.set((index - 1) / 2, auxNode);
            index = (index - 1) / 2;
        }
    }

    public NodoGrafo removeMinHeap() {
        NodoGrafo node = queue.get(0);
        queue.set(0, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        int index = 0;
        while (index < queue.size() - 1)
        {
            if (2 * index + 1 < queue.size() && queue.get(index).getDistancia() > queue.get(2 * index + 1).getDistancia())
            {                                                                                                          
                NodoGrafo auxNode = queue.get(index);
                queue.set(index, queue.get(2 * index + 1));
                queue.set(2 * index + 1, auxNode);
            }
            if (2 * index + 2 < queue.size() && queue.get(index).getDistancia() > queue.get(2 * index + 2).getDistancia())
            {                                                                                                           
                NodoGrafo auxNode = queue.get(index);
                queue.set(index, queue.get(2 * index + 2));
                queue.set(2 * index + 2, auxNode);
            }
            index++;
        }
        return node;
    }

    public int Count() {
        return queue.size();
    }
}
