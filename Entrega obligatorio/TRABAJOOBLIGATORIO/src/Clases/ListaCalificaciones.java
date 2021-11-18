package Clases;

public class ListaCalificaciones implements IListaCalificaciones{

    //propiedades de lista
    private NodoCalificacion inicio;
    private NodoCalificacion fin;
//    private ListaCalificaciones siguiente;
    private int actual;
    private int limite;
    //propiedades de calificacion
//    private int calificacion;
//    private String comentario;
//    private static int id;

    public NodoCalificacion getInicioC() {
        return inicio;
    }

    public void setInicio(NodoCalificacion inicio) {
        this.inicio = inicio;
    }

    public NodoCalificacion getFinC() {
        return fin;
    }

    public void setFin(NodoCalificacion fin) {
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

    public ListaCalificaciones(int l) {
        this.inicio = null;
        this.fin = null;
        this.limite = l;
        this.actual = 0;
    }

    //Metodos 
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }
    @Override
    public boolean agregarInicio(int calificacion, String comentario) {
        if (puedoInsertar()) {
            this.actual++;
            NodoCalificacion nuevo = new NodoCalificacion(calificacion, comentario);
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
    @Override
    public boolean agregarFinal(int calificacion, String comentario) {
        if (puedoInsertar()) {
            NodoCalificacion n = new NodoCalificacion(calificacion, comentario);
            this.actual++;
            //NodoLista nuevo= new NodoLista(n);
            if (this.esVacia()) {
                //se agrega el nodo al inicio
                this.setInicio(n);
                this.inicio = this.fin;
                return true;
            } else {
                //si no al final
                NodoCalificacion aux = this.inicio;
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
    @Override
    public boolean borrarFin() {
        this.actual--;
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoCalificacion aux = this.inicio;
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
    @Override
    public void mostrarREC() {        
        if (!this.esVacia()) {
           mostrarREC2(this.getInicioC(), 1);
        } else {
            System.out.println("La lista esta vacia");
        }        
    }
    @Override
    public void mostrarREC2(NodoCalificacion n, int cont
    ) {
        if (n.getSiguiente() == null) {
            System.out.println(cont + "- <" + n.getComentario() + ">");            
        } else {
            System.out.println(cont + "- <" + n.getComentario() + ">");            
            mostrarREC2(n.getSiguiente(), ++cont);
        }         
    }
    @Override
    public NodoCalificacion obtenerElementoAnterior(NodoCalificacion n) {
        if (!this.esVacia()) {
            if (this.inicio.getId() == n.getId()) {
                return null;
            } else {
                NodoCalificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.getSiguiente().getId() == n.getId()) {
                        return aux;
                    }
                    aux = aux.getSiguiente();
                }
            }
        }
        return null;
    }
    @Override
    public boolean eliminarElemento(NodoCalificacion n) {
        //si no es null
        if (!esVacia()) {
            if (this.inicio.getId() == n.getId()) {
                borrarInicio();
                return true;

            } else if (this.inicio.getId() == n.getId()) {
                borrarFin();
                return true;

            } else {

                NodoCalificacion aux = this.obtenerElementoAnterior(n);

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
            NodoCalificacion aux = this.inicio;
            while (aux != null) {
                aux = aux.getSiguiente();
                cont++;
            }
        }
        return cont;
    }
    @Override
    public NodoCalificacion obtenerElemento(NodoCalificacion n) {
        if (!this.esVacia()) {
            if (this.inicio.getId() == n.getId()) {
                return inicio;
            }
            if (this.fin.getId() == n.getId()) {
                return fin;
            } else {
                NodoCalificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.getId() == n.getId()) {
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
    @Override
    public boolean buscarElemento(NodoCalificacion n) {
        boolean ret = false;
        if (!this.esVacia()) {
            if (this.inicio.getId() == n.getId()) {
                ret = true;
                return ret;
            }
            if (this.fin.getId() == n.getId()) {
                ret = true;
            } else {
                NodoCalificacion aux = this.getInicioC();
                while (aux.getSiguiente() != null) {
                    if (aux.getId() == n.getId()) {
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
    @Override
    public int contarNodos(ListaCalificaciones n) {
        return n.cantElementos();
    }

}
