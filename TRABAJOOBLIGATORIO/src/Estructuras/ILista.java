package Estructuras;

/**
 *
 * @author RC
 */
public interface ILista {

    //POS: Constructor, crea una lista vacía
    void Lista();
    
    //POS: Retorna true si la lista no tiene nodos
    boolean esVacia();
    
    //POS: Inserta un nodo al principio de la lista
    boolean agregarInicio(TDato n);

    //POS: Inserta un nodo al final de la lista
    boolean agregarFinal(TDato n);

    //PRE: LISTA YA ESTA ORDENADA AL MOMENTO DE INGRESAR EL DATO Y AL MOSTRAR YA ESTA ORDENADA
    boolean agregarOrdenado(TDato n);
    
    //PRE: LISTA YA ESTA ORDENADA
    boolean buscarElemento(TDato n);
    
    //busca elemento y devuelve
    NodoLista obtenerElemento(TDato n);
    
    boolean eliminarElemento(TDato n);
    
    //POS: Borra el primer nodo
    boolean borrarInicio();

    //POS: Borra el último nodo
    boolean borrarFin();

    //POS: Muestra los datos de la lista
    void mostrar();
    
    int contarNodos(TDato n);

    //POS: Elimina todos los nodos de la lista
    void vaciar();
    
    
}
