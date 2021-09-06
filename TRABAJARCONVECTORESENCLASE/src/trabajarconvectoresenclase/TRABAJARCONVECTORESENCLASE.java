package trabajarconvectoresenclase;

public class TRABAJARCONVECTORESENCLASE {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p = new Prueba();
        Vectores vec = new Vectores();
        int v[] = {6, 5, 3, 1, 8, 7, 2, 4};
        //int vo[]={1,2,3,4,5,6,7,8};
        juegodeprueba(p, vec, v);
    }

    public static void juegodeprueba(Prueba p, Vectores vec, int v[]) {
        int vo[] = {1, 2, 3, 4, 5, 6, 7, 8};
        p.ver(vec.mostrarv(v).resultado, Retorno.Resultado.OK, "Vector original = " + vec.mostrarv(v).valorString);
        p.ver(vec.mostrarv(vo).resultado, Retorno.Resultado.OK, "Vector original = " + vec.mostrarv(vo).valorString);

        p.ver(vec.maxvec(v).resultado, Retorno.Resultado.OK, "Maximo del vector = " + vec.maxvec(v).valorEntero);
        p.ver(vec.maxvecV2(vo).resultado, Retorno.Resultado.OK, "Maximo del vector = " + vec.maxvecV2(vo).valorEntero);

        p.ver(vec.minvec(v).resultado, Retorno.Resultado.OK, "Minimo del vector = " + vec.minvec(v).valorEntero);
        p.ver(vec.minvecV2(v).resultado, Retorno.Resultado.OK, "Minimo del vector = " + vec.minvecV2(v).valorEntero);

        int vu[] = {8, 90, 5, 3, 10, 100, 30, 30};

        p.ver(vec.maxvec(vu, 0, v.length - 1).resultado, Retorno.Resultado.OK, "El Maximo desde 0 a largo -1 = " + vec.maxvec(vu, 0, v.length - 1).valorEntero);
        p.ver(vec.maxvec(vu, 1, 4
        ).resultado, Retorno.Resultado.OK, "El Maximo desde 1 a 4 = " + vec.maxvec(vu, 1, 4).valorEntero);
        p.ver(vec.maxvec(vu, 4, v.length - 1).resultado, Retorno.Resultado.OK, "El Maximo desde 4 a largo -1 = " + vec.maxvec(vu, 4, v.length - 1).valorEntero);

        int vx[] = {1, 50, 20, 15, 35};
        int vxOrdenado[] = {1, 15, 20, 35, 50};

        p.ver(vec.posmaxvec(vx, 0, 2).resultado, Retorno.Resultado.OK, "Posicion maxima del vector entre 0 y 2 es " + vec.posmaxvec(vx, 0, 2).valorEntero);
        //System.out.println(vec.ordenarvec1(v).valorString);
        p.ver(vec.posmaxvec(vx, 2, vx.length - 1).resultado, Retorno.Resultado.OK, "Posicion maxima del vector entre 2 y largo -1 es " + vec.posmaxvec(vx, 2, vx.length - 1).valorEntero);
        p.ver(vec.posmaxvec(vx, 3, vx.length - 1).resultado, Retorno.Resultado.OK, "Posicion maxima del vector entre 3 y largo -1 es " + vec.posmaxvec(vx, 3, vx.length - 1).valorEntero);

        System.out.println("Vector debe estar ordenado");
        p.ver(vec.posmaxvecV2(vxOrdenado, 3, vxOrdenado.length - 1).resultado, Retorno.Resultado.OK, "Posicion maxima del vector entre 3 y largo -1 es " + vec.posmaxvecV2(vxOrdenado, 3, vxOrdenado.length - 1).valorEntero);

        int vm[] = {8, 10, 5, 15, 3};

        int vmOrdenado[] = {3, 5, 8, 10, 15};

        p.ver(vec.posminvec(vm, 0, 2).resultado, Retorno.Resultado.OK, "Posicion minima del vector entre 0 y 2 es " + vec.posminvec(vm, 0, 2).valorEntero);
        //System.out.println(vec.ordenarvec1(v).valorString);
        p.ver(vec.posminvec(vm, 2, vm.length - 1).resultado, Retorno.Resultado.OK, "Posicion minima del vector entre 2 y largo -1 es " + vec.posminvec(vm, 2, vm.length - 1).valorEntero);
        p.ver(vec.posminvec(vm, 3, vm.length - 1).resultado, Retorno.Resultado.OK, "Posicion minima del vector entre 3 y largo -1 es " + vec.posminvec(vm, 3, vm.length - 1).valorEntero);

        System.out.println("Vector debe estar ordenado");
        p.ver(vec.posminvecV2(vmOrdenado, 3, vmOrdenado.length - 1).resultado, Retorno.Resultado.OK, "Posicion minima del vector entre 3 y largo -1 es " + vec.posminvecV2(vmOrdenado, 3, vmOrdenado.length - 1).valorEntero);

        p.ver(vec.buscarvec(vm, 5).resultado, Retorno.Resultado.OK, "Se encuentra el número 5 en el vector " + vec.buscarvec(vm, 5).valorbooleano);
        p.ver(vec.buscarvec(vm, 3).resultado, Retorno.Resultado.OK, "Se encuentra el número 3 en el vector " + vec.buscarvec(vm, 3).valorbooleano);
        p.ver(vec.buscarvec(vm, 25).resultado, Retorno.Resultado.OK, "Se encuentra el número 10 en el vector " + vec.buscarvec(vm, 25).valorbooleano);

        System.out.println("Vector debe estar ordenado");
        p.ver(vec.buscarvecV2(vmOrdenado, 5).resultado, Retorno.Resultado.OK, "Se encuentra el número 5 en el vector " + vec.buscarvecV2(vmOrdenado, 5).valorbooleano);
        p.ver(vec.buscarvecV2(vmOrdenado, 3).resultado, Retorno.Resultado.OK, "Se encuentra el número 3 en el vector " + vec.buscarvecV2(vmOrdenado, 3).valorbooleano);
        p.ver(vec.buscarvecV2(vmOrdenado, 1).resultado, Retorno.Resultado.OK, "Se encuentra el número 1 en el vector " + vec.buscarvecV2(vmOrdenado, 1).valorbooleano);

        int vy[] = {8, 10, 5, 15, 3, 2};
        int vyOrdenado[] = {2, 3, 5, 8, 10, 15};

        System.out.println("Vector debe estar ordenado");
//
        p.ver(vec.buscarporpuntomedio(vyOrdenado, 10).resultado, Retorno.Resultado.OK, "Numero 10 dentro del array  " + vec.buscarporpuntomedio(vyOrdenado, 10).valorbooleano);
        p.ver(vec.buscarporpuntomedio(vyOrdenado, 3).resultado, Retorno.Resultado.OK, "Numero 3 dentro del array  " + vec.buscarporpuntomedio(vyOrdenado, 3).valorbooleano);
        p.ver(vec.buscarporpuntomedio(vyOrdenado, 56).resultado, Retorno.Resultado.OK, "Numero 56 dentro del array  " + vec.buscarporpuntomedio(vyOrdenado, 56).valorbooleano);

        int vt[] = {8, 10, 5, 15, 3};
        int vtOrdenado[] = {3, 5, 8, 10, 15};
        System.out.println("BUSCAR EN POS v1 vector SIN ORDENAR");
        p.ver(vec.buscarenpos(vt, 1, vt.length - 1, 5).resultado, Retorno.Resultado.OK, "Numero 5 dentro del array, en el rango desde 1  " + vec.buscarenpos(vt, 1, vt.length - 1, 5).valorbooleano);
        p.ver(vec.buscarenpos(vt, 3, vt.length - 1, 3).resultado, Retorno.Resultado.OK, "Numero 3 dentro del array  , en el rango desde 3  " + vec.buscarenpos(vt, 3, vt.length - 1, 3).valorbooleano);
        p.ver(vec.buscarenpos(vt, 0, vt.length - 1, 8).resultado, Retorno.Resultado.OK, "Numero 8 dentro del array  , en el rango desde 0  " + vec.buscarenpos(vt, 1, vt.length - 1, 5).valorbooleano);

        System.out.println("BUSCAR EN POS v2 con VECTOR ORDENADO");
        p.ver(vec.buscarenposV2(vtOrdenado, 1, vtOrdenado.length - 1, 5).resultado, Retorno.Resultado.OK, "Numero 5 dentro del array, en el rango desde 1 hasta largo " + vec.buscarenposV2(vtOrdenado, 1, vt.length, 5).valorbooleano);
        p.ver(vec.buscarenposV2(vtOrdenado, 0, 2, 3).resultado, Retorno.Resultado.OK, "Numero 3 dentro del array , en el rango desde 3 hasta largo " + vec.buscarenposV2(vtOrdenado, 3, vtOrdenado.length - 1, 3).valorbooleano);
        p.ver(vec.buscarenposV2(vtOrdenado, 3, vtOrdenado.length - 1, 8).resultado, Retorno.Resultado.OK, "Numero 8 dentro del array, en el rango desde 0 hasta largo " + vec.buscarenposV2(vtOrdenado, 1, vt.length, 5).valorbooleano);

        p.ver(vec.poselemento(vt, 5).resultado, Retorno.Resultado.OK, "Posicion de 5 es " + vec.poselemento(vt, 5).valorEntero);
        p.ver(vec.poselemento(vt, 0, 3, 5).resultado, Retorno.Resultado.OK, "Posicion de 15 es " + vec.poselemento(vt, 0, 3, 5).valorEntero);

        int vr[] = {5, 8, 20, 7, 6, 3, 4};

        p.ver(vec.ordenarvec1(vr).resultado, Retorno.Resultado.OK, "Array ordenado es " + vec.ordenarvec1(vr).valorString);
        p.ver(vec.ordenarvec2(vr).resultado, Retorno.Resultado.OK, "Array ordenado es " + vec.ordenarvec2(vr).valorString);
        p.ver(vec.ordenarvec3(vr).resultado, Retorno.Resultado.OK, "Array ordenado es " + vec.ordenarvec3(vr).valorString);

        int[] unir1 = {1, 2, 3};
        int[] unir2 = {5, 6, 7};

        p.ver(vec.promedio(vr).resultado, Retorno.Resultado.OK, "Promedio es " + vec.promedio(vr).valorEntero);
        p.ver(vec.unirvectoresordenados(unir1, unir2).resultado, Retorno.Resultado.OK, "Vectores ordenados unidos son " + vec.unirvectoresordenados(unir1, unir2).valorString);
        p.ver(vec.unirvectoresordenados(unir2, unir1).resultado, Retorno.Resultado.OK, "Vectores ordenados unidos son " + vec.unirvectoresordenados(unir2, unir1).valorString);

        p.ver(vec.muestroposimpares(vr).resultado, Retorno.Resultado.OK, "Posiciones con impares son " + vec.muestroposimpares(vr).valorString);
        p.ver(vec.muestroposimpares(vr).resultado, Retorno.Resultado.OK, "Posiciones con pares son " + vec.muestroposimpares(vr).valorString);

        p.ver(vec.muestrocontenidosimpares(vr).resultado, Retorno.Resultado.OK, "Posiciones con impares son " + vec.muestrocontenidosimpares(vr).valorString);

        p.imprimirResultadosPrueba();
    }
}
