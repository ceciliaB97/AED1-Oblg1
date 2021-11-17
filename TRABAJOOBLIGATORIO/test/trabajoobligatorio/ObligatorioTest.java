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
 * @author Usuario
 */
public class ObligatorioTest {
    
    public ObligatorioTest() {
    }

    /**
     * Test of crearSistemaReservas method, of class Obligatorio.
     */
    @Test
    public void testCrearSistemaReservas() {
        System.out.println("crearSistemaReservas");
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.crearSistemaReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destruirSistemaReservas method, of class Obligatorio.
     */
    @Test
    public void testDestruirSistemaReservas() {
        System.out.println("destruirSistemaReservas");
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.destruirSistemaReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarBiblioteca method, of class Obligatorio.
     */
    @Test
    public void testRegistrarBiblioteca() {
        System.out.println("registrarBiblioteca");
        String Biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.registrarBiblioteca(Biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarBiblioteca method, of class Obligatorio.
     */
    @Test
    public void testEliminarBiblioteca() {
        System.out.println("eliminarBiblioteca");
        String Biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.eliminarBiblioteca(Biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarLibro method, of class Obligatorio.
     */
    @Test
    public void testRegistrarLibro() {
        System.out.println("registrarLibro");
        String titulo = "";
        String editorial = "";
        String biblioteca = "";
        int ejemplares = 0;
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.registrarLibro(titulo, editorial, biblioteca, ejemplares);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarLibro method, of class Obligatorio.
     */
    @Test
    public void testEliminarLibro() {
        System.out.println("eliminarLibro");
        String titulo = "";
        String editorial = "";
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.eliminarLibro(titulo, editorial, biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistrarCalificacion method, of class Obligatorio.
     */
    @Test
    public void testRegistrarCalificacion() {
        System.out.println("RegistrarCalificacion");
        String titulo = "";
        String editorial = "";
        int calificacion = 0;
        String biblioteca = "";
        String comentario = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.RegistrarCalificacion(titulo, editorial, calificacion, biblioteca, comentario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarReserva method, of class Obligatorio.
     */
    @Test
    public void testRealizarReserva() {
        System.out.println("realizarReserva");
        int cliente = 0;
        int numero = 0;
        String biblioteca = "";
        String título = "";
        String editorial = "";
        String fecha = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.realizarReserva(cliente, numero, biblioteca, título, editorial, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarReserva method, of class Obligatorio.
     */
    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        int cliente = 0;
        int numero = 0;
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.cancelarReserva(cliente, numero, biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLibros method, of class Obligatorio.
     */
    @Test
    public void testListarLibros() {
        System.out.println("listarLibros");
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.listarLibros(biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarLibrosBiblioteca method, of class Obligatorio.
     */
    @Test
    public void testListarLibrosBiblioteca() {
        System.out.println("listarLibrosBiblioteca");
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.listarLibrosBiblioteca(biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarBibliotecaRanking method, of class Obligatorio.
     */
    @Test
    public void testListarBibliotecaRanking() {
        System.out.println("listarBibliotecaRanking");
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.listarBibliotecaRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarComentarios method, of class Obligatorio.
     */
    @Test
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.listarComentarios(biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarEspera method, of class Obligatorio.
     */
    @Test
    public void testListarEspera() {
        System.out.println("listarEspera");
        String titulo = "";
        String editorial = "";
        String biblioteca = "";
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.listarEspera(titulo, editorial, biblioteca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarReservasBiblioteca method, of class Obligatorio.
     */
    @Test
    public void testMostrarReservasBiblioteca() {
        System.out.println("mostrarReservasBiblioteca");
        Obligatorio instance = new Obligatorio();
        Retorno expResult = null;
        Retorno result = instance.mostrarReservasBiblioteca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
