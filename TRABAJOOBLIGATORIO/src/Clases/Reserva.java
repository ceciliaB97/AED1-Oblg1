package Clases;

import Estructuras.Lista;

public class Reserva extends Lista {

//    private int cliente;
//    private int numero;
//    private String fecha;
//    private Reserva siguiente;
    private NodoReserva primero;
    private NodoReserva ultimo;
    private int actual;
    private int limite;

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

    public NodoReserva getPrimero() {
        return primero;
    }

    public void setPrimero(NodoReserva primero) {
        this.primero = primero;
    }

    public NodoReserva getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoReserva ultimo) {
        this.ultimo = ultimo;
    }

    public Reserva(int limiteAceptado) {
        this.primero = null;
        this.ultimo = null;
        this.actual = 0;
        this.limite = limiteAceptado;
    }

    //Metodos para sobrecarga 
    
    public boolean esLLena(){
         return this.actual == limite;
    }
    
    public boolean esVacia() {
        return this.primero == null;
    }

    @Override
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

    @Override
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            NodoReserva aux = this.primero;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    public boolean agregarFinal(NodoReserva n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.primero = n;
            } else {
                NodoReserva aux = this.primero;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(n);
                this.ultimo = n;
                return true;
            }
        }
        return false;
    }

    public boolean agregarInicio(NodoReserva n) {
        if (puedoInsertar()) {
            this.actual++;
            n.setSiguiente(this.primero);
            this.primero = n;
            if (this.ultimo == null)//estoy insertando el primer nodo
            {
                this.ultimo = n;
            }
            return true;
        }
        return false;
    }

    public NodoReserva obtenerElemento(NodoReserva n) {
        if (!this.esVacia()) {
            if (this.primero.getNumero() == n.getNumero()) {
                return primero;
            }
            if (this.ultimo.getNumero() == n.getNumero()) {
                return ultimo;
            } else {
                NodoReserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getNumero() == n.getNumero()) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    public NodoReserva obtenerElementoAnterior(NodoReserva n) {
        if (!this.esVacia()) {
            if (this.primero.getNumero() == n.getNumero()) {
                return null;
            } else {
                NodoReserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getNumero() == n.getNumero()) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.primero == this.ultimo) {
                this.borrarInicio();
            } else {
                NodoReserva aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.ultimo = aux;
                this.ultimo.setSiguiente(null);
            }
        }
        return true;
    }

    public boolean eliminarElemento(NodoReserva n) {
        //si no es null
        if (!esVacia()) {
            if (n.getNumero() == getPrimero().getNumero()) {
                borrarInicio();
                return true;

            } else if (n.getNumero() == getUltimo().getNumero()) {
                borrarFin();
                return true;

            } else {

                NodoReserva aux = this.obtenerElementoAnterior(n);

                if (aux != null) {
                    if (aux.getSiguiente() != getUltimo()) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean borrarInicio() {
        if (!this.esVacia()) {
            this.primero = this.primero.getSiguiente();
            this.actual--;
        }
        return true;
    }

    public void mostrarREC() {
        if(!this.esVacia()){
           mostrarREC2(this.getPrimero(), 1); 
        }else{
            System.out.println("No hay reservas en la lista");
        }  
    }

    public void mostrarREC2(NodoReserva n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getCliente() + ">");

        } else {
            System.out.println(cont + "- <" + n.getCliente() + ">");
            mostrarREC2(n.getSiguiente(), ++cont);

        }
    }

    @Override
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (primero != null) {
            borrarInicio();
        }
    }
}
