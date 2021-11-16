/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

public class NodoBiblioteca {

    //ESTO ES UNA LISTA
    private String nombre;
    private int CalificacionPromedioBiblioteca;
    private ListaLibros libros;
    NodoBiblioteca siguiente;

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

    //constructor
    public NodoBiblioteca(String Nombre) {
        this.nombre = Nombre;
        this.libros = new ListaLibros(0);
        this.siguiente = null;
        this.CalificacionPromedioBiblioteca = 0;
    }

    public int getCalificacionPromedioBiblioteca() {
        return CalificacionPromedioBiblioteca;
    }

    public void setCalificacionPromedioBiblioteca(int Calificacion) {
        this.CalificacionPromedioBiblioteca = Calificacion;
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

    public void PromedioGeneralLibros() {// promedio general de libros de la biblioteca
        if (!this.getLibros().esVacia()) {//La condicion falla inexplicablemente 
            for (NodoLibro i = this.getLibros().getInicioL(); i.getSiguiente() != null; i = i.getSiguiente()) {
                i.EstablecerPromedioCalificacionesDeUnLibro();// promedio calificaciones de cada libro
            }
        }
    }

   

    public int cantSolicitudesLibroPorBiblioteca(NodoLibro libro) {
        int cant = 0;
        NodoLibro lb = this.getLibros().obtenerElemento(libro.getTitulo(), libro.getEditorial());

        if (lb != null) {

            cant = lb.getCantSolicitudes();
        }
        return cant;
    }
    
     public void EstablecerPromedioCalificacionesDeUnaBiblioteca() {
        int promedio = 0;
        if (!this.getLibros().esVacia()) {
            int sumatoria = 0;
            int contador = 0;
            NodoLibro aux = this.getLibros().getInicioL();
            while (aux != null) {
                sumatoria += aux.getCalifPromedio();
                contador++;
                aux = aux.getSiguiente();
            }
            promedio = sumatoria / contador;
        }
        this.setCalificacionPromedioBiblioteca(promedio);
    }
    
    
}
