package Estructuras;

public class Lista implements ILista {

    private NodoLista inicio;
    private NodoLista fin;
    private int limite;
    private int actual;

    //Constructor
    @Override
    public void Lista() {
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = 0;
    }

    //Inicio
    public void setInicio(NodoLista i) {
        inicio = i;
    }

    public NodoLista getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoLista f) {
        fin = f;
    }

    public NodoLista getFin() {
        return fin;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    @Override
    public boolean agregarInicio(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            NodoLista nuevo = new NodoLista(n);
            nuevo.setSig(inicio);
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
    @Override
    public boolean agregarFinal(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.agregarInicio(n);
            } else {
                NodoLista aux = this.inicio;
                while (aux.getSig() != null) {
                    aux = aux.getSig();
                }
                NodoLista nuevo = new NodoLista(n);
                aux.setSig(nuevo);
                this.fin = nuevo;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    public boolean borrarInicio() {
        this.actual--;
        if (!this.esVacia()) {
            this.inicio = this.inicio.getSig();
        }
        return true;
    }

    //PRE:
    //POS: Borra el último nodo
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoLista aux = this.inicio;
                while (aux.getSig().getSig() != null) {
                    aux = aux.getSig();
                }
                this.fin = aux;
                this.fin.setSig(null);
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
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("Lista es vacía");
        } else {
            NodoLista aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getSig();
            }
        }
    }

    /**
     * ***Otros Métodos (iterativos)****
     */
    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public boolean agregarOrd(TDato n) {
        if (puedoInsertar()) {
            this.actual++;
            //lista vacía o primer elemento es mayor o igual => agrego al ppio
            if (this.esVacia() || this.inicio.getDato().CompareTo(n.getO()) == 1) {
                this.agregarInicio(n);
                return true;
            }
            //último elemento es menor o igual => agrego al final
            if (this.fin.getDato().CompareTo(n.getO()) == -1) {
                this.agregarFinal(n);
                return true;
            }
            NodoLista aux = this.inicio;
            while (aux.getSig() != null && aux.getSig().getDato().CompareTo(n.getO()) == 1) {
                aux = aux.getSig();
            }
            NodoLista nuevo = new NodoLista(n);
            nuevo.setSig(aux.getSig());
            aux.setSig(nuevo);
            return true;
        }
        return false;
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean borrarElemento(Object n) {
        this.actual--;
        if (this.esVacia()) {
            return true;
        }
        if (this.inicio.getDato() == n) {
            this.borrarInicio();
        } else {
            NodoLista aux = this.inicio;
            while (aux.getSig() != null && aux.getSig().getDato() != n) {
                aux = aux.getSig();
            }
            //lo encontré o llegué al final de la lista
            if (aux.getSig() != null) {
                NodoLista borrar = aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
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
            NodoLista aux = this.inicio;
            while (aux != null) {
                aux = aux.getSig();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public NodoLista obtenerElemento(Object n) {
        NodoLista aux = this.inicio;
        while (aux != null && aux.getDato() != n) {
            aux = aux.getSig();
        }
        //encontré dato o llegué al final
        return aux;
    }

    /**
     * *** Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoLista l) {
        if (l != null) {
            System.out.println(l.getDato());
            mostrarREC(l.getSig());
        }
    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoLista l) {
        if (l != null) {
            mostrarInversoREC(l.getSig());
            System.out.println(l.getDato());
        }
    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoLista l, Object n) {
        if (l != null) {
            if (l.getDato().CompareTo(n) == 0) {
                return true;
            } else {
                return existeDatoREC(l.getSig(), n);
            }
        } else {
            return false;
        }
    }

    //PRE: Posicion de la lista
    //POS: Object en posicion i.
    public TDato datoEnPos(int i) {
        int contador = 0;
        if (i == 0) {
            return this.inicio.getDato();
        }
        NodoLista ptr = this.inicio;
        while (contador < i) {
            ptr = ptr.getSig();
            contador++;
        }
        return ptr.getDato();
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

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }

    /**
     * @return the actual
     */
    public int getActual() {
        return actual;
    }

    /**
     * @param actual the actual to set
     */
    public void setActual(int actual) {
        this.actual = actual;
    }

    //CORREGIR Y CORROBORAR EL COMPARE TO
    @Override
    public boolean agregarOrdenado(TDato n) {
        boolean ret = false;
        //si esta vacia o si el primero es mayor a x
        if (this.esVacia() || n.CompareTo(inicio) == -1) {
            //se agrega al inicio
            this.agregarInicio(n);
            ret = true;
            //si el ultimo valor es menor a x
        } else if (n.CompareTo(inicio) == 1) {
            //se agrega al final
            this.agregarFinal(n);
            ret = true;
        } else {
            //si x no esta ni antes del primero ni despues del ultimo
            //RECORRER Y BUSCAR CUAL ES EL MAYOR
            NodoLista nuevo = new NodoLista(n);
            NodoLista aux = this.getInicio();
            NodoLista siguienteAux = null;
            //mientras que el siguiente del actual sea menor a x recorre
            while (n.CompareTo(aux.getSig()) == -1) {
                aux = aux.getSig();
            }
            //cuando sale el siguiente del actual es mayor a x
            //se guarda el siguiente del actual
            siguienteAux = aux.getSig();
            //se asigna el siguiente del actual al nuevo nodo
            aux.setSig(nuevo);
            //el siguiente del nuevo nodo es el guardado
            nuevo.setSig(siguienteAux);
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean buscarElemento(TDato n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getDato() == n) {
                ret = true;
                return ret;
            }
            if (this.fin.getDato() == n) {
                ret = true;
            } else {
                NodoLista aux = this.getInicio();
                while (aux.getSig() != null) {
                    if (aux.getDato() == n) {
                        ret = true;
                        return ret;
                    }
                    aux = aux.getSig();
                }
            }
        } else {
            ret = false;
        }
        return ret;
    }

    @Override
    public NodoLista obtenerElemento(TDato n) {
        if (!this.esVacia()) {
            if (this.inicio.getDato() == n) {
                return inicio;
            }
            if (this.fin.getDato() == n) {
                return fin;
            } else {
                NodoLista aux = this.getInicio();
                while (aux.getSig() != null) {
                    if (aux.getDato() == n) {
                        return aux;
                    }
                    aux = aux.getSig();
                }
            }
        }
        return null;
    }

    @Override
    public boolean eliminarElemento(TDato n) {
        //si no es null
        if (!esVacia()) {
            if (n == getInicio().getDato()) {
                borrarInicio();
                return true;

            } else if (n == getFin().getDato()) {
                borrarFin();
                return true;

            } else {

                NodoLista aux = this.obtenerElemento(n);

                if (aux.getSig() != getFin()) {
                    aux.getSig() = aux.getSig().getSig();
                    return true;

                }
            }

        }
        return false;
    }

    @Override
    public int contarNodos(TDato n) {
        return this.cantElementos();
    }
}
