/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoobligatorio;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ferna
 */
public class ObligatorioTest {

    Retorno.Resultado Ok;
    Retorno.Resultado Error;
    Retorno.Resultado test;

    String tituloValido;
    String tituloNoValido;
    String editorial;
    String biblioteca;
    int cliente;
    int ejemplares;
    String fecha;
    String bibliotecaNoExiste;
    int calificacionValida;
    int calificacionNoValida;
    int reservaValida;
    int reservaNoValida;

    Obligatorio instance;

    public ObligatorioTest() {
        Ok = Retorno.Resultado.OK;
        Error = Retorno.Resultado.ERROR;
        tituloValido = "Libro Prueba";
        tituloNoValido = "Libro No existe";
        editorial = "Editorial Prueba";
        biblioteca = "Biblioteca";
        bibliotecaNoExiste = "Biblioteca No Existe";
        calificacionValida = 4;
        calificacionNoValida = 15;
        instance = new Obligatorio();
        reservaValida = 1;
        reservaNoValida = 2;
        fecha = "11/12/2021";
        cliente = 1;
        ejemplares = 3;

    }

    @Test
    public void testCrearSistemaReservas() {
        System.out.println("crearSistemaReservas");

        this.test = instance.crearSistemaReservas().resultado;
        assertEquals(this.Ok, this.test);
    }

//////
//    @Test
    public void testRegistrarBiblioteca() {
        System.out.println("registrarBiblioteca");

        instance.crearSistemaReservas();

        this.test = instance.registrarBiblioteca(biblioteca).resultado;
        assertEquals(this.Ok, test);
        this.test = instance.registrarBiblioteca(biblioteca).resultado;

        assertEquals(this.Error, test);

    }
//

    @Test
    public void testRegistrarLibro() {
        System.out.println("registrarLibro");

        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);

        this.test = instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares).resultado;
        assertEquals(Ok, test);
        this.test = instance.registrarLibro(tituloValido, editorial, bibliotecaNoExiste, ejemplares).resultado;
        assertEquals(Error, test);

    }
////
//
////

    @Test
    public void testRegistrarCalificacion() {
        System.out.println("RegistrarCalificacion");

        String comentario = "Prueba Calificacion";
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);
        test = instance.RegistrarCalificacion(tituloValido, editorial, calificacionValida, this.biblioteca, comentario).resultado;
        assertEquals(Ok, test);
        test = instance.RegistrarCalificacion(tituloValido, editorial, calificacionValida, this.bibliotecaNoExiste, comentario).resultado;
        assertEquals(Error, test);
        test = instance.RegistrarCalificacion(tituloValido, editorial, calificacionNoValida, this.biblioteca, comentario).resultado;
        assertEquals(Error, test);

    }
//
//    @Test

    public void testRealizarReserva() {
        System.out.println("realizarReserva");

        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);

        test = instance.realizarReserva(cliente, reservaValida, biblioteca, tituloValido, editorial, fecha).resultado;
        assertEquals(Ok, test);
        test = instance.realizarReserva(cliente, reservaValida, biblioteca, this.tituloNoValido, editorial, fecha).resultado;
        assertEquals(Error, test);

    }
//

    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);
        instance.realizarReserva(cliente, reservaValida, biblioteca, tituloValido, editorial, fecha);
        test = instance.cancelarReserva(cliente, reservaValida, biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.cancelarReserva(cliente, reservaNoValida, biblioteca).resultado;
        assertEquals(Error, test);
    }
//

    @Test// falta mostrar mensaje biblioteca sin libros
    public void testListarLibros() {
        System.out.println("listarLibros");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);
        test = instance.listarLibros(biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.listarLibros(bibliotecaNoExiste).resultado;
        assertEquals(Error, test);

    }
//
//

    @Test
    public void testListarLibrosBiblioteca() {
        System.out.println("listarLibrosBiblioteca");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);
        test = instance.listarLibros(biblioteca).resultado;
        assertEquals(Ok, test);
    }

//
    @Test
    public void testListarBibliotecaRanking() {
        System.out.println("listarBibliotecaRanking");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);

        test = instance.listarBibliotecaRanking().resultado;
        assertEquals(Ok, test);
        ;
    }
//////
////

    @Test// revisar aunque no tenga libros deberia dar ok solo debe dar error con biblioteca no registrada
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);

        test = instance.listarComentarios(biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.listarComentarios(this.bibliotecaNoExiste).resultado;
        assertEquals(Error, test);

    }
//

    @Test
    // revisar prueba fallida
    public void testListarEspera() {
        System.out.println("listarEspera");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        test = instance.listarEspera(tituloValido, editorial, biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.listarEspera(tituloNoValido, editorial, biblioteca).resultado;
        assertEquals(Error, test);

    }
//
//
//    @Test
    // me mantiene en un bucle prueben en sus maquinas
//    public void testMostrarReservasBiblioteca() {
//        System.out.println("mostrarReservasBiblioteca");
//
//        instance.crearSistemaReservas();
//        instance.registrarBiblioteca(biblioteca);
//        test = instance.mostrarReservasBiblioteca().resultado;
//        assertEquals(Ok, test);
//
//    }

    @Test
    public void testEliminarLibro() {
        System.out.println("eliminarLibro");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        instance.registrarLibro(tituloValido, editorial, biblioteca, ejemplares);
        test = instance.eliminarLibro(tituloValido, editorial, biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.eliminarLibro(tituloNoValido, editorial, biblioteca).resultado;
        assertEquals(Error, test);

    }
//

    @Test
    public void testEliminarBiblioteca() {
        System.out.println("eliminarBiblioteca");
        instance.crearSistemaReservas();
        instance.registrarBiblioteca(biblioteca);
        test = instance.eliminarBiblioteca(biblioteca).resultado;
        assertEquals(Ok, test);
        test = instance.eliminarBiblioteca(this.bibliotecaNoExiste).resultado;
        assertEquals(Error, test);

    }
//

    @Test
    public void testDestruirSistemaReservas() {

        System.out.println("destruirSistemaReservas");

        instance.crearSistemaReservas();
        test = instance.destruirSistemaReservas().resultado;
        assertEquals(Ok, test);

    }
}
