
package Clases;

public class Calificacion {
    private int calificacion;
    private String comentario;
    private Calificacion siguiente;

    public Calificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Calificacion siguiente) {
        this.siguiente = siguiente;
    }

    public Calificacion(int calificacion, String comentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
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
 
}
