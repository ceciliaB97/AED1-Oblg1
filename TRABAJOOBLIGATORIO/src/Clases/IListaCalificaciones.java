
package Clases;


public interface IListaCalificaciones {
    
    public boolean esVacia();

    public boolean agregarInicio(int calificacion, String comentario);

    public boolean agregarFinal(int calificacion, String comentario);

    public boolean borrarInicio();

    public boolean borrarFin();

    public void vaciar();

    public void mostrarREC();

    public void mostrarREC2(NodoCalificacion n, int cont);

    public NodoCalificacion obtenerElementoAnterior(NodoCalificacion n);

    public boolean eliminarElemento(NodoCalificacion n);

    public int cantElementos();

    public NodoCalificacion obtenerElemento(NodoCalificacion n);

    public boolean puedoInsertar();

    public boolean buscarElemento(NodoCalificacion n);

    public int contarNodos(ListaCalificaciones n);
    
}
