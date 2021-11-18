/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


public class NodoReserva {

    //ESTO ES UNA PILA
    private int cliente;
    private int numero;
    private String fecha;
    private NodoReserva siguiente;

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

    public NodoReserva getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoReserva siguiente) {
        this.siguiente = siguiente;
    }

    public NodoReserva(int cliente, int numero, String fecha) {
        this.cliente = cliente;
        this.numero = numero;
        this.fecha = fecha;
        this.siguiente = null;
    }
    
    
}
