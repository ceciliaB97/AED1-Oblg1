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
   
    private NodoLibro siguiente;
    //propiedades de libro
    private static int NumUnico = 0;
    private int numLibro;
    private String Titulo;
    private String Editorial;
    private int Ejemplares;
    //listas de libro
    private ListaCalificaciones calificaciones;
    private ListaReservas reserva;
    private ListaReservas espera;
    private int califPromedio;
    
    //constructor
    public NodoLibro(String Titulo, String Editorial, int Ejemplares) {
        this.numLibro = NumUnico++;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.Ejemplares = Ejemplares; 
        this.calificaciones = new ListaCalificaciones(0);
        this.reserva = new ListaReservas(Ejemplares);
        this.espera = new ListaReservas(0);
        this.califPromedio = 0;       
    }

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

    public ListaCalificaciones getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ListaCalificaciones calificaciones) {
        this.calificaciones = calificaciones;
    }

    public int getCalifPromedio() {
        return califPromedio;
    }

    public void setCalifPromedio(int califPromedio) {
        this.califPromedio = califPromedio;
    }
    
    public void EliminarReserva(NodoReserva r, NodoLibro l) {
        l.getReserva().eliminarElemento(r.getCliente(), r.getNumero());
        if (l.getEspera() != null) {
            NodoReserva espera = l.getEspera().getPrimero();
            l.getReserva().agregarFinal(espera);
            l.getEspera().eliminarElemento(espera.getCliente(), espera.getNumero());
        }
    }
    
       public void EstablecerPromedioCalificacionesDeUnLibro(){// obtenemos el promedio de calificaciones de un libro
        int promedio = 1; 
        int suma = 0;
        int contador = 0;
        if( this.getCalificaciones().getInicioC()!=null){
        for (NodoCalificacion i = this.getCalificaciones().getInicioC(); i.getSiguiente() != null; i = i.getSiguiente()) {
            
            
            suma = suma + i.getCalificacion();
            contador++;
        }
        promedio = suma/contador;
        this.setCalifPromedio(promedio);
        }
    }

}
