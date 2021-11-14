package Clases;

public class ListaBibliotecas {

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
            mostrarREC2(this.getInicioB(), 1);
        } else {
            System.out.println("No hay elementos");
        }
    }

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

    public void mostrarRECLibro(NodoBiblioteca b) {
        System.out.println("Libros de la biblioteca: " + b.getNombre());
        b.getLibros().mostrarREC();
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

    public void OrdenarLibrosPorCalifPromedioUnaBiblioteca(NodoBiblioteca b) {
        if (!b.getLibros().esVacia()) {
            for (NodoLibro i = b.getLibros().getInicioL(); i != null; i = i.getSiguiente()) {
                for (NodoLibro j = i; j != null; j = j.getSiguiente()) {
                    //calificacion promedio
                    if (i.getCalifPromedio() < j.getCalifPromedio()) {
                        NodoLibro aux = j.getSiguiente();
                        NodoLibro auxi = i;
                        b.getLibros().eliminarElemento(i);
                        j.setSiguiente(auxi);
                        i.setSiguiente(aux);
                    }
                }
            }
        }
    }

    public void OrdenarLibrosPorCantidadSolicitudes(NodoBiblioteca b) {
        if (!b.getLibros().esVacia()) {
            for (NodoLibro i = b.getLibros().getInicioL(); i != null; i = i.getSiguiente()) {
                for (NodoLibro j = i; j != null; j = j.getSiguiente()) {
                    //cantidad de solicitudes
                    if (i.CantidadSolicitudes() < j.CantidadSolicitudes()) {
                        NodoLibro aux = j.getSiguiente();
                        NodoLibro auxi = i;
                        b.getLibros().eliminarElemento(i);
                        j.setSiguiente(auxi);
                        i.setSiguiente(aux);
                    }
                }
            }
        }
    }

    public ListaLibros LibrosMayorRanKing() {
     
        ListaLibros listaNueva = new ListaLibros(0);
        NodoBiblioteca aux = this.getInicioB();
        while (aux != null) {

            if (!aux.getLibros().esVacia()) {
                for (NodoLibro i = aux.getLibros().getInicioL(); i != null; i = i.getSiguiente()) {
                    NodoLibro lb = listaNueva.obtenerElemento(i.getTitulo(), i.getEditorial());

                    if (lb == null) {
                        listaNueva.agregarInicio(aux.getLibros().getInicioL());
                    } else {
                        lb.setCantSolicitudes(lb.getCantSolicitudes()+i.getCantSolicitudes());

                    }
                }
          
            }
            aux = aux.getSiguiente();
        }

        return listaNueva;
    }

//
//    public boolean OrdenarLibrosPorCantidadSolicitudes(NodoBiblioteca b) {
//        if (!b.getLibros().esVacia()) {
//            ListaLibros lista = b.getLibros();
//            //busco el libro con la maxima calificacion promedio, sin saber cual es el maximo primero
//            //con esto ya tengo el maxim absoluto de la lista de libros
//            NodoLibro pmax = buscoposmax(lista.getInicioL(), Integer.MIN_VALUE, Integer.MAX_VALUE);
//            int calificacionMaximo = pmax.getCalifPromedio();
//            pmax = buscoposmax(lista.getInicioL().getSiguiente(),Integer.MIN_VALUE, calificacionMaximo);
//            NodoLibro iteracion = lista.getInicioL();
//            while (iteracion.getSiguiente() != null) {
//                //agrego al inicio el maximo
//                lista.agregarInicio(pmax);
//                //elimino el nodo repetido, porque el maximo lo agregué al inicio
//                //lista.getInicioL().getSiguiente() significa que busco desde el inicio + 1 nodo
//                lista.eliminarElementoDesdeNodo(pmax, lista.getInicioL().getSiguiente());
//                //buscar el maximo que sea menor al maximo anerior de la lista
//                //y mayor a integer.min_value
//                pmax = buscoposmax(lista.getInicioL().getSiguiente(),Integer.MIN_VALUE, calificacionMaximo);
//                //recorro esto por el numero de nodos que haya, y le resto cuando ya hace una iteracion
//                //al llegar a 0 se sale
//                iteracion = iteracion.getSiguiente();
//            }
//        }
//        return false;
//    }
//    //metodo auxiliar
//    public NodoLibro buscoposmax(NodoLibro nodoLibro, int maximo, int hasta) {
//        int valorMaximo = maximo; //integer.min_value
//        NodoLibro aux = nodoLibro; //nodo auxiliar de iteracion a comparar
//        NodoLibro devolucion = null; //nodo de retorno del metodo
//        while (aux.getSiguiente() != null) {
//            //todos los que sean mayor al maximo [INTEGER.MIN_VALUE], se guarda el nodo con el valor mas grande
//            //y que sean menor al maximo anterior, pasado por parametro en hasta
//            if (aux.getCalifPromedio() > valorMaximo && aux.getCalifPromedio() < hasta) {
//                valorMaximo = aux.getCalifPromedio();
//                devolucion = aux;
//            }
//            aux = aux.getSiguiente();
//        }
//        return devolucion;
//
//    }
    // agregar todos los libros de todas las bibliotecas a una lista nueva metodo de lista  bibliotecaa sin ser repetidos
    // vamos actualizando en ese metodo el atributo catnidad de reserva
}
