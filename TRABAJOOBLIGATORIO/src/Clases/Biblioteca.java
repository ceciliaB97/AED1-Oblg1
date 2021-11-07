package Clases;

import Estructuras.Lista;
import Estructuras.NodoLista;

public class Biblioteca extends Lista {

    //atributos de lista<biblioteca>
    private Biblioteca inicio;
    private Biblioteca fin;
    //limite actual
    private int actual;
    private int limite;
    //atributos de biblioteca
    private String nombre;
    private Libro libros;
    private Biblioteca siguiente;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = null;
        this.siguiente = null;
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = 0;
    }

    public Biblioteca getInicioB() {
        return inicio;
    }

    public void setPrimero(Biblioteca Inicio) {
        this.inicio = Inicio;
    }

    public Biblioteca getFinB() {
        return fin;
    }

    public void setUltimo(Biblioteca Fin) {
        this.fin = Fin;
    }

    public Biblioteca getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Biblioteca siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libro getLibros() {
        return libros;
    }

    public void setLibros(Libro libros) {
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
    public boolean agregarInicio(Biblioteca nuevo) {
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
    public boolean agregarFinal(Biblioteca n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
            } else {
                Biblioteca aux = this.inicio;
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
                Biblioteca aux = this.inicio;
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

    public void mostrarREC2(Biblioteca n, int cont
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
    
    public Biblioteca obtenerElementoAnterior(Biblioteca n) {
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n.getNombre())) {
                return null;
            } else {
                Biblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getNombre().equals(n.getNombre())) {
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
    public boolean eliminarElemento(Biblioteca n) {
        //si no es null
        if (!esVacia()) {
            if (n.getNombre().equals(getInicioB().getNombre())) {
                borrarInicio();
                return true;

            } else if (n.getNombre().equals(getFinB().getNombre())) {
                borrarFin();
                return true;

            } else {

                Biblioteca aux = this.obtenerElementoAnterior(n);

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
            Biblioteca aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
   public Biblioteca obtenerElemento(Biblioteca n) {
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n.getNombre())) {
                return inicio;
            }
            if (this.fin.getNombre().equals(n.getNombre())) {
                return fin;
            } else {
                Biblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getNombre().equals(n.getNombre())) {
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
    
    public boolean buscarElemento(Biblioteca n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n.getNombre())) {
                ret = true;
                return ret;
            }
            if (this.fin.getNombre().equals(n.getNombre())) {
                ret = true;
            } else {
                Biblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getNombre().equals(n.getNombre())) {
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

    public int contarNodos(Biblioteca n) {
        return n.cantElementos();
    }
}
