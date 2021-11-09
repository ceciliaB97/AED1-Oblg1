/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author cecil
 */
public class NodoBiblioteca {
    //ESTO ES UNA LISTA
    String nombre;
    private Libro libros;
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

    public Libro getLibros() {
        return libros;
    }

    public void setLibros(Libro libros) {
        this.libros = libros;
    }
    
    //constructor
    public NodoBiblioteca(String Nombre) {
        this.nombre = Nombre;
        this.libros = null;
        this.siguiente = null;
    }

}
