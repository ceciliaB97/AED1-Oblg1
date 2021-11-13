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

    public void PromedioGeneralLibros() {// promedio general de libros de la biblioteca

        if (!this.getLibros().esVacia()) {//La condicion falla inexplicablemente 
            for (NodoLibro i = this.getLibros().getInicioL(); i.getSiguiente() != null; i = i.getSiguiente()) {
                i.EstablecerPromedioCalificacionesDeUnLibro();// promedio calificaciones de cada libro
            }
        }
    }
}


