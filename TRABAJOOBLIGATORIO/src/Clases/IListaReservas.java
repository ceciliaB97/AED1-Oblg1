
package Clases;


public interface IListaReservas {
    
    public boolean esLLena();
    
    public boolean esVacia();

    public boolean puedoInsertar();

    public int cantElementos();

    public boolean agregarFinal(NodoReserva n);

    public boolean agregarInicio(NodoReserva n);

    public NodoReserva obtenerElemento(int cliente, int numero);

    public NodoReserva obtenerElementoAnterior(int cliente, int numero);
    
    public boolean borrarFin();

    public boolean eliminarElemento(int cliente, int numero);

    public boolean borrarInicio();

    public void mostrarREC();

    public void mostrarREC2(NodoReserva n, int cont);

    public void vaciar();    
}
