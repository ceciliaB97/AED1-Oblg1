package Clases;

public class ListaBibliotecas implements IListaBibliotecas {

//    atributos de lista<biblioteca>
    private NodoBiblioteca inicio;
    private NodoBiblioteca fin;
    //limite actual
    private int actual;
    private int limite;
    //atributos de biblioteca
    private ListaLibros libros;

    public ListaBibliotecas(int limite) {
        this.inicio = null;
        this.fin = null;
        this.actual = 0;
        this.limite = limite;
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

    public int getActual() {
        return actual;
    }

    public void setActual(int Actual) {
        this.actual = Actual;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
        @Override
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
        @Override
    public boolean agregarFinal(NodoBiblioteca n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
                this.fin = n;
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
    //POS: Borra el ??ltimo nodo
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
        @Override
    public void mostrarREC() {
        if (!this.esVacia()) {
            mostrarREC2(this.getInicioB(), 1);
        } else {
            System.out.println("No hay elementos");
        }
    }
    @Override
    public void mostrarREC2(NodoBiblioteca n, int cont
    ) {
        
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getNombre() + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion

        } else {
            System.out.println(cont + "- <" + n.getNombre() + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion
            mostrarREC2(n.getSiguiente(), ++cont);

        }
       
    }
    @Override
    public void mostrarRECLibro(NodoBiblioteca b) {
        
        System.out.println("Libros de la biblioteca: " + b.getNombre());
        if(!b.getLibros().esVacia()){
        b.getLibros().mostrarREC();
         }else{
            System.out.println(" No tiene Libros");
        }
    }
    @Override
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
        @Override
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
        @Override
    public NodoBiblioteca obtenerElemento(String n) {
        if (!this.esVacia()) {
            if (this.inicio.getNombre().equals(n)) {
                return inicio;
            }
            if (this.fin.getNombre().equals(n)) {
                return fin;
            } else {
                NodoBiblioteca aux = this.getInicioB();
                while (aux != null) {
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
    @Override
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
    @Override
    public int contarNodos(ListaBibliotecas n) {
        return n.cantElementos();
    }
    @Override
    public void OrdenarLibrosPorCalifPromedioUnaBiblioteca(NodoBiblioteca b) {
        if (!b.getLibros().esVacia()) {
            b.getLibros().bubbleSortCalificacion();
        }
    }
    @Override
    public void OrdenarPorPromedioBiblioteca() {        
        if (this.cantElementos() > 1){             
            boolean cambio;
            do {
                NodoBiblioteca actualB = this.getInicioB();
                NodoBiblioteca anterior = null;
                NodoBiblioteca siguiente = this.getInicioB().getSiguiente();
                cambio = false;
                while (siguiente != null) {
                    if (actualB.getCalificacionPromedioBiblioteca() < siguiente.getCalificacionPromedioBiblioteca()) {
                        cambio = true;
                        if (anterior != null) {
                            NodoBiblioteca sig = siguiente.getSiguiente();
                            anterior.setSiguiente(siguiente);
                            siguiente.setSiguiente(actualB);
                            actualB.setSiguiente(sig);
                        } else {
                            NodoBiblioteca sig = siguiente.getSiguiente();
                            this.setPrimero(siguiente);
                            siguiente.setSiguiente(actualB);
                            actualB.setSiguiente(sig);
                        }
                        anterior = siguiente;
                        siguiente = actualB.getSiguiente();
                    } else {
                        anterior = actualB;
                        actualB = siguiente;
                        siguiente = siguiente.getSiguiente();
                    }
                }
            } while (cambio);
        }
    }
    @Override
    public ListaLibros LibrosMasSolicitados() {

        ListaLibros listaNueva = new ListaLibros(0);
        NodoBiblioteca aux = this.getInicioB();
        while (aux != null) {
            if (!aux.getLibros().esVacia()) {
                for (NodoLibro i = aux.getLibros().getInicioL(); i != null; i = i.getSiguiente()) {
                    if (!listaNueva.buscarElemento(i)) {// si no esta en la lista nueva lo agrego
                        NodoLibro auxL = new NodoLibro(i.getTitulo(), i.getEditorial(), i.getEjemplares());
                        auxL.setCantSolicitudes(i.getCantSolicitudes());
                        listaNueva.agregarInicio(auxL);
                    } else {
                        NodoLibro auxElemento =  listaNueva.obtenerElemento(i.getTitulo(), i.getEditorial());
                        auxElemento.setCantSolicitudes(i.getCantSolicitudes() + auxElemento.getCantSolicitudes());
                    }
                }
                aux = aux.getSiguiente();
            }

        }

        listaNueva.bubbleSort();

        return listaNueva;
    }

}
