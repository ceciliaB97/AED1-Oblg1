
package Clases;

import Estructuras.Lista;

class Reserva extends Lista {
    private int cliente;
    private int numero;
    private String fecha;
    private Reserva siguiente;
    private Reserva primero;
    private Reserva ultimo;

    public Reserva getPrimero() {
        return primero;
    }

    public void setPrimero(Reserva primero) {
        this.primero = primero;
    }

    public Reserva getUltimo() {
        return ultimo;
    }

    public void setUltimo(Reserva ultimo) {
        this.ultimo = ultimo;
    }
    
    public Reserva(int cliente, int numero, String fecha) {
        this.cliente = cliente;
        this.numero = numero;
        this.fecha = fecha;
    }

    public Reserva getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Reserva reserva) {
        this.siguiente = reserva;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 
}
