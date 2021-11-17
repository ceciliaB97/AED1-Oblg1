
package Clases;


public interface IListaLibros {
    
    
    public boolean esVacia();
    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoLibro nuevo);
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoLibro n);
    //PRE:
    //POS: Borra el primer nodo
    public boolean borrarInicio();
    //PRE:
    //POS: Borra el último nodo
    public boolean borrarFin();
    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar();
    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC();

    public void mostrarREC2(NodoLibro n, int cont);
    
    public void mostrarRECExtenso();

    public void mostrarRECExtenso2(NodoLibro n, int cont);

    public NodoLibro obtenerElementoAnterior(NodoLibro n);
    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(NodoLibro n);
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: //POS:
    public NodoLibro obtenerElemento(String titulo, String editorial);
    
    public boolean puedoInsertar();

    public boolean buscarElemento(NodoLibro n);
    //auxiliar
    public boolean eliminarElementoDesdeNodo(NodoLibro n, NodoLibro nodoDesde);

    public NodoLibro obtenerElementoAnteriorNodoDesde(NodoLibro n, NodoLibro desde);
 
    public void bubbleSort();

    public void bubbleSortCalificacion();
    
    public ListaCalificaciones ListaComentarios();
}
