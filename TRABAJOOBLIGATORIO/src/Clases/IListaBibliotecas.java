
package Clases;

public interface IListaBibliotecas {
    
    //PRE: Recibe una nueva instancia
    public boolean agregarInicio(NodoBiblioteca nuevo);
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoBiblioteca n);     
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

    public void mostrarREC2(NodoBiblioteca n, int cont); 

    public void mostrarRECLibro(NodoBiblioteca b);

    public NodoBiblioteca obtenerElementoAnterior(String n);
    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(String n);
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: //POS:
    public NodoBiblioteca obtenerElemento(String n);
   
    public boolean puedoInsertar();

    public boolean buscarElemento(String n);

    public int contarNodos(ListaBibliotecas n);

    public void OrdenarLibrosPorCalifPromedioUnaBiblioteca(NodoBiblioteca b);

    public void OrdenarPorPromedioBiblioteca();

    public ListaLibros LibrosMasSolicitados();    
    
    
}
