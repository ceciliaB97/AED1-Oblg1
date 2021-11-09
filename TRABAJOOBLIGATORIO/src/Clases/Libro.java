package Clases;

import Estructuras.Lista;

public class Libro extends Lista {

    private Libro inicio;
    private Libro fin;
    private Libro siguiente;
    private int limite;
    private int actual;
    //propiedades de libro
    private int NumUnico;
    private String Titulo;
    private String Editorial;
    private int Ejemplares;
    //listas de libro
    private Calificacion calificacion;
    private Reserva reserva;
    private Reserva espera;
    //nodo libro

    public Libro(int NumUnico, String Titulo, String Editorial, int Ejemplares) {
        this.NumUnico = NumUnico;
        this.Titulo = Titulo;
        this.Editorial = Editorial;
        this.Ejemplares = Ejemplares;
        this.calificacion = null;
        this.reserva = null;
        this.espera = null;
        this.inicio = null;
        this.fin = null;
        this.limite = 0;
        this.actual = 0;
    }

    @Override
    public int getLimite() {
        return limite;
    }

    @Override
    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getActual() {
        return actual;
    }

    @Override
    public void setActual(int actual) {
        this.actual = actual;
    }

    public Libro getInicioL() {
        return inicio;
    }

    public void setInicio(Libro inicio) {
        this.inicio = inicio;
    }

    public Libro getFinL() {
        return fin;
    }

    public void setFin(Libro fin) {
        this.fin = fin;
    }

    public Libro getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Libro siguiente) {
        this.siguiente = siguiente;
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

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(Libro nuevo) {
        if (puedoInsertar()) {
            this.actual++;
            nuevo.setSiguiente(this.inicio);
            this.inicio = nuevo;
            if (this.fin == null)//estoy insertando el primer nodo
            {
                this.fin = nuevo;
            }
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(Libro n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
            } else {
                Libro aux = this.inicio;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(n);
                this.fin = n;
                return true;
            }
        }
        return false;
    }

    //PRE:
    //POS: Borra el primer nodo
    @Override
    public boolean borrarInicio() {
        if (!this.esVacia()) {
            this.actual--;
            this.inicio = this.inicio.getSiguiente();
            return true;
        }
        return false;
    }

    //PRE:
    //POS: Borra el último nodo
    @Override
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                Libro aux = this.inicio;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.fin = aux;
                this.fin.setSiguiente(null);
            }
        }
        return true;
    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio != null) {
            borrarInicio();
        }
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC() {
        if (!this.esVacia()) {
            mostrarREC2(this.getInicioL(), 1);
        } else {
            System.out.println("La lista no tiene bibliotecas");
        }

    }

    public void mostrarREC2(Libro n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.Titulo + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion

        } else {
            System.out.println(cont + "- <" + n.Titulo + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion
            mostrarREC2(n.getSiguiente(), ++cont);

        }
    }

    public Libro obtenerElementoAnterior(Libro n) {
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(n.getTitulo())) {
                return null;
            } else {
                Libro aux = this.getInicioL();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getTitulo().equals(n.getTitulo())) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(Libro n) {
        //si no es null
        if (!esVacia()) {
            if (n.getTitulo().equals(getInicioL().getTitulo())) {
                borrarInicio();
                return true;

            } else if (n.getTitulo().equals(getFinL().getTitulo())) {
                borrarFin();
                return true;

            } else {

                Libro aux = this.obtenerElementoAnterior(n);

                if (aux != null) {
                    if (aux.getSiguiente() != getFinL()) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    @Override
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            Libro aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    //PRE: //POS:
    public Libro obtenerElemento(Libro n) {
        if (!this.esVacia()) {
            if(this.inicio.getTitulo().equals(n.getTitulo())&& this.inicio.getEditorial().equals(n.getEditorial())) {
                return inicio;
            }
            if (this.fin.getTitulo().equals(n.getTitulo())&& this.fin.getEditorial().equals(n.getEditorial())) {
                return fin;
            } else {
                Libro aux = this.getInicioL();
                while (aux.getSiguiente() != null) {
                    if (aux.getTitulo().equals(n.getTitulo())) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    /**
     * Si actual < a limite, inserto //PRE: -- //POS: True si actualmente no
     * paso el limite de la lista. @return T/F
     */
    @Override
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

    public boolean buscarElemento(Libro n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getTitulo().equals(n.getTitulo())) {
                ret = true;
                return ret;
            }
            if (this.fin.getTitulo().equals(n.getTitulo())) {
                ret = true;
            } else {
                Libro aux = this.getInicioL();
                while (aux.getSiguiente() != null) {
                    if (aux.getTitulo().equals(n.getTitulo())) {
                        ret = true;
                        return ret;
                    }
                    aux = aux.getSiguiente();
                }
            }
        } else {
            ret = false;
        }
        return ret;
    }

    public int contarNodos(Libro n) {
        return n.cantElementos();
    }

}
