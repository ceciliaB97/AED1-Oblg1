package trabajoobligatorio;

import Clases.*;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p = new Prueba();
        Obligatorio o = new Obligatorio();

//        o.crearSistemaReservas();
//        o.registrarBiblioteca("Biblioteca Libros");
//        System.out.println(o.eliminarBiblioteca("Biblioteca Libros").resultado + " se elimino una biblioteca 1");
//        System.out.println(o.listarLibros("Biblioteca Libros").resultado + " listar libros biblioteca no existente");

//        juegodeprueba(o, p);

//     juegodeprueba(o, p);
//       juegodeprueba1(o, p);
//       juegodeprueba2(o, p);
//       juegodeprueba3(o, p);
        

        o.crearSistemaReservas();
//        System.out.println("************************************");
//        o.registrarBiblioteca("Biblioteca Libros");
//        o.eliminarBiblioteca("Biblioteca Libros");
        System.out.println("************************************");
        //
        o.registrarBiblioteca("Biblioteca Nacional");
        o.registrarBiblioteca("Biblioteca de Canelones");
        o.registrarBiblioteca("Biblioteca de Montevideo");
        System.out.println("************************************");
        //
        o.registrarLibro("Artigas y su historia", "Libros del litoral", "Biblioteca Nacional", 2);
        o.registrarLibro("Cuentos de los Andes", "Las aventuras", "Biblioteca Nacional", 3);// pivote
        o.registrarLibro("Aprende a amoldar cerámica", "Didacticos", "Biblioteca Nacional", 2);
        o.registrarLibro("Cuentos de los Andes", "Las aventuras", "Biblioteca de Canelones", 3);// pivote
        //o.eliminarLibro(titulo, editorial, biblioteca);
//        o.eliminarLibro("Aprende a amoldar cerámica", "Didacticos", "Biblioteca Nacional");
        //
        o.registrarLibro("Palabras interesantes", "Didacticos", "Biblioteca de Canelones", 2);
        o.registrarLibro("Rutas del Uruguay", "Nuestro Pais", "Biblioteca de Canelones", 1);
        //
        o.registrarLibro("Destinos turísticos del Uruguay", "Biblioteca de Montevideo", "Prueba", 2);
        o.registrarLibro("Montevideo historito", "Didacticos", "Biblioteca de Montevideo", 1);
        //
        o.listarLibros("Prueba");
        //o.realizarReserva(0, 0, biblioteca, título, editorial, fecha);
        System.out.println("************************************");
        o.realizarReserva(1, 1, "Biblioteca de Canelones", "Rutas del Uruguay", "Nuestro Pais", "13/11/2021");
        o.realizarReserva(2, 2, "Biblioteca de Canelones", "Rutas del Uruguay", "Nuestro Pais", "14/11/2021");
        o.realizarReserva(1, 1, "Biblioteca de Canelones", "Rutas del Uruguay", "Nuestro Pais", "13/11/2021");
        o.realizarReserva(2, 2, "Biblioteca de Canelones", "Rutas del Uruguay", "Nuestro Pais", "14/11/2021");
        
        System.out.println("CANTIDAD RESERVAS Y ESPERAS DE RUTAS DEL URUGUAY " + o.bibliotecaBase.obtenerElemento("Biblioteca de Canelones").getLibros().obtenerElemento("Rutas del Uruguay", "Nuestro Pais").getCantSolicitudes());
        // 4 solicituds

        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
        o.realizarReserva(3, 3, "Biblioteca de Canelones", "Palabras interesantes", "Didacticos", "15/11/2021");
// 6 solicitudes
        o.realizarReserva(4, 4, "Biblioteca de Montevideo", "Montevideo historito", "Didacticos", "16/11/2021");
        o.realizarReserva(4, 4, "Biblioteca de Montevideo", "Montevideo historito", "Didacticos", "16/11/2021");
        //2 solicitudes

        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca Nacional", "Cuentos de los Andes", "Las aventuras", "17/11/2021");
        o.realizarReserva(1, 5, "Biblioteca de Canelones", "Cuentos de los Andes", "Las aventuras", "17/11/2021");

        //6 solicitudes
        //o.cancelarReserva(0, 0, biblioteca);
        System.out.println("************************************");
