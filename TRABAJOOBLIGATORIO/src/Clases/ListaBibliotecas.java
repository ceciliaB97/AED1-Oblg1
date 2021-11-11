package Clases;

import Estructuras.Lista;
import Estructuras.NodoLista;

public class ListaBibliotecas extends Lista {

    //atributos de lista<biblioteca>
    private NodoBiblioteca inicio;
    private NodoBiblioteca fin;
    //limite actual
    private int actual;
    private int limite;
    //atributos de biblioteca
    private ListaLibros libros;


    public ListaBibliotecas(String nombre) {        
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = 0;        
        this.libros = new ListaLibros(0);
    }

    public NodoBiblioteca getInicioB() {
        return inicio;
    }

    public void setPrimero(NodoBiblioteca Inicio) {
        this.inicio = Inicio;
    }

    public NodoBiblioteca getFinB() {
        return fin;
    }

    public void setUltimo(NodoBiblioteca Fin) {
        this.fin = Fin;
    }

    public ListaLibros getLibros() {
        return libros;
    }

    public void setLibros(ListaLibros libros) {
        this.libros = libros;
    }

    @Override
    public int getActual() {
        return actual;
    }

    @Override
    public void setActual(int Actual) {
        this.actual = Actual;
    }
    
        /**
     * @return the limite
     */
    @Override
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    @Override
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoBiblioteca nuevo) {
        if (puedoInsertar()) {
            this.actual++;
            nuevo.setSiguiente(this.inicio);
            this.inicio = nuevo;
            if (this.fin == null)//estoy insertando el primer nodo
            {
                this.fin = nuevo;
            }
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoBiblioteca n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
            } else {
                NodoBiblioteca aux = this.inicio;
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
    @Override
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
    @Override
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoBiblioteca aux = this.inicio;
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
    @Override
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
        if(!this.esVacia()){
            mostrarREC2(this.getInicioB(), 1);
        } else {
            System.out.println("La lista no tiene bibliotecas");
        }        
    }

    public void mostrarREC2(NodoBiblioteca n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.nombre + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion

        } else {
            System.out.println(cont + "- <" + n.nombre + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion
            mostrarREC2(n.getSiguiente(), ++cont);

        }
    }
    
    public NodoBiblioteca obtenerElementoAnterior(String n) {
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n)) {
                return null;
            } else {
                NodoBiblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getNombre().equals(n)) {
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
    public boolean eliminarElemento(String n) {
        //si no es null
        if (!esVacia()) {
            if (n.equals(getInicioB().getNombre())) {
                borrarInicio();
                return true;

            } else if (n.equals(getFinB().getNombre())) {
                borrarFin();
                return true;

            } else {

                NodoBiblioteca aux = this.obtenerElementoAnterior(n);

                if (aux != null) {
                    if (aux.getSiguiente() != getFinB()) {
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
    @Override
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            NodoBiblioteca aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
   public NodoBiblioteca obtenerElemento(String n) {
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n)) {
                return inicio;
            }
            if (this.fin.getNombre().equals(n)) {
                return fin;
            } else {
                NodoBiblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getNombre().equals(n)) {
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
    @Override
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }
    
    public boolean buscarElemento(String n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n)) {
                ret = true;
                return ret;
            }
            if (this.fin.getNombre().equals(n)) {
                ret = true;
            } else {
                NodoBiblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getNombre().equals(n)) {
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

    public int contarNodos(ListaBibliotecas n) {
        return n.cantElementos();
    }
}
