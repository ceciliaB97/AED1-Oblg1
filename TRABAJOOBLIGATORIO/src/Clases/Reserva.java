package Clases;

import Estructuras.Lista;

public class Reserva extends Lista {

    private int cliente;
    private int numero;
    private String fecha;
    private Reserva siguiente;
    private Reserva primero;
    private Reserva ultimo;
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
        this.primero = null;
        this.ultimo = null;
        this.actual = 0;
        this.limite = 0;
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

    //Metodos para sobrecarga 
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
            Reserva aux = this.primero;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }

    public boolean agregarFinal(Reserva n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.primero = n;
            } else {
                Reserva aux = this.primero;
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

    public boolean agregarInicio(Reserva n) {
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

    public Reserva obtenerElemento(Reserva n) {
        if (!this.esVacia()) {
            if (this.primero.numero == n.numero) {
                return primero;
            }
            if (this.ultimo.numero == n.numero) {
                return ultimo;
            } else {
                Reserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.numero == n.numero) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    public Reserva obtenerElementoAnterior(Reserva n) {
        if (!this.esVacia()) {
            if (this.primero.numero == n.numero) {
                return null;
            } else {
                Reserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().numero == n.numero) {
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
                Reserva aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.ultimo = aux;
                this.ultimo.setSiguiente(null);
            }
        }
        return true;
    }

    public boolean eliminarElemento(Reserva n) {
        //si no es null
        if (!esVacia()) {
            if (n.numero == getPrimero().numero) {
                borrarInicio();
                return true;

            } else if (n.numero == getUltimo().numero) {
                borrarFin();
                return true;

            } else {

                Reserva aux = this.obtenerElementoAnterior(n);

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

    public void mostrarREC2(Reserva n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.cliente + ">");

        } else {
            System.out.println(cont + "- <" + n.cliente + ">");
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
