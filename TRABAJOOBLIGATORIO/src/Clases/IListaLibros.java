
package Clases;


public interface IListaLibros {
    
    //PRE: La lista debe existir 
    //POS: Retorna verdadero o falso si tiene o no elementos  
    public boolean esVacia();
    //PRE: //PRE: Recibe una nueva instancia  
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoLibro nuevo);
    //PRE: Recibe una nueva instancia
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoLibro n);
    //PRE: La lista debe existir 
    //POS: Borra el primer nodo
    public boolean borrarInicio();
    //PRE: La lista debe existir 
    //POS: Borra el último nodo
    public boolean borrarFin();
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar();
    //PRE: La lista debe existir 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC();
    //PRE: Recibe un nodo y un contador 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC2(NodoLibro n, int cont);
    //PRE: La lista debe existir 
    //POS: Recorre y muestra los datos de lista
    public void mostrarRECExtenso();
    //PRE: Recibe un nodo y un contador 
    //POS: Recorre y muestra los datos de lista
    public void mostrarRECExtenso2(NodoLibro n, int cont);
    //PRE: Recibe un nombre
    //POS: Retorna el elemento buscado o null 
    public NodoLibro obtenerElementoAnterior(NodoLibro n);
    //PRE: La lista debe existir 
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(NodoLibro n);
    //PRE: La instancia debe tener un elemento cantidad
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: Recibe un titulo y una editorial 
    //POS: Retorna el elemento buscado o null 
    public NodoLibro obtenerElemento(String titulo, String editorial);
    //PRE: 
    //POS: Retorna si se puede o no insertar un elemento dependiendo del limite 
    public boolean puedoInsertar();
    //PRE: Recibe un nombre
    //POS: Retorna verdadero o falso si existe o no el elemento
    public boolean buscarElemento(NodoLibro n);
    //PRE: Recibe dos nodos 
    //POS: Retorna verdadero o falso si existe o no el elemento
    public boolean eliminarElementoDesdeNodo(NodoLibro n, NodoLibro nodoDesde);
    //PRE: Recibe dos nodos 
    //POS: Retorna verdadero o falso si existe o no el elemento
    public NodoLibro obtenerElementoAnteriorNodoDesde(NodoLibro n, NodoLibro desde);
    //PRE: La lista debe existir 
    //POS: Ordena la lista en descendente 
    public void bubbleSort();
    //PRE: La lista debe existir 
    //POS: Ordena la lista en descendente por calificacion 
    public void bubbleSortCalificacion();
    //PRE: La lista debe existir 
    //POS: Lista los comentarios 
    public ListaCalificaciones ListaComentarios();
}
