package Clases;

public class NodoBiblioteca {

  
    private String nombre;
    private double CalificacionPromedioBiblioteca;
    private int totalPuntos;
    private int cantCalificaciones;
    private ListaLibros libros;
    NodoBiblioteca siguiente;

    public int getTotalPuntos() {
        return this.totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos += totalPuntos;
    }

    public int getCantCalificaciones() {
        return this.cantCalificaciones;
    }

    public void setCantCalificaciones() {
        this.cantCalificaciones ++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public NodoBiblioteca getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBiblioteca siguiente) {
        this.siguiente = siguiente;
    }

    public ListaLibros getLibros() {
        return libros;
    }

    public void setLibros(ListaLibros libros) {
        this.libros = libros;
    }

    public double getCalificacionPromedioBiblioteca() {

        return this.CalificacionPromedioBiblioteca;
    }

    public void setCalificacionPromedioBiblioteca() {

     CalificacionPromedioBiblioteca = (double)this.getTotalPuntos()/ this.getCantCalificaciones();

    }

    //constructor
    public NodoBiblioteca(String Nombre) {
        this.nombre = Nombre;
        this.libros = new ListaLibros(0);
        this.siguiente = null;
        this.CalificacionPromedioBiblioteca = 0;
    }

    public boolean tieneReservas() {
        boolean encontre = false;
        ListaLibros lista = this.getLibros();
        if (!lista.esVacia()) {
            NodoLibro aux = lista.getInicioL();
            while (aux.getSiguiente() != null && !encontre) {
                if (!aux.getReserva().esVacia()) {
                    encontre = true;
                }
                aux = aux.getSiguiente();
            }
        }
        return encontre;
    }


    public int cantSolicitudesLibroPorBiblioteca(NodoLibro libro) {
        int cant = 0;
        NodoLibro lb = this.getLibros().obtenerElemento(libro.getTitulo(), libro.getEditorial());

        if (lb != null) {

            cant = lb.getCantSolicitudes();
        }
        return cant;
    }


}