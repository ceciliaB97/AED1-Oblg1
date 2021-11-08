package Clases;

import Estructuras.Lista;

public class Calificacion extends Lista {

    //propiedades de lista
    private Calificacion inicio;
    private Calificacion fin;
    private Calificacion siguiente;
    private int actual;
    private int limite;
    //propiedades de calificacion
    private int calificacion;
    private String comentario;

    public Calificacion getInicioC() {
        return inicio;
    }

    public void setInicio(Calificacion inicio) {
        this.inicio = inicio;
    }

    public Calificacion getFinC() {
        return fin;
    }

    public void setFin(Calificacion fin) {
        this.fin = fin;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public Calificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Calificacion siguiente) {
        this.siguiente = siguiente;
    }

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

    public Calificacion(int calificacion, String comentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.inicio = null;
        this.fin = null;
        this.limite = 0;
        this.actual = 0;
    }

}
