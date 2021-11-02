package Estructuras;

/**
 *
 * @author RC
 */
public class NodoLista {

    private TDato dato;
    private NodoLista sig;

    public NodoLista(TDato n) {
        this.dato = n;
        this.sig = null;
    }

    //set y get 
    public void setDato(TDato d) {
        this.dato = d;
    }

    public TDato getDato() {
        return this.dato;
    }

    public void setSig(NodoLista s) {
        this.sig = s;
    }

    public NodoLista getSig() {
        return this.sig;
    }
}
