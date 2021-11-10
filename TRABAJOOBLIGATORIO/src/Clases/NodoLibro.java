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
public class NodoLibro {
    //ESTO ES UNA LISTA
    private NodoLibro siguiente;
    //propiedades de libro
    private static int NumUnico = 0;
    private int numLibro;
    private String Titulo;
    private String Editorial;
    private int Ejemplares;
    //listas de libro
    private Calificacion calificacion;
    private Reserva reserva;
    private Reserva espera;

    public NodoLibro getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLibro siguiente) {
        this.siguiente = siguiente;
    }

    public int getNumUnico() {
        return NumUnico;
    }

    public static void setNumUnico(int numUnico) {
        NumUnico = numUnico;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getEjemplares() {
        return Ejemplares;
    }

    public void setEjemplares(int Ejemplares) {
        this.Ejemplares = Ejemplares;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getEspera() {
        return espera;
    }

    public void setEspera(Reserva espera) {
        this.espera = espera;
    }

    public int getNumLibro() {
        return numLibro;
    }

    public void setNumLibro(int numLibro) {
        this.numLibro = numLibro;
    }

    //constructor
    public NodoLibro(String Titulo, String Editorial, int Ejemplares) {
        this.numLibro = NumUnico++;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.Ejemplares = Ejemplares;        
    }

}
