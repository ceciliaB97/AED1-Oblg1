package trabajarconvectoresenclase;

public interface IVectores {

    public Retorno mostrarv(int[] v);
    // El vector no esta ordenado

    public Retorno maxvec(int[] v);
    // El vector esta ordenado ASC

    public Retorno maxvecV2(int[] v);
    // El vector no esta ordenado

    public Retorno minvec(int[] v);
    // El vector esta ordenado ASC

    public Retorno minvecV2(int[] v);
//-------------------------------------------------------   
    //precondiciones 
    // desde y hasta son posiciones
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta

    public Retorno maxvec(int[] v, int desde, int hasta);
    // poscondicion: El algoritmo retorna el valor maximo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde y hasta son posiciones
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector ya debe estar ordenado

    public Retorno maxvecV2(int[] v, int desde, int hasta);
    // poscondicion: El algoritmo retorna el valor maximo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector no ordenado

    public Retorno minvec(int[] v, int desde, int hasta);

    // poscondicion: El algoritmo retorna el valor minimo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector ya debe estar ordenado
    public Retorno minvecV2(int[] v, int desde, int hasta);

    // poscondicion: El algoritmo retorna el valor minimo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
//precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector no debe estar ordenado
    public Retorno posmaxvec(int[] v, int desde, int hasta);

    // poscondicion: El algoritmo retorna la posicion con el valor maximo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector no debe estar ordenado
    public Retorno posminvec(int[] v, int desde, int hasta);

    // poscondicion: El algoritmo retorna la posicion con el valor minimo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector YA debe estar ordenado
    public Retorno posminvecV2(int[] v, int desde, int hasta);

    // poscondicion: El algoritmo retorna la posicion con el valor minimo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector YA debe estar ordenado
    public Retorno posmaxvecV2(int[] v, int desde, int hasta);
    // poscondicion: El algoritmo retorna la posicion con el valor maximo del vector 
    // comprendido entre las posiciones desde y hasta inclusive
//-------------------------------------------------------  
    //precondiciones 
    // vector no debe estar ordenado

    public Retorno buscarvec(int[] v, int elemento);

    // poscondicion: El algoritmo retorna la un booleano de si el elemento esta en el vector o no
//-------------------------------------------------------  
    //precondiciones 
    // vector YA debe estar ordenado
    public Retorno buscarvecV2(int[] v, int elemento);
    // poscondicion: El algoritmo retorna la un booleano de si el elemento esta en el vector o no
//-------------------------------------------------------  
    //precondiciones 
    // vector no debe estar ordenado
    public Retorno buscarporpuntomedio(int[] v, int elemento);

    // poscondicion: El algoritmo retorna SI ESTA O NO dentro del array el elemento
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector no debe estar ordenado
    public Retorno buscarenpos(int[] v, int desde, int hasta, int elemento);

    // poscondicion: El algoritmo retorna SI ESTA O NO dentro del array el elemento
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector ya debe estar ordenado
    public Retorno buscarenposV2(int[] v, int desde, int hasta, int elemento);

    // poscondicion: El algoritmo retorna SI ESTA O NO dentro del array el elemento
//-------------------------------------------------------  
    //precondiciones 
    // elemento puede estar dentro o no del array
    // vector ya debe estar ordenado
    public Retorno poselemento(int[] v, int elemento);

    // poscondicion: El algoritmo retorna la posicion del elemento si el elemento se encuentra
//-------------------------------------------------------  
    //precondiciones 
    // desde >= 0
    // hasta >= 0
    // desde < largo del array
    // hasta < largo del array
    // desde <= hasta
    // vector ya debe estar ordenado
    public Retorno poselemento(int[] v, int desde, int hasta, int elemento);

    // poscondicion: El algoritmo retorna la posicion del elemento si el elemento se encuentra, dentro del rango
//-------------------------------------------------------  
    //precondiciones 
    // vector no debe estar ordenado
    public Retorno ordenarvec1(int[] v);

    // poscondicion: El algoritmo retorna el vector ordenado, mediante la comparacion de el elemento de la posicion j con todos los demás elementos del array, y si se ordena uno, hace el largo del array del primer bucle mas corto
//-------------------------------------------------------  
    //precondiciones 
    // vector no debe estar ordenado
    public Retorno ordenarvec2(int[] v);

    // poscondicion: El algoritmo retorna el vector ordenado, mediante la comparacion de el elemento de la posicion actual con la posicion siguiente, si el siguiente es mayor, se cambian, si no sigue, si ya esta ordenado sale y no lo lo recorre todo
//-------------------------------------------------------  
    //precondiciones 
    // vector no debe estar ordenado
    public Retorno ordenarvec3(int[] v);

    // poscondicion: El algoritmo retorna el vector ordenado, mediante encontrar la posicion minima y maxima del array actuales, luego acorta el largo del array por 2, y sigue encontrando lo mismo hasta que ya no quede más array para analizar
//-------------------------------------------------------  
    //precondiciones 
    // vector puede o no estar ordenado
    public Retorno promedio(int[] v);    // poscondicion: El algoritmo retorna el vector ordenado, mediante encontrar la posicion minima y maxima del array actuales, luego acorta el largo del array por 2, y sigue encontrando lo mismo hasta que ya no quede más array para analizar
    // poscondicion: El algoritmo retorna el promedio de todos los elementos del array
//-------------------------------------------------------  
    //precondiciones 
    // vectores deben ya estar ordenados

    public Retorno unirvectoresordenados(int[] v1, int[] v2);

    // poscondicion: El algoritmo retorna un vector mas largo mediante la unificacion de ambos vectores
//-------------------------------------------------------  
    //precondiciones 
    // vector pueden o no estar ordenado
    public Retorno muestroposimpares(int v[]);

    // poscondicion: El algoritmo retorna la posicion de los elementos del array que son impares
//-------------------------------------------------------  
    //precondiciones 
    // vector pueden o no estar ordenado
    public Retorno muestropospares(int v[]);

    // poscondicion: El algoritmo retorna la posicion de los elementos del array que son pares
//-------------------------------------------------------  
    //precondiciones 
    // vector pueden o no estar ordenado
    public Retorno muestrocontenidosimpares(int v[]);
    // poscondicion: El algoritmo retorna los elementos del array que son impares
//-------------------------------------------------------  
}