//        o.cancelarReserva(1, 5, "Biblioteca Nacional");
        //o.RegistrarCalificacion(titulo, editorial, 0, biblioteca, comentario)
        System.out.println("************************************");
        o.RegistrarCalificacion("Artigas y su historia", "Libros del litoral", 5, "Biblioteca Nacional", "Muy bueno");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 1, "Biblioteca de Canelones", "Muy malo");
        o.RegistrarCalificacion("Montevideo historito", "Didacticos", 3, "Biblioteca de Montevideo", "Normal");
        o.RegistrarCalificacion("Cuentos de los Andes", "Las aventuras", 4, "Biblioteca Nacional", "Bueno");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 2, "Biblioteca de Canelones", "Malo");
        //
        o.RegistrarCalificacion("Artigas y su historia", "Libros del litoral", 2, "Biblioteca Nacional", "rrw");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 5, "Biblioteca de Canelones", "tewte");
        o.RegistrarCalificacion("Montevideo historito", "Didacticos", 1, "Biblioteca de Montevideo", "rte");
        o.RegistrarCalificacion("Cuentos de los Andes", "Las aventuras", 3, "Biblioteca Nacional", "werew");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 4, "Biblioteca de Canelones", "werew");
        //
        o.RegistrarCalificacion("Artigas y su historia", "Libros del litoral", 3, "Biblioteca Nacional", "werew");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 2, "Biblioteca de Canelones", "werew");
        o.RegistrarCalificacion("Montevideo historito", "Didacticos", 5, "Biblioteca de Montevideo", "Nwer");
        o.RegistrarCalificacion("Cuentos de los Andes", "Las aventuras", 1, "Biblioteca Nacional", "Buwerewo");
        o.RegistrarCalificacion("Palabras interesantes", "Didacticos", 4, "Biblioteca de Canelones", "Mwero");

        o.RegistrarCalificacion("Montevideo historito", "editorial", 3, "Biblioteca de Montevideo", "Normal");
        o.RegistrarCalificacion("Destinos turísticos del Uruguay", "editorial", 4, "Biblioteca de Montevideo", "Bueno");

//
//        System.out.println("************************************");
//        //
//        System.out.println("    Aca se imprime bibliotecas por ranking");
//        o.listarBibliotecaRanking();
//        System.out.println("************************************");
//        //
//        System.out.println("************************************");
//        o.listarLibros("Biblioteca Nacional");
//        o.listarLibros("Biblioteca de Canelones");
//        o.listarLibros("Biblioteca de Montevideo");
//        //
//        System.out.println("************************************");
//        o.listarLibrosBiblioteca("Biblioteca Nacional");
//        o.listarLibrosBiblioteca("Biblioteca de Canelones");
//        o.listarLibrosBiblioteca("Biblioteca de Montevideo");
//        //
//        System.out.println("************************************");
//        o.listarComentarios("Biblioteca Nacional");
//        o.listarComentarios("Biblioteca de Canelones");
//        o.listarComentarios("Biblioteca de Montevideo");
//        System.out.println("************************************");
//        //o.listarEspera(titulo, editorial, biblioteca);
//        o.listarEspera("Rutas del Uruguay", "Nuestro Pais", "Biblioteca de Canelones");
//        //
//        System.out.println("    Aca se imprime bibliotecas por ranking");
//        o.listarBibliotecaRanking();
//        System.out.println("************************************");
//        //o.listarEspera(titulo, editorial, biblioteca)
//        o.listarEspera("Biblioteca de Canelones", "Libros del litoral", "Biblioteca Nacional");
//        o.listarEspera("Rutas del Uruguay", "Nuestro Pais", "Biblioteca de Canelones");
//        o.listarEspera("Palabras interesantes", "Didacticos", "Biblioteca de Canelones");
//        //

        o.listarLibros("Biblioteca de Canelones");
        System.out.println("*******************");

//        o.listarLibros("Biblioteca de Canelones");
//        System.out.println("*******************");
//
// comente esto por qe da error

//            NodoBiblioteca auxBiblioteca = new NodoBiblioteca("auxBiblioteca");
//            auxBiblioteca.setLibros(o.bibliotecaBase.LibrosMayorRanKing());
//            o.bibliotecaBase.agregarInicio(auxBiblioteca);
//            if(!o.bibliotecaBase.LibrosMayorRanKing().esVacia()){
//                System.out.println("NO ESTA VACIA");
//            }
//            auxBiblioteca.setLibros(o.bibliotecaBase.LibrosMayorRanKing());
//            o.listarLibros("auxBiblioteca");


        System.out.println("*******************");


//
//        o.listarLibros("Biblioteca de Canelones");
//        System.out.println("*******************");
//


        o.mostrarReservasBiblioteca();
        //o.mostrarReservasBiblioteca();
