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
    private ListaCalificaciones calificacion;
    private ListaReservas reserva;
    private ListaReservas espera;

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

    public ListaCalificaciones getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(ListaCalificaciones calificacion) {
        this.calificacion = calificacion;
    }
    
   

    public ListaReservas getReserva() {
        return reserva;
    }

    public void setReserva(ListaReservas reserva) {
        this.reserva = reserva;
    }

    public ListaReservas getEspera() {
        return espera;
    }

    public void setEspera(ListaReservas espera) {
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
