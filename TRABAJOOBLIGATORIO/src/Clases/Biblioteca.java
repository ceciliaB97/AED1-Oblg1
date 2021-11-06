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
    public boolean agregarInicio(String n) {
        if (puedoInsertar()) {
            this.actual++;
            Biblioteca nuevo = new Biblioteca(n);
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
    public boolean agregarFinal(String n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.agregarInicio(n);
            } else {
                Biblioteca aux = this.inicio;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                Biblioteca nuevo = new Biblioteca(n);
                aux.setSiguiente(nuevo);
                this.fin = nuevo;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public boolean borrarInicio() {
        this.actual--;
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSiguiente();
        }
        return true;
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
    //!!!!! Cambiar por lo que pide la letra!!!!
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("Lista es vacía");
        } else {
            Biblioteca aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getNombre());
                aux = aux.getSiguiente();
            }
        }
    }

    /**
     * ***Otros Métodos (iterativos)****
     */
    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public boolean agregarOrd(Biblioteca n) {
//        if (puedoInsertar()) {
//            this.actual++;
//            //lista vacía o primer elemento es mayor o igual => agrego al ppio
//            if (this.esVacia() || this.inicio.getDato().CompareTo(n.getO()) == 1) {
//                this.agregarInicio(n);
//                return true;
//            }
//            //último elemento es menor o igual => agrego al final
//            if (this.fin.getDato().CompareTo(n.getO()) == -1) {
//                this.agregarFinal(n);
//                return true;
//            }
//            NodoLista aux = this.inicio;
//            while (aux.getSig() != null && aux.getSig().getDato().CompareTo(n.getO()) == 1) {
//                aux = aux.getSig();
//            }
//            NodoLista nuevo = new NodoLista(n);
//            nuevo.setSig(aux.getSig());
//            aux.setSig(nuevo);
//            return true;
//        }
        return false;
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(String n) {
        this.actual--;
        if (this.esVacia()) {
            return true;
        }
        if (this.inicio.getNombre() == n) {
            this.borrarInicio();
        } else {
            Biblioteca aux = this.inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getNombre() != n) {
                aux = aux.getSiguiente();
            }
            //lo encontré o llegué al final de la lista
            if (aux.getSiguiente() != null) {
                Biblioteca borrar = aux.getSiguiente();
                aux.setSiguiente(borrar.getSiguiente());
                borrar.setSiguiente(null);
                return true;
            }
        }
        return false;
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
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
    public Biblioteca obtenerElemento(String n) {
        Biblioteca aux = this.inicio;
        while (aux != null && aux.getNombre() != n) {
            aux = aux.getSiguiente();
        }
        //encontré dato o llegué al final
        return aux;
    }

    /**
     * *** Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    //!!! CAMBIAR POR LO QUE PIDA LA LETRA!!
    public void mostrarREC(Biblioteca l) {
        if (l != null) {
            System.out.println(l.getNombre());
            mostrarREC(l.getSiguiente());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(Biblioteca l) {
        if (l != null) {
            mostrarInversoREC(l.getSiguiente());
            System.out.println(l.getNombre());
        }
    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    //!!! CAMBIAR SEGUN LO QUE PIDA LA LETRA!!
    public boolean existeDatoREC(Biblioteca l, String n) {
        if (l != null) {
            if (l.getNombre() == n) {
                return true;
            } else {
                return existeDatoREC(l.getSiguiente(), n);
            }
        } else {
            return false;
        }
    }

    //PRE: Posicion de la lista
    //POS: Object en posicion i.
    public boolean datoEnPos(int i) {
//        int contador = 0;
//        if (i == 0) {
//            return this.inicio.getNombre();
//        }
//        Biblioteca ptr = this.inicio;
//        while (contador < i) {
//            ptr = ptr.getSiguiente();
//            contador++;
//        }
//        return ptr.getNombre();
        return false;
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
    
        //CORREGIR Y CORROBORAR EL COMPARE TO
    @Override
    public boolean agregarOrdenado(String n) {
        boolean ret = false;
//        //si esta vacia o si el primero es mayor a x
//        if (this.esVacia() || n.Nombre() == n) {
//            //se agrega al inicio
//            this.agregarInicio(n);
//            ret = true;
//            //si el ultimo valor es menor a x
//        } else if (n.CompareTo(inicio) == 1) {
//            //se agrega al final
//            this.agregarFinal(n);
//            ret = true;
//        } else {
//            //si x no esta ni antes del primero ni despues del ultimo
//            //RECORRER Y BUSCAR CUAL ES EL MAYOR
//            NodoLista nuevo = new NodoLista(n);
//            NodoLista aux = this.getInicio();
//            NodoLista siguienteAux = null;
//            //mientras que el siguiente del actual sea menor a x recorre
//            while (n.CompareTo(aux.getSig()) == -1) {
//                aux = aux.getSig();
//            }
//            //cuando sale el siguiente del actual es mayor a x
//            //se guarda el siguiente del actual
//            siguienteAux = aux.getSig();
//            //se asigna el siguiente del actual al nuevo nodo
//            aux.setSig(nuevo);
//            //el siguiente del nuevo nodo es el guardado
//            nuevo.setSig(siguienteAux);
//            ret = true;
//        }
        return ret;
    }

    public boolean buscarElemento(String n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getNombre() == n) {
                ret = true;
                return ret;
            }
            if (this.fin.getNombre() == n) {
                ret = true;
            } else {
                Biblioteca aux = this.getInicioB();
                while (aux.getSiguiente() != null) {
                    if (aux.getNombre() == n) {
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

    public boolean eliminarElemento(String n) {
        //si no es null
        if (!esVacia()) {
            if (n == getInicioB().getNombre()) {
                borrarInicio();
                return true;

            } else if (n == getFinB().getNombre()) {
                borrarFin();
                return true;

            } else {

                Biblioteca aux = this.obtenerElemento(n);

                if (aux.getSiguiente() != getFinB()) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    return true;
 
                }
            }

        }
        return false;
    }

    public int contarNodos(Biblioteca n) {
        return n.cantElementos();
    }
}
