
package Clases;


public interface IListaReservas {
    
    //PRE: La lista debe existir 
    //POS: Retorna verdadero o falso si tiene la cantidad limite de elementos 
    public boolean esLLena();
    //PRE: La lista debe existir 
    //POS: Retorna verdadero o falso si tiene o no elementos 
    public boolean esVacia();
    //PRE: 
    //POS: Retorna si se puede o no insertar un elemento dependiendo del limite 
    public boolean puedoInsertar();
    //PRE: La instancia debe tener un elemento cantidad
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: Recibe una nueva instancia
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoReserva n);
    //PRE: //PRE: Recibe una nueva instancia  
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoReserva n);
    //PRE: Recibe un cliente y un numero de reserva
    //POS: Retorna el elemento buscado o null 
    public NodoReserva obtenerElemento(int cliente, int numero);
    //PRE: Recibe un cliente y un numero de reserva
    //POS: Retorna el elemento buscado o null 
    public NodoReserva obtenerElementoAnterior(int cliente, int numero);
    //PRE: La lista debe existir 
    //POS: Borra el último nodo
    public boolean borrarFin();
    //PRE: La lista debe existir 
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(int cliente, int numero);
    //PRE: La lista debe existir 
    //POS: Borra el primer nodo
    public boolean borrarInicio();
    //PRE: La lista debe existir 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC();
    //PRE: Recibe un nodo y un contador 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC2(NodoReserva n, int cont);
    //PRE: La lista debe existir 
    //POS: elimina todos los nodos de una lista dada 
    public void vaciar();    
}
