
package trabajoobligatorio;

class Libro {
    private int NumUnico;
    private String Titulo;
    private String Editorial;
    private int Ejemplares;
    private Calificacion calificacion;
    private Reserva reserva;
    private Reserva espera;
    //nodo libro

    public Libro(int NumUnico, String Titulo, String Editorial, int Ejemplares, Calificacion calificacion, Reserva reserva, Reserva espera) {
        this.NumUnico = NumUnico;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.Ejemplares = Ejemplares;
        this.calificacion = calificacion;
        this.reserva = null;
        this.espera = null;
    }

    public int getNumUnico() {
        return NumUnico;
    }

    public void setNumUnico(int NumUnico) {
        this.NumUnico = NumUnico;
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

}
