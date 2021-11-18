
package Clases;

public interface IListaBibliotecas {
    
    //PRE: Recibe una nueva instancia   
    //POS: Agrega un nuevo Nodo al principio de la lista
    public boolean agregarInicio(NodoBiblioteca nuevo);
    //PRE: Recibe una nueva instancia
    //POS: Agrega un nuevo Nodo al final de la lista
    public boolean agregarFinal(NodoBiblioteca n);     
    //PRE: La lista debe existir 
    //POS: Borra el primer nodo
    public boolean borrarInicio();
    //PRE: La lista debe existir 
    //POS: Borra el último nodo
    public boolean borrarFin();
    //PRE: La lista debe existir 
    //POS: Retorna verdadero o falso si tiene o no elementos    
    public boolean esVacia();
    //PRE: La lista debe existir 
    //POS: elimina todos los nodos de una lista dada   
    public void vaciar();
    //PRE: La lista debe existir 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC();
    //PRE: Recibe un nodo y un contador 
    //POS: Recorre y muestra los datos de lista
    public void mostrarREC2(NodoBiblioteca n, int cont); 
    //PRE: Recibe un nodo
    //POS: Recorre y muestra los datos de lista
    public void mostrarRECLibro(NodoBiblioteca b);
    //PRE: Recibe un nombre
    //POS: Retorna el elemento buscado o null 
    public NodoBiblioteca obtenerElementoAnterior(String n);
    //PRE: La lista debe existir 
    //POS: Borra la primer ocurrencia de un elemento dado
    public boolean eliminarElemento(String n);
    //PRE: La instancia debe tener un elemento cantidad
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos();
    //PRE: Recibe un nombre
    //POS: Retorna el elemento buscado o null 
    public NodoBiblioteca obtenerElemento(String n);
    //PRE: 
    //POS: Retorna si se puede o no insertar un elemento dependiendo del limite 
    public boolean puedoInsertar();
    //PRE: Recibe un nombre
    //POS: Retorna verdadero o falso si existe o no el elemento
    public boolean buscarElemento(String n);
    //PRE: Recibe una lista 
    //POS: Retorna la cantidad de elementos 
    public int contarNodos(ListaBibliotecas n);
    //PRE: Recibe un nodo
    //POS: Ordena la lista en forma descendente 
    public void OrdenarLibrosPorCalifPromedioUnaBiblioteca(NodoBiblioteca b);
    //PRE: 
    //POS: Ordena la lista en forma descendente 
    public void OrdenarPorPromedioBiblioteca();
    //PRE: 
    //POS: Ordena la lista en forma descendente 
    public ListaLibros LibrosMasSolicitados();    
    
    
}
