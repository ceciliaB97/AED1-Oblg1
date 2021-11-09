package Clases;

import Estructuras.Lista;

public class Calificacion extends Lista {

    //propiedades de lista
    private Calificacion inicio;
    private Calificacion fin;
    private Calificacion siguiente;
    private int actual;
    private int limite;
    //propiedades de calificacion
    private int calificacion;
    private String comentario;
    private static int id;

    public Calificacion getInicioC() {
        return inicio;
    }

    public void setInicio(Calificacion inicio) {
        this.inicio = inicio;
    }

    public Calificacion getFinC() {
        return fin;
    }

    public void setFin(Calificacion fin) {
        this.fin = fin;
    }

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

    public Calificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Calificacion siguiente) {
        this.siguiente = siguiente;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calificacion(int calificacion, String comentario) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.inicio = null;
        this.fin = null;
        this.limite = 0;
        this.actual = 0;
        //identificador autonumerado de calificación
        this.id++;
    }
    
    
    //Metodos 
    
    public boolean esVacia() {
        return this.inicio == null;
    }
    
    
    public boolean agregarInicio(Calificacion nuevo) {
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
    
    
    public boolean agregarFinal(Calificacion n) {
        if (puedoInsertar()) {
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                this.inicio = n;
            } else {
                Calificacion aux = this.inicio;
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
    
    @Override
    public boolean borrarInicio() {
        if (!this.esVacia()) {
            this.actual--;
            this.inicio = this.inicio.getSiguiente();
            return true;
        }
        return false;
    }
    
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                Calificacion aux = this.inicio;
                while (aux.getSiguiente().getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                this.fin = aux;
                this.fin.setSiguiente(null);
            }
        }
        return true;
    }
    
    @Override
    public void vaciar() {
        this.actual = 0;
        //en java alcanza con apuntar inicio y fin a null
        //inicio=fin=null;
        while (inicio != null) {
            borrarInicio();
        }
    }
    
    public void mostrarREC() {
        if(!this.esVacia()){
            mostrarREC2(this.getInicio(), 1);
        } else {
            System.out.println("La lista no tiene bibliotecas");
        }        
    }
    
    public void mostrarREC2(Calificacion n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.comentario + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion

        } else {
            System.out.println(cont + "- <" + n.comentario + ">");
            //this.libros.mostrarREC(); - titulo editorial y calificacion
            mostrarREC2(n.getSiguiente(), ++cont);

        }
    }
    
    public Calificacion obtenerElementoAnterior(Calificacion n) {
        if (!this.esVacia()) {
            if (this.inicio.id == n.id) {
                return null;
            } else {
                Calificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().id == n.id) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    
    public boolean eliminarElemento(Calificacion n) {
        //si no es null
        if (!esVacia()) {
            if (this.inicio.id == n.id) {
                borrarInicio();
                return true;

            } else if (this.inicio.id == n.id) {
                borrarFin();
                return true;

            } else {

                Calificacion aux = this.obtenerElementoAnterior(n);

                if (aux != null) {
                    if (aux.getSiguiente() != getFinC()) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public int cantElementos() {
        int cont = 0;
        if (!this.esVacia()) {
            Calificacion aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }
    
    public Calificacion obtenerElemento(Calificacion n) {
        if (!this.esVacia()) {
            if (this.inicio.id == n.id) {
                return inicio;
            }
            if (this.fin.id == n.id) {
                return fin;
            } else {
                Calificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.id == n.id) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean puedoInsertar() {
        if (this.limite == 0) {
            return true;
        }
        return this.limite > this.actual;
    }
    
    public boolean buscarElemento(Calificacion n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.id == n.id) {
                ret = true;
                return ret;
            }
            if (this.fin.id == n.id) {
                ret = true;
            } else {
                Calificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.id == n.id) {
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

    public int contarNodos(Calificacion n) {
        return n.cantElementos();
    }
        
}
