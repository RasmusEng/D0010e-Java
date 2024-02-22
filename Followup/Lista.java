public package Followup;

import java.util.List;
import java.util.NoSuchElementException;

class Lista {
    private Nod start;


    public int Lista(){
        Nod nod = start;
        int len = 0; // Antal hopp 

        while(nod.nästa != null){
            nod = nod.nästa;
            len++;
        }

        return len;

    }

    public E första(){
        Nod nod = start;
        if(nod.nästa == null){
            throw new NoSuchElementException();
        }
        start.nästa = nod.nästa;
        return nod.element;
        
    }

    public void adda(E e){
        Nod nod = new Nod(e, start.nästa);
        start.nästa = nod;

    }

    public boolean ärTom(){
        Nod nod = start;
        if (nod.nästa == null){
            return true;
        }
        return false;
    }
    public class Iterator<E> {
        
        
    }
}
