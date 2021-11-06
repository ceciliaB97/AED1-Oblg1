
package Clases;
import Estructuras.Lista;


public class Reserva extends Lista {
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
    
    //Metodos para sobrecarga 
    
    
    public boolean esVacia() {
        return this.primero == null;
    }
    
    public boolean puedoInsertar() { //CONSULTAR NECESIDAD DE MÉTODO, SE REALIZA CON EJEMPLARES DE LIBRO
        return true; 
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
                Reserva nuevo = new Reserva(n.cliente, n.numero, n.fecha);
                aux.setSiguiente(nuevo);
                this.ultimo = nuevo;
                return true;
            }
        }
        return false;
    }
    
    public Reserva obtenerElemento(Reserva n) {
        if (!this.esVacia()) {
            if (this.primero.getDato() == n) {
                return primero;
            }
            if (this.ultimo.getDato() == n) {
                return ultimo;
            } else {
                Reserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getDato() == n) {
                        return aux;
                    }
                    aux = aux.getSig();
                }
            }
        }
        return null;
    }
    
    public boolean eliminarElemento(Reserva n) {
        //si no es null
        if (!esVacia()) {
            if (n == getPrimero()) {
                borrarInicio();
                return true;

            } else if (n == getUltimo()) {
                borrarFin();
                return true;

            } else {

                Reserva aux = this.obtenerElemento(n);

                if (aux.getSiguiente() != getUltimo()) {
                    aux.getSiguiente() = aux.getSiguiente().getSiguiente();
                    return true;

                }
            }

        }
        return false;
    }
    
     public void mostrarREC(Reserva l) {
        if (l != null) {
            System.out.println(l.getDato());
            mostrarREC(l.getSiguiente());
        }
    }
     
     public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (primero != null) {
            borrarInicio();
        }
    }
}
