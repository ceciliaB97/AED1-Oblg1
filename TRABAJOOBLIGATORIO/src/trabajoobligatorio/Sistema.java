package trabajoobligatorio;

import Clases.*;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(o, p);
        Reserva r1 = new Reserva(11111111, 120, "06/11/21");
        Reserva r2 = new Reserva(22222222, 121, "06/11/21");
        Reserva r3 = new Reserva(33333333, 122, "06/11/21");

        r1.agregarFinal(r1);
        r1.agregarFinal(r2);
        r1.agregarFinal(r3);
        r1.mostrarREC();

        System.out.println(r1.eliminarElemento(r2));
        r1.mostrarREC();
        System.out.println("BORRAR INICIO? " + r1.borrarInicio());
        r1.mostrarREC();
        System.out.println("PROBAR BIBLIOTECA");
        Biblioteca b1 = new Biblioteca("Kids");
        Biblioteca b2 = new Biblioteca("Cocina");
        Biblioteca b3 = new Biblioteca("Biblioteca Nacional");

        System.out.println("ES VACIA? " + b1.esVacia());
        b1.agregarInicio(b1);
        b1.agregarFinal(b2);
        b1.agregarFinal(b3);
        System.out.println("mostrar ///////////////");
        b1.mostrarREC();
//        System.out.println("BORRAR INICIO? " + b1.borrarInicio());
//        System.out.println("PRIMERO EN B1 " + b1.getInicioB().getNombre());
//        System.out.println("mostrar ///////////////");
//        b1.mostrarREC();
//        System.out.println("BORRAR FIN? " + b1.borrarFin());
//        System.out.println("mostrar ///////////////");
//        b1.mostrarREC();
//        b1.vaciar();
//        System.out.println("ES VACIA? " + b1.esVacia());
        System.out.println("buscar b2, ESTA? " + b1.buscarElemento(b2));

        b1.eliminarElemento(b2);

        System.out.println("mostrar /////////////// CANTIDAD ELEMENTOS " + b1.cantElementos());
        b1.mostrarREC();
        b1.eliminarElemento(b3);
        b1.eliminarElemento(b1);
        System.out.println("ES VACIA? " + b1.esVacia());
        b1.mostrarREC();
    }

    public static void juegodeprueba(Obligatorio o, Prueba p) {
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");

        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");

        p.imprimirResultadosPrueba();

    }
}