//        System.out.println("Hasta acá todo ok");
//        //Falla el calculo del promedio general por la condicion del if
//        o.bibliotecaBase.PromedioGeneralLibros();
//        System.out.println(o.bibliotecaBase.getInicioB().getLibros().getInicioL().getCalifPromedio());
//        System.out.println("Hasta acá todo ok 2");
//        o.listarLibrosBiblioteca("Prueba");
//        System.out.println("Hasta acá todo ok 3");
    }

    public static void juegodeprueba(Obligatorio o, Prueba p) {

//         PUNTO 2.1
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
//
//         PUNTO 2.3
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Primera");
        p.ver(o.registrarBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Segunda");
        p.ver(o.registrarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Tercera");
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "Ya esta la biblioteca: Primera"); //Prueba repetido
        p.ver(o.registrarBiblioteca("Biblioteca Nacional").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Biblioteca Nacional"); //Prueba repetido

//        PUNTO 2.12
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);
//
//         PUNTO 2.4
        p.ver(o.eliminarBiblioteca("Biblioteca Nacional").resultado, Retorno.Resultado.OK, "Se elimino la biblioteca: Biblioteca Nacional"); //Eliminar la tercera
        p.ver(o.eliminarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se elimino la biblioteca: Tercera"); //Eliminar la tercera
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);
//         PUNTO 2.5
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 2).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda2", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda2 a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda3", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda3 a biblioteca: Primera");
        p.ver(o.registrarLibro("Mistborne", "Brandon", "Segunda", 5).resultado, Retorno.Resultado.OK, "Se agrego el libro: Mistborne a biblioteca: Segunda");
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca: Primera ya tiene este libro"); //Prueba la biblioteca ya tiene el libro
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Papacito", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca no existe - papacito");   //Prueba no existe la biblioteca
//
//        //validamos libros por biblioteca
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Listar libros Biblioteca" + o.listarLibrosBiblioteca("Primera").valorString);
        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Listar libros Biblioteca" + o.listarLibrosBiblioteca("Segunda").valorString);
        p.ver(o.listarLibrosBiblioteca("Biblioteca Nacional").resultado, Retorno.Resultado.ERROR, "biblioteca inexistente ");
        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.ERROR, "biblioteca inexistente ");

//
////        // PUNTO 2.6    
        p.ver(o.eliminarLibro("Zelda3", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Se elimino libro: Zelda3 de biblioteca: Primera");  //Eliminar el ultimo
//        // validamos que la biblioteca tiene un libro menos
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
////
////        // PUNTO 2.7
////        // ranking antes de calificar
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
////o.RegistrarCalificacion(titulo, editorial, 0, biblioteca, comentario)

        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.OK, "Calicicacion de libro correcamente");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", -3, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
        p.ver(o.RegistrarCalificacion("Mistborne", "Brandon", 4, "Segunda", "Muy bueno").resultado, Retorno.Resultado.OK, "Se califico correctamente");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", -1, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
        p.ver(o.RegistrarCalificacion("No existo", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Libro no esta en la biblioteca");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 5, "Primera", "Traigan la continuacion de Zelda").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 3, "Primera", "Buena atencion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 3, "Primera", "Mejor el primer libro").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 4, "Primera", "Poca iluminacion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda3", "Nintendo", 5, "Primera", "Todo exelente").resultado, Retorno.Resultado.ERROR, "Se agrego calificacion al libro: Zelda3 no existe en la bib primera");
