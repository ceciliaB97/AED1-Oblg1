
package Clases;


public class NodoLibro {

    private NodoLibro siguiente;
    //propiedades de libro
    private static int NumUnico = 0;
    private int numLibro;
    private String Titulo;
    private String Editorial;
    private int Ejemplares;

    public int getSumatoriaPuntosLibro() {
        return sumatoriaPuntosLibro;
    }

    public void setSumatoriaPuntosLibro(int sumatoriaPuntosLibro) {
        this.sumatoriaPuntosLibro += sumatoriaPuntosLibro;
    }

    public int getCantCalificacionesLibro() {
        return cantCalificacionesLibro;
    }

    public void setCantCalificacionesLibro() {
        this.cantCalificacionesLibro++;
    }
    private int sumatoriaPuntosLibro;
    private int cantCalificacionesLibro;
    private double califPromedio;
    private int cantSolicitudes;
    //listas de libro
    private ListaCalificaciones calificaciones;
    private ListaReservas reserva;
    private ListaReservas espera;

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
        this.cantSolicitudes = 0;

    }

    public int getCantSolicitudes() {

        //this.CantidadSolicitudes();
        return cantSolicitudes;
    }

    public void setCantSolicitudes(int cantSolicitudes) {
        this.cantSolicitudes = cantSolicitudes;
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

    public double getCalifPromedio() {
        return califPromedio;
    }

    public void setCalifPromedio() {
//

        this.califPromedio = (double) this.getSumatoriaPuntosLibro() / this.getCantCalificacionesLibro();

    }

    public boolean EliminarReserva(NodoReserva reserva, NodoLibro libro) {
        if (!libro.getReserva().esVacia()) {
            NodoReserva reservaBuscar = libro.getReserva().obtenerElemento(reserva.getCliente(), reserva.getNumero());
            if (reservaBuscar != null) {
                libro.getReserva().eliminarElemento(reserva.getCliente(), reserva.getNumero());
                return true;
            }
        }
        //buscar en lista de espera
        if (!libro.getEspera().esVacia()) {
            NodoReserva nuevo = libro.getEspera().getPrimero();
            libro.getReserva().agregarFinal(nuevo);
            libro.getEspera().eliminarElemento(nuevo.getCliente(), nuevo.getNumero());
            return true;
        }
        return false;
    }

}
