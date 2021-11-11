package trabajoobligatorio;

import Clases.*;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(o, p);
//        Reserva r1 = new Reserva(11111111, 120, "06/11/21", 3);
//        Reserva r2 = new Reserva(22222222, 121, "06/11/21", 2);
//        Reserva r3 = new Reserva(33333333, 122, "06/11/21", 1);
//
//        r1.agregarFinal(r1);
//        r1.agregarFinal(r2);
//        r1.agregarFinal(r3);
//        r1.mostrarREC();
//
//        System.out.println(r1.eliminarElemento(r2));
//        r1.mostrarREC();
//        System.out.println("BORRAR INICIO? " + r1.borrarInicio());
//        r1.mostrarREC();
//        System.out.println("PROBAR BIBLIOTECA");
//        Biblioteca b1 = new Biblioteca("Kids");
//        Biblioteca b2 = new Biblioteca("Cocina");
//        Biblioteca b3 = new Biblioteca("Biblioteca Nacional");
//
//        System.out.println("ES VACIA? " + b1.esVacia());
//        b1.agregarInicio(b1);
//        b1.agregarFinal(b2);
//        b1.agregarFinal(b3);
//        System.out.println("mostrar ///////////////");
//        b1.mostrarREC();
//        System.out.println("BORRAR INICIO? " + b1.borrarInicio());
//        System.out.println("PRIMERO EN B1 " + b1.getInicioB().getNombre());
//        System.out.println("mostrar ///////////////");
//        b1.mostrarREC();
//        System.out.println("BORRAR FIN? " + b1.borrarFin());
//        System.out.println("mostrar ///////////////");
//        b1.mostrarREC();
//        b1.vaciar();
//        System.out.println("ES VACIA? " + b1.esVacia());
//        System.out.println("buscar b2, ESTA? " + b1.buscarElemento(b2));
//
//        b1.eliminarElemento(b2);
//
//        System.out.println("mostrar /////////////// CANTIDAD ELEMENTOS " + b1.cantElementos());
//        b1.mostrarREC();
//        b1.eliminarElemento(b3);
//        b1.eliminarElemento(b1);
//        System.out.println("ES VACIA? " + b1.esVacia());
//        b1.mostrarREC();
        
        
    }

    public static void juegodeprueba(Obligatorio o, Prueba p) {
        // PUNTO 2.1
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");

        // PUNTO 2.3
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Primera");
        p.ver(o.registrarBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Segunda");
        p.ver(o.registrarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Tercera");
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "Ya esta la biblioteca: Primera"); //Prueba repetido

//        //PUNTO 2.12
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);
//
//        // PUNTO 2.4
        p.ver(o.eliminarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se elimino la biblioteca: Tercera"); //Eliminar la tercera
//        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);
//        p.ver(o.registrarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Tercera");
//
//        // PUNTO 2.5
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 2).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda2", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda2 a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda3", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda3 a biblioteca: Primera");
        p.ver(o.registrarLibro("Mistborne", "Brandon", "Segunda", 5).resultado, Retorno.Resultado.OK, "Se agrego el libro: Mistborne a biblioteca: Segunda");
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca: Primera ya tiene este libro"); //Prueba la biblioteca ya tiene el libro
        p.ver(o.registrarLibro("Zelda", "Nintendo", "NoExisto", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca no existe");   //Prueba no existe la biblioteca

//        //validamos libros por biblioteca
//        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
//        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Segunda").valorString);
//        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.ERROR, "biblioteca inexistente " + o.listarLibrosBiblioteca("Tercera").valorString);
//
//        // PUNTO 2.6    
//        p.ver(o.eliminarLibro("Zelda3", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Se elimino libro: Zelda3 de biblioteca: Primera");  //Eliminar el ultimo
//        // validamos que la biblioteca tiene un libro menos
//        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
//
//        // PUNTO 2.7
//        // ranking antes de calificar
//        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
//
//        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 6, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
//        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Libro inexistente");
//        p.ver(o.RegistrarCalificacion("Mistborne", "Brandon", 4, "Segunda", "Muy bueno").resultado, Retorno.Resultado.OK, "Se califico correctamente");
//        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", -1, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
//        p.ver(o.RegistrarCalificacion("No existo", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Libro no esta en la biblioteca");
//        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 5, "Primera", "Traigan la continuacion de Zelda").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
//        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 3, "Primera", "Buena atencion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
//        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 3, "Primera", "Mejor el primer libro").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
//        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 4, "Primera", "Poca iluminacion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
//        p.ver(o.RegistrarCalificacion("Zelda3", "Nintendo", 5, "Primera", "Todo exelente").resultado, Retorno.Resultado.ERROR, "Se agrego calificacion al libro: Zelda3 no existe en la bib primera");
//
//        // ranking despues de calificar
//        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
//
//        // PUNTO 2.8    
//        // antes de comenzar las reservas
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
//        p.ver(o.realizarReserva(23, 2, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");
//        p.ver(o.realizarReserva(1, 3, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");
//
//        // cuando estan todas las reservas de ejemplares    
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
//        p.ver(o.realizarReserva(2, 4, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");
//        p.ver(o.realizarReserva(3, 5, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");
//
//        //cuando me excedi en las reservas    
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
//        p.ver(o.realizarReserva(4, 6, "Primera", "No existo", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.ERROR, "No existe el libro en la biblioteca");
//
//        // PUNTO 2.4 Pero con reservas
//        p.ver(o.eliminarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "La biblioteca Primera tiene reservas");//Prueba eliminar con reservas
//
//        // PUNTO 2.9
//        p.ver(o.cancelarReserva(23, 2, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva"); //Cancela reserva se carga de espera
//
//        //vemos la lista de espera luego de cancelar una reserva 
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
//        //    p.ver(o.cancelarReserva(3, 5, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva en la lista de espera"); //Cancela de la lista de espera
//        p.ver(o.cancelarReserva(33, 15, "Tercera").resultado, Retorno.Resultado.ERROR, "No existe la reserva en la biblioteca"); //Prueba no existe la reserva
//
//        // PUNTO 2.10
        p.ver(o.listarLibros("Primera2").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca Primera2");   //Prueba no existe la biblioteca
        p.ver(o.listarLibros("Tercera").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Tercera").valorString); //Prueba no tiene libros
        p.ver(o.listarLibros("Primera").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Primera").valorString);
        p.ver(o.listarLibros("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Segunda").valorString);

//        // PUNTO 2.11
//        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
//        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Segunda").valorString);
//        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Tercera").valorString);
//
//        // PUNTO 2.13
//        p.ver(o.listarComentarios("Primera").resultado, Retorno.Resultado.OK, "Lista comentarios" + o.listarComentarios("Primera").valorString);
//        p.ver(o.listarComentarios("No existo").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca");
//        p.ver(o.listarComentarios("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarComentarios("Segunda").valorString);
//
//        // PUNTO 2.12
//        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
//
//        // PUNTO 2.14    
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//        p.ver(o.listarEspera("Zelda2", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda2", "Nintendo", "Primera").valorString);
//        p.ver(o.listarEspera("No existo", "Nintendo", "Primera").resultado, Retorno.Resultado.ERROR, "No existe el titulo No existo de la editorial Nintendo en la biblioteca Primera");
//
//        // PUNTO 2.2
//        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
//
//        p.imprimirResultadosPrueba();

    }
}
