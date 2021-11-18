/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class NodoCalificacion {
    //ESTO ES UNA COLA   
    //propiedades de calificacion
    private static int idUnica = 0;
    private int id;
    private int calificacion;
    private String comentario;
    private NodoCalificacion siguiente;

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoCalificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCalificacion siguiente) {
        this.siguiente = siguiente;
    }

    public static int getIdUnica() {
        return idUnica;
    }

    public static void setIdUnica(int idUnica) {
        NodoCalificacion.idUnica = idUnica;
    }

    public NodoCalificacion(int calificacion, String comentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.siguiente = null;
        this.id = idUnica++;
    }
    
}