//
//        // ranking despues de calificar
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
//
//        // PUNTO 2.8    
//        // antes de comenzar las reservas
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
        p.ver(o.realizarReserva(23, 2, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");
        p.ver(o.realizarReserva(1, 3, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");
//
//        // cuando estan todas las reservas de ejemplares    
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
        p.ver(o.realizarReserva(2, 4, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");
        p.ver(o.realizarReserva(3, 5, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");
//
//        //cuando me excedi en las reservas    
//        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
        p.ver(o.realizarReserva(4, 6, "Primera", "No existo", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.ERROR, "No existe el libro en la biblioteca");
//
//        // PUNTO 2.4 Pero con reservas
        p.ver(o.eliminarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "La biblioteca Primera tiene reservas");//Prueba eliminar con reservas
//
//        // PUNTO 2.9
//        p.ver(o.cancelarReserva(23, 2, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva"); //Cancela reserva se carga de espera
//
//        //vemos la lista de espera luego de cancelar una reserva 
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
//
//        //    p.ver(o.cancelarReserva(3, 5, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva en la lista de espera"); //Cancela de la lista de espera
        p.ver(o.cancelarReserva(33, 15, "Tercera").resultado, Retorno.Resultado.ERROR, "No existe la reserva en la biblioteca"); //Prueba no existe la reserva
//
//        // PUNTO 2.10
        p.ver(o.listarLibros("Primera2").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca Primera2");   //Prueba no existe la biblioteca
        p.ver(o.listarLibros("Tercera").resultado, Retorno.Resultado.ERROR, o.listarLibros("Tercera").valorString); //Prueba no tiene libros
        p.ver(o.listarLibros("Primera").resultado, Retorno.Resultado.OK, "Listar libros primera " + o.listarLibros("Primera").valorString);
        p.ver(o.listarLibros("Segunda").resultado, Retorno.Resultado.OK, "Listar libros segunda " + o.listarLibros("Segunda").valorString);
//
//        // PUNTO 2.11
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Segunda").valorString);
        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.ERROR, o.listarLibrosBiblioteca("Tercera").valorString);

//        // PUNTO 2.13
        p.ver(o.listarComentarios("Primera").resultado, Retorno.Resultado.OK, "Lista comentarios" + o.listarComentarios("Primera").valorString);
        p.ver(o.listarComentarios("No existo").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca");
        p.ver(o.listarComentarios("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarComentarios("Segunda").valorString);
//
//        // PUNTO 2.12
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);
//
//        // PUNTO 2.14    
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
        p.ver(o.listarEspera("Zelda2", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "test test" + o.listarEspera("Zelda2", "Nintendo", "Primera").valorString);
        p.ver(o.listarEspera("No existo", "Nintendo", "Primera").resultado, Retorno.Resultado.ERROR, "No existe el titulo No existo de la editorial Nintendo en la biblioteca Primera");
//
//        // PUNTO 2.2
//        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
        p.ver(o.listarComentarios("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarComentarios("Segunda").valorString);
//
        p.imprimirResultadosPrueba();
    }

    public static void juegodeprueba1(Obligatorio o, Prueba p) {

        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
        p.ver(o.registrarBiblioteca("Biblioteca Nacional").resultado, Retorno.Resultado.OK, "se registra biblioteca nacional");
        p.ver(o.registrarBiblioteca("Biblioteca Nacional").resultado, Retorno.Resultado.ERROR, " no se agrega Biblioteca Nacional por estar repetida ");
        p.ver(o.registrarBiblioteca("ORT").resultado, Retorno.Resultado.OK, "  se agrega biblioeca ORT ");
        p.ver(o.registrarBiblioteca("biblioteca xxx").resultado, Retorno.Resultado.OK, "  se agrega biblioeca xxx ");

//        // listao las bibloteca para ver si quedo bien
//        System.out.println("listamos bibliotecas antes de eliminar bib xxx");
//        UDF.listarbibliotecas(o.getLBib());
//        p.ver(o.eliminarBiblioteca("biblioteca xxx").resultado, Retorno.Resultado.OK, "se elimina la bib xxx");
//
//        // listamos luego de eliminar para ver si hizo la operacion
//        System.out.println("listamos bibliotecas despues  de eliminar bib xxx");
//        UDF.listarbibliotecas(o.getLBib());
//
//        p.ver(o.registrarLibro("Algoritmos", "Editorial xxx", "ORT", 3).resultado, Retorno.Resultado.OK, " se agrego el libro algoritmos con 3 ejemplares");
//        p.ver(o.registrarLibro("Algoritmos", "Editorial xxx", "ORT", 5).resultado, Retorno.Resultado.ERROR, " Se intenta agregar un libro que ya existe");
//        p.ver(o.registrarLibro("Base de datos", "Editorial xxx", "ORT", 5).resultado, Retorno.Resultado.OK, " se agrego el libro base de datos con 5 ejemplares");
//        p.ver(o.registrarLibro("Programacion", "Editorial xxx", "Biblioteca Nacional", 5).resultado, Retorno.Resultado.OK, " se agrego el libro programacion con 5 ejemplares");
//
//        System.out.println("Listado de biblioteca con sus libros antes de borrar base de datos");
//        UDF.listarBibLib(o.getLBib());
//
//        System.out.println("COMENZAMOS A RESERVAR LIBRO ALGORITMOS - TIENE 3 EJEMPLARES");
//        p.ver(o.realizarReserva(1, 1, "ORT", "Algoritmos", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se reserva el primer ejemplar de  libro de Algoritmos en biblioteca OrT");
//        p.ver(o.realizarReserva(2, 2, "ORT", "Algoritmos", "Editorial xxx", "05-11-2021").resultado, Retorno.Resultado.OK, "Se reserva segundo ejemplar del libro de Algoritmos bib ORT");
//        p.ver(o.realizarReserva(3, 3, "ORT", "Algoritmos", "Editorial xxx", "05-11-2021").resultado, Retorno.Resultado.OK, "Se reserva tercer ejemplar del libro de Algoritmos bib ORT");
//
//        System.out.println("Mostrar listado de reservas del libro algoritmos antes de sobrepasar limite");
//
//        p.ver(o.realizarReserva(4, 4, "ORT", "Algoritmos", "Editorial xxx", "05-11-2021").resultado, Retorno.Resultado.OK, "El cupo esta lleno, debe quedar en cola de espera");
//
//        System.out.println("Mostrar listado de reservas del libro algoritmos despues de sobrepasar limite");
//
//        p.ver(o.eliminarLibro("Base de datos", "Editorial xxx", "ORT").resultado, Retorno.Resultado.ERROR, "Se elimina libro base de datos bib OET");
//        System.out.println("Listado de biblioteca con sus libros antes de borrar base de datos");
//        UDF.listarBibLib(o.getLBib());
//
//        p.ver(o.eliminarLibro("Algoritmos", "Editorial xxx", "ORT").resultado, Retorno.Resultado.ERROR, "No se pudo eliminar libro , tiene reservas");
//
//        UDF.listarBibLib(o.getLBib());
        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
        p.imprimirResultadosPrueba();
    }

    public static void juegodeprueba2(Obligatorio o, Prueba p) {
// PUNTO 2.1
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");

// PUNTO 2.3
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Primera");
        p.ver(o.registrarBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Segunda");
        p.ver(o.registrarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Tercera");
        p.ver(o.registrarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "Ya esta la biblioteca: Primera"); //Prueba repetido

        //PUNTO 2.12
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);

// PUNTO 2.4
        p.ver(o.eliminarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se elimino la biblioteca: Tercera"); //Eliminar la tercera
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "" + o.listarBibliotecaRanking().valorString);
        p.ver(o.registrarBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Se agrego la biblioteca: Tercera");

// PUNTO 2.5
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 2).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda2", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda2 a biblioteca: Primera");
        p.ver(o.registrarLibro("Zelda3", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.OK, "Se agrego el libro: Zelda3 a biblioteca: Primera");
        p.ver(o.registrarLibro("Mistborne", "Brandon", "Segunda", 5).resultado, Retorno.Resultado.OK, "Se agrego el libro: Mistborne a biblioteca: Segunda");
        p.ver(o.registrarLibro("Zelda", "Nintendo", "Primera", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca: Primera ya tiene este libro"); //Prueba la biblioteca ya tiene el libro
        p.ver(o.registrarLibro("Zelda", "Nintendo", "NoExisto", 10).resultado, Retorno.Resultado.ERROR, "La biblioteca no existe");   //Prueba no existe la biblioteca

        //validamos libros por biblioteca
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Segunda").valorString);
        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.ERROR, "biblioteca inexistente " + o.listarLibrosBiblioteca("Tercera").valorString);

// PUNTO 2.6    
        p.ver(o.eliminarLibro("Zelda3", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Se elimino libro: Zelda3 de biblioteca: Primera");  //Eliminar el ultimo
// validamos que la biblioteca tiene un libro menos
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);

// PUNTO 2.7
// ranking antes de calificar
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);

        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 6, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.OK, "Se registro la calificaion");
        p.ver(o.RegistrarCalificacion("Mistborne", "Brandon", 4, "Segunda", "Muy bueno").resultado, Retorno.Resultado.OK, "Se califico correctamente");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", -1, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Calificacion fuera de rango de puntuacion");
        p.ver(o.RegistrarCalificacion("No existo", "Nintendo", 4, "Primera", "Muy bueno").resultado, Retorno.Resultado.ERROR, "Libro no esta en la biblioteca");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 5, "Primera", "Traigan la continuacion de Zelda").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda", "Nintendo", 3, "Primera", "Buena atencion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 3, "Primera", "Mejor el primer libro").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda2", "Nintendo", 4, "Primera", "Poca iluminacion").resultado, Retorno.Resultado.OK, "Se agrego calificacion al libro: Zelda2 de la biblioteca: Primera");
        p.ver(o.RegistrarCalificacion("Zelda3", "Nintendo", 5, "Primera", "Todo exelente").resultado, Retorno.Resultado.ERROR, "Se agrego calificacion al libro: Zelda3 no existe en la bib primera");

        // ranking despues de calificar
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);

// PUNTO 2.8    
// antes de comenzar las reservas
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);

        p.ver(o.realizarReserva(23, 2, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");
        p.ver(o.realizarReserva(1, 3, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se realizo la reserva");

// cuando estan todas las reservas de ejemplares    
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);

        p.ver(o.realizarReserva(2, 4, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");
        p.ver(o.realizarReserva(3, 5, "Primera", "Zelda", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.OK, "Se agrego a la lista de espera");

//cuando me excedi en las reservas    
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);

        p.ver(o.realizarReserva(4, 6, "Primera", "No existo", "Nintendo", "26/10/2021").resultado, Retorno.Resultado.ERROR, "No existe el libro en la biblioteca");

// PUNTO 2.4 Pero con reservas
        p.ver(o.eliminarBiblioteca("Primera").resultado, Retorno.Resultado.ERROR, "La biblioteca Primera tiene reservas");//Prueba eliminar con reservas

// PUNTO 2.9
        p.ver(o.cancelarReserva(23, 2, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva"); //Cancela reserva se carga de espera

//vemos la lista de espera luego de cancelar una reserva 
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);

//    p.ver(o.cancelarReserva(3, 5, "Primera").resultado, Retorno.Resultado.OK, "Se cancelo la reserva en la lista de espera"); //Cancela de la lista de espera
        p.ver(o.cancelarReserva(33, 15, "Tercera").resultado, Retorno.Resultado.ERROR, "No existe la reserva en la biblioteca"); //Prueba no existe la reserva

// PUNTO 2.10
        p.ver(o.listarLibros("Primera2").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca Primera2");   //Prueba no existe la biblioteca
        p.ver(o.listarLibros("Tercera").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Tercera").valorString); //Prueba no tiene libros
        p.ver(o.listarLibros("Primera").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Primera").valorString);
        p.ver(o.listarLibros("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarLibros("Segunda").valorString);

// PUNTO 2.11
        p.ver(o.listarLibrosBiblioteca("Primera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Primera").valorString);
        p.ver(o.listarLibrosBiblioteca("Segunda").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Segunda").valorString);
        p.ver(o.listarLibrosBiblioteca("Tercera").resultado, Retorno.Resultado.OK, "Calificacion libros" + o.listarLibrosBiblioteca("Tercera").valorString);

// PUNTO 2.13
        p.ver(o.listarComentarios("Primera").resultado, Retorno.Resultado.OK, "Lista comentarios" + o.listarComentarios("Primera").valorString);
        p.ver(o.listarComentarios("No existo").resultado, Retorno.Resultado.ERROR, "No existe la biblioteca");
        p.ver(o.listarComentarios("Segunda").resultado, Retorno.Resultado.OK, "" + o.listarComentarios("Segunda").valorString);

// PUNTO 2.12
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Bibliotecas ordenadas por ranking" + o.listarBibliotecaRanking().valorString);

// PUNTO 2.14    
        p.ver(o.listarEspera("Zelda", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda", "Nintendo", "Primera").valorString);
        p.ver(o.listarEspera("Zelda2", "Nintendo", "Primera").resultado, Retorno.Resultado.OK, "Lista espera" + o.listarEspera("Zelda2", "Nintendo", "Primera").valorString);
        p.ver(o.listarEspera("No existo", "Nintendo", "Primera").resultado, Retorno.Resultado.ERROR, "No existe el titulo No existo de la editorial Nintendo en la biblioteca Primera");

        // PUNTO 2.2
        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");

    }
    
    public static void juegodeprueba3(Obligatorio o, Prueba p) {
        
        p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
       
        p.imprimirComentario("-----------------------------------------------------------------------");       
        p.imprimirComentario("REISTRO DE BIBLIOTECAS");
        p.imprimirComentario("-----------------------------------------------------------------------");
        p.imprimirComentario("Se agrega: Bib Nacional, Bib ORT, Bib xxx ");
        p.imprimirComentario("-----------------------------------------------------------------------");

        
        // casos ok
        p.ver(o.registrarBiblioteca("Bib Nacional").resultado, Retorno.Resultado.OK,"Se agrego biblioteca nacional" );
        p.ver(o.registrarBiblioteca("Bib ORT").resultado, Retorno.Resultado.OK," Se agrega biblioeca ORT " );
        p.ver(o.registrarBiblioteca("Bib xxx").resultado, Retorno.Resultado.OK," Se agrega biblioeca XXX " );
        
// casos error        
        p.ver(o.registrarBiblioteca("Bib Nacional").resultado, Retorno.Resultado.ERROR," No se agrega Bib Nacional por estar repetida " );

        p.imprimirComentario("-----------------------------------------------------------------------");        
        p.imprimirComentario("LISTADO  DE BIBLIOTECAS REGISTRADAS");
        p.imprimirComentario("-----------------------------------------------------------------------");

        o.bibliotecaBase.mostrarREC();
        
        p.imprimirComentario("-----------------------------------------------------------------------");       
        p.imprimirComentario("SE BORRA BIBLIOTECA XXX");
        p.imprimirComentario("-----------------------------------------------------------------------");

        p.ver(o.eliminarBiblioteca("Bib xxx").resultado, Retorno.Resultado.OK, "Se elimina Bib xxx corrctamente");

        p.imprimirComentario("-----------------------------------------------------------------------");       
        p.imprimirComentario("REISTRO DE BIBLIOTECAS LUEGO DE BORRAR BIBLIOTECA XXX");
        p.imprimirComentario("-----------------------------------------------------------------------");
        
        o.bibliotecaBase.mostrarREC();
        
        p.imprimirComentario("-----------------------------------------------------------------------");
        
        p.imprimirComentario("REGISTRAMOS LIBROS ");        
        p.imprimirComentario("Se registran los libros: Algoritmos, Base de datos, Diseño, Programacion");
        p.imprimirComentario("-----------------------------------------------------------------------");
        
        p.ver(o.registrarBiblioteca("Bib xxx").resultado, Retorno.Resultado.OK," Se agrega biblioeca XXX " );

        
        p.ver(o.registrarLibro("Algoritmos", "Editorial xxx", "Bib ORT", 3).resultado, Retorno.Resultado.OK, " se agrego el libro algoritmos con 3 ejemplares");
        p.ver(o.registrarLibro("Algoritmos", "Editorial xxx", "Bib ORT", 3).resultado, Retorno.Resultado.ERROR, "No se agrego el libro algoritmos en bib ORT porque ya existe ");
        p.ver(o.registrarLibro("Base de datos","Editorial xxx", "Bib ORT", 5).resultado, Retorno.Resultado.OK, " Se agrego el libro base de datos con 5 ejemplares");
        p.ver(o.registrarLibro("Programacion1", "Editorial xxx", "Bib Nacional", 2).resultado, Retorno.Resultado.OK, " se agrego el libro programacion1 con 2 ejemplares");
        p.ver(o.registrarLibro("Programacion2", "Editorial xxx", "Bib Nacional", 2).resultado, Retorno.Resultado.OK, " se agrego el libro programacion2 con 2 ejemplares");
        p.ver(o.registrarLibro("Programacion3", "Editorial xxx", "Bib Nacional", 2).resultado, Retorno.Resultado.OK, " se agrego el libro programacion3 con 2 ejemplares");

        p.ver(o.registrarLibro("Programacion", "Editorial xxx", "Bib xxx", 2).resultado, Retorno.Resultado.OK, " se agrego el libro programacion con 2 ejemplares");

        
        p.ver(o.registrarLibro("Diseño", "Editorial xxx", "Bib ORT", 2).resultado, Retorno.Resultado.OK, " se agrego el libro Diseño con 2 ejemplares");      

        p.imprimirComentario("-----------------------------------------------------------------------");        
        p.imprimirComentario("Lista de libros por biblioteca");
        //UDF.listarBibLib(o.getLBib());
        p.imprimirComentario("-----------------------------------------------------------------------");

        p.imprimirComentario("Se imprime lista de libros de Bib Nacional");
        p.ver(o.listarLibrosBiblioteca("Bib Nacional").resultado, Retorno.Resultado.OK,"Libros de la bib Nacional" );
        p.imprimirComentario("Se imprime lista de libros de Bib ORT");
        p.ver(o.listarLibrosBiblioteca("Bib ORT").resultado, Retorno.Resultado.OK,"Libros de la bib ORT" );
        
        p.ver(o.eliminarLibro("Base de datos", "Editorial xxx", "Bib ORT").resultado, Retorno.Resultado.OK, "se elimina libro Base de datos bib ORT");
        p.ver(o.listarLibrosBiblioteca("Bib ORT").resultado, Retorno.Resultado.OK, "Libros bib ort luego de borrar base de datos");
        
        // este metodo no esta en la interface
        //o.listarBibLib(o.li);
        
        p.imprimirComentario("COMENZAMOS A HACE RESERVAS");

        p.imprimirComentario("Antes de las reservas listamos reservas del libro algoritmos de bib ort");
        //o.bibliotecaBase.obtenerElemento("Bib ORT").getLibros().obtenerElemento("Algoritmos").getLR().mostrar();
        p.imprimirComentario("Antes de las reservas listamos cola de espera de libro algoritmos de bib ort");
        //System.out.println("Cola de espera vacia = "+ o.bibliotecaBase.obtenerElemento("Bib ORT").getLLib().obtenerElemento("Algoritmos").getCE().esVacia());
                 
        p.ver(o.realizarReserva(1, 1, "Bib ORT", "Algoritmos", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Programacion1 (ej1) en biblioteca Nacional");
        p.ver(o.realizarReserva(2, 2, "Bib ORT", "Algoritmos", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Programacion1 (ej2) en biblioteca Nacional");
        p.ver(o.realizarReserva(3, 3, "Bib ORT", "Algoritmos", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Programacion1 (ej3) en biblioteca Nacional");
        
        p.ver(o.realizarReserva(4, 4, "Bib ORT", "Algoritmos", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Algoritmos (ej4) en biblioteca OrT");
       
        
        p.ver(o.realizarReserva(1, 1, "Bib Nacional", "Programacion1", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Algoritmos (ej1) en biblioteca OrT");
        p.ver(o.realizarReserva(1, 2, "Bib Nacional", "Programacion1", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Algoritmos (ej1) en biblioteca OrT");

        p.ver(o.realizarReserva(2, 2, "Bib Nacional", "Programacion2", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Algoritmos (ej2) en biblioteca OrT");
        p.ver(o.realizarReserva(3, 3, "Bib Nacional", "Programacion3", "Editorial xxx", "04-11-2021").resultado, Retorno.Resultado.OK, "Se agrego reserva al  libro de Algoritmos (ej3) en biblioteca OrT");
 
        
        
        p.imprimirComentario("Despues de las reservas listamos reservas del libro algoritmos de bib ort");
        //o.bibliotecaBase.obtenerElemento("Bib ORT").getLLib().obtenerElemento("Algoritmos").getLR().mostrar();

        p.imprimirComentario("Despues de las reservas listamos cola de espera de libro algoritmos de bib ort");        
        //System.out.println("Cola de espera vacia = "+ o.LBib.obtenerElemento("Bib ORT").getLLib().obtenerElemento("Algoritmos").getCE().esVacia());

        p.ver(o.RegistrarCalificacion("Algoritmos", "Editorial xxx", 4, "Bib ORT", "buena atencion").resultado, Retorno.Resultado.OK, "calificacion 4 algoritmos bib ort");
        p.ver(o.RegistrarCalificacion("Algoritmos", "Editorial xxx", 5, "Bib ORT", "muy buena atencion").resultado, Retorno.Resultado.OK, "calificacion 5 algoritmos bib ort");
        p.ver(o.RegistrarCalificacion("Algoritmos", "Editorial xxx", 4, "Bib ORT", "atencion correcta").resultado, Retorno.Resultado.OK, "calificacion 4 algoritmos bib ort");
        p.ver(o.RegistrarCalificacion("Diseño", "Editorial xxx", 5, "Bib ORT", "Libro recomendable").resultado, Retorno.Resultado.OK, "calificacion 5 diseño bib ort");
        p.ver(o.RegistrarCalificacion("Base de datos", "Editorial xxx", 3, "Bib ORT", "buena atencion").resultado, Retorno.Resultado.ERROR, "calificacion 3 base de datos bib ort");
        
        p.ver(o.RegistrarCalificacion("Programacion2", "Editorial xxx", 3, "Bib Nacional", "Libro aceptable").resultado, Retorno.Resultado.OK, "calificacion 3 algoritmos bib Nacional");
        p.ver(o.RegistrarCalificacion("Programacion3", "Editorial xxx", 2, "Bib Nacional", "No lo recomiendo").resultado, Retorno.Resultado.OK, "calificacion 2 algoritmos bib Nacional");
        p.ver(o.RegistrarCalificacion("Programacion2", "Editorial xxx", 3, "Bib Nacional", "aceptable").resultado, Retorno.Resultado.OK, "calificacion 3 algoritmos bib Nacional");
       
        p.ver(o.listarBibliotecaRanking().resultado, Retorno.Resultado.OK, "Ranking");       
        p.ver(o.listarComentarios("Bib ORT").resultado, Retorno.Resultado.OK, "comentarios ORT");
        
        p.ver(o.listarLibros("Bib ORT").resultado, Retorno.Resultado.OK, "Libros bib ort");
        
        p.ver(o.cancelarReserva(1, 1, "Bib ORT").resultado, Retorno.Resultado.OK, "se cancela reservca 1 cliente 1 bib ort");
        p.ver(o.mostrarReservasBiblioteca().resultado, Retorno.Resultado.OK, "Reservas ORT");
//        p.ver(o.eliminarLibro("Algoritmos", "Editorial xxx", "ORT").resultado, Retorno.Resultado.ERROR, "No se pudo eliminar libro , tiene reservas");
//        
//        p.ver(o.eliminarLibro("Base de datos", "Editorial xxx", "ORT").resultado, Retorno.Resultado.ERROR, "Se elimina libro base de datos bib OET");
      
//        UDF.listarBibLib(o.getLBib());
//        UDF.listarReservasBib(o.getLBib());
        p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");  
        p.imprimirResultadosPrueba();

    }
}
