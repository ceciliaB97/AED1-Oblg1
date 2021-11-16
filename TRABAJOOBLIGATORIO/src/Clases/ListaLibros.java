package Clases;

import java.util.HashSet;

public class ListaLibros {

    private NodoLibro inicio;
    private NodoLibro fin;
    private int limite;
    private int actual;
    //propiedades de libro

    public ListaLibros(int limite) {
        this.inicio = null;
        this.fin = null;
        this.limite = limite;
        this.actual = 0;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public NodoLibro getInicioL() {
        return inicio;
    }

    public void setInicio(NodoLibro inicio) {
        this.inicio = inicio;
    }

    public NodoLibro getFinL() {
        return fin;
    }

    public void setFin(NodoLibro fin) {
        this.fin = fin;
    }

    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoLibro nuevo) {
        if (puedoInsertar()) {
            this.actual++;
            if(this.esVacia()){
                this.setInicio(nuevo);
                this.setFin(nuevo);
            } else {
                nuevo.setSiguiente(this.inicio);
                this.inicio = nuevo;
            }
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoLibro n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
            } else {
                NodoLibro aux = this.inicio;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(n);
                this.fin = n;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    public boolean borrarInicio() {
        if (!this.esVacia()) {
            this.actual--;
            this.inicio = this.inicio.getSiguiente();
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Borra el último nodo
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoLibro aux = this.inicio;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.fin = aux;
                this.fin.setSiguiente(null);
            }
        }
        return true;
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio != null) {
            borrarInicio();
        }
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC() {
        if (!this.esVacia()) {
            mostrarREC2(this.getInicioL(), 1);
        } else {
            System.out.println("La lista no tiene libros");
        }

    }

    public void mostrarREC2(NodoLibro n, int cont) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getTitulo() + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion

        } else {
            System.out.println(cont + "- <" + n.getTitulo() + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion
            mostrarREC2(n.getSiguiente(), ++cont);

        }
    }

    public void mostrarRECExtenso() {
        if (!this.esVacia()) {
            mostrarRECExtenso2(this.getInicioL(), 1);
        } else {
            System.out.println("No hay libros");
        }

    }

    public void mostrarRECExtenso2(NodoLibro n, int cont) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getTitulo() + " " + n.getEditorial() + " " + n.getCalifPromedio() + ">");
        } else {
            System.out.println(cont + "- <" + n.getTitulo() + " " + n.getEditorial() + " " + n.getCalifPromedio() + ">");
            mostrarRECExtenso2(n.getSiguiente(), ++cont);

        }
    }

    public NodoLibro obtenerElementoAnterior(NodoLibro n) {
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(n.getTitulo())) {
                return null;
            } else {
                NodoLibro aux = this.getInicioL();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getTitulo().equals(n.getTitulo())) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(NodoLibro n) {
        //si no es null
        if (!esVacia()) {
            if (n.getTitulo().equals(getInicioL().getTitulo())) {
                borrarInicio();
                return true;

            } else if (n.getTitulo().equals(getFinL().getTitulo())) {
                borrarFin();
                return true;

            } else {

                NodoLibro aux = this.obtenerElementoAnterior(n);

                if (aux != null) {
                    if (aux.getSiguiente() != getFinL()) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            NodoLibro aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLibro obtenerElemento(String titulo, String editorial) {
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(titulo) && this.inicio.getEditorial().equals(editorial)) {
                return inicio;
            }
            if (this.fin.getTitulo().equals(titulo) && this.fin.getEditorial().equals(editorial)) {
                return fin;
            } else {
                NodoLibro aux = this.getInicioL();
                while (aux != null) {
                    if (aux.getTitulo().equals(titulo) && aux.getEditorial().equals(editorial)) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    /**
     * Si actual < a limite, inserto //PRE: -- //POS: True si actualmente no
     * paso el limite de la lista. @return T/F
     */
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

    public boolean buscarElemento(NodoLibro n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(n.getTitulo())&& this.inicio.getEditorial().equals(n.getEditorial())) {
                ret = true;
                return ret;
            }
            if (this.fin.getTitulo().equals(n.getTitulo())) {
                ret = true;
            } else {
                NodoLibro aux = this.getInicioL();
                while (aux.getSiguiente() != null) {
                    if (aux.getTitulo().equals(n.getTitulo())) {
                        ret = true;
                        return ret;
                    }
                    aux = aux.getSiguiente();
                }
            }
        } else {
            ret = false;
        }
        return ret;
    }

    public int contarNodos(ListaLibros n) {
        return n.cantElementos();
    }

    //auxiliar
    public boolean eliminarElementoDesdeNodo(NodoLibro n, NodoLibro nodoDesde) {
        if (n.getTitulo().equals(getFinL().getTitulo())) {
            borrarFin();
            return true;
        } else {
            NodoLibro aux = this.obtenerElementoAnteriorNodoDesde(n, nodoDesde);
            if (aux != null) {
                if (aux.getSiguiente() != getFinL()) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    return true;
                }
            }
        }
        return false;
    }
    
    public NodoLibro obtenerElementoAnteriorNodoDesde(NodoLibro n, NodoLibro desde) {
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(n.getTitulo())) {
                return null;
            } else {
                NodoLibro aux = desde;
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getTitulo().equals(n.getTitulo())) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    // revisar este metodo
    public void OrdenarLibrosPorCantidadSolicitudes() {
        if (!this.esVacia()) {
            for (NodoLibro i = this.getInicioL(); i != null; i = i.getSiguiente()) {
                for (NodoLibro j = i; j != null; j = j.getSiguiente()) {
                    //cantidad de solicitudes
                    if (i.getCantSolicitudes()< j.getCantSolicitudes()) {
                        NodoLibro aux = j.getSiguiente();
                        NodoLibro auxi = i;
                        this.eliminarElemento(i);
                        j.setSiguiente(auxi);
                        i.setSiguiente(aux);
                    }
                }
            }
        }
    }
  
    public NodoLibro ObtenerLibroPorElemento(int i){
        int contador = 0;
        NodoLibro aux = this.getInicioL();
        while(aux != null){
            if(contador == i){
                return aux;
            }
            aux = aux.getSiguiente();
            contador++;
        }
        return null;
    }

}
