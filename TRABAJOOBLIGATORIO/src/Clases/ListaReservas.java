package Clases;

public class ListaReservas implements IListaReservas{

//    private int cliente;
//    private int numero;
//    private String fecha;
//    private ListaReservas siguiente;
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

    public ListaReservas(int limiteAceptado) {
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

    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }

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
                this.ultimo = n;
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

    public NodoReserva obtenerElemento(int cliente, int numero) {
        if (!this.esVacia()) {
            if (this.primero.getNumero() == numero && this.primero.getCliente() == numero) {
                return primero;
            }
            if (this.ultimo.getNumero() == numero && this.ultimo.getCliente() == cliente) {
                return ultimo;
            } else {
                NodoReserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getNumero() == numero && aux.getCliente() == cliente) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }

    public NodoReserva obtenerElementoAnterior(int cliente, int numero) {
        if (!this.esVacia()) {
            if (this.primero.getNumero() == numero && this.primero.getCliente() == cliente) {
                return null;
            } else {
                NodoReserva aux = this.getPrimero();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getNumero() == numero && aux.getCliente() == cliente) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    
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

    public boolean eliminarElemento(int cliente, int numero) {
        //si no es null
        if (!esVacia()) {
            if (numero == getPrimero().getNumero() && cliente == getPrimero().getCliente()) {
                borrarInicio();
                return true;

            } else if (numero == getUltimo().getNumero() && cliente == getUltimo().getCliente()) {
                borrarFin();
                return true;

            } else {

                NodoReserva aux = this.obtenerElementoAnterior(cliente, numero);

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
            System.out.println("No existen reservas pendientes");
        }  
    }

    public void mostrarREC2(NodoReserva n, int cont) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getCliente() + ">");

        } else {
            System.out.println(cont + "- <" + n.getCliente() + ">");
            mostrarREC2(n.getSiguiente(), ++cont);

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
