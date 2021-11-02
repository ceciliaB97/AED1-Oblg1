
package Clases;

import Estructuras.Lista;


public class Biblioteca extends Lista {
    private String nombre;
    private Libro libros;
    private Biblioteca siguiente;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = null;
        this.siguiente = null;
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
    
}
