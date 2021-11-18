
package Clases;


public interface IListaCalificaciones {
    
    //PRE: La lista debe existir 
    //POS: elimina todos los nodos de una lista dada 
    public boolean esVacia();
    //PRE: Recibe una nueva instancia  
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(int calificacion, String comentario);
    //PRE: Recibe una nueva instancia
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(int calificacion, String comentario);
    //PRE: La lista debe existir 
    //POS: Borra el primer nodo
    public boolean borrarInicio();
    //PRE: La lista debe existir 
    //POS: Borra el último nodo
    public boolean borrarFin();
    //PRE: La lista debe existir 
    //POS: Retorna verdadero o falso si tiene o no elementos
    public void vaciar();
    //PRE: La lista debe existir 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC();
    //PRE: Recibe un nodo y un contador 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC2(NodoCalificacion n, int cont);
    //PRE: Recibe un nodo
    //POS: Retorna el elemento buscado o null 
    public NodoCalificacion obtenerElementoAnterior(NodoCalificacion n);
    //PRE: La lista debe existir 
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(NodoCalificacion n);
    //PRE: La instancia debe tener un elemento cantidad
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: Recibe un nodo
    //POS: Retorna el elemento buscado o null 
    public NodoCalificacion obtenerElemento(NodoCalificacion n);
    //PRE: 
    //POS: Retorna si se puede o no insertar un elemento dependiendo del limite 
    public boolean puedoInsertar();
    //PRE: Recibe un nodo
    //POS: Retorna verdadero o falso si existe o no el elemento
    public boolean buscarElemento(NodoCalificacion n);
    //PRE: Recibe una lista 
    //POS: Retorna la cantidad de elementos
    public int contarNodos(ListaCalificaciones n);
    
}
