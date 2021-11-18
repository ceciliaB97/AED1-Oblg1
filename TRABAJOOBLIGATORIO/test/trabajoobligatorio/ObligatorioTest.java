package trabajoobligatorio;

import Clases.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObligatorioTest {

    public ObligatorioTest() {
    }

//    @Test
//    public void testCrearSistemaReservas() {
//        System.out.println("crearSistemaReservas");
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.crearSistemaReservas().resultado;
//        assertEquals(expResult, result); 
//    }   
//    
//    @Test
//    public void testRegistrarBiblioteca() {
//        System.out.println("registrarBiblioteca");        
//        String Biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.registrarBiblioteca(Biblioteca).resultado;
//        assertEquals(expResult, result);        
//    }
////
//    
//    @Test
//    public void testEliminarBiblioteca() {
//        System.out.println("eliminarBiblioteca");
//        String Biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.eliminarBiblioteca(Biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//
//    
//    @Test
//    public void testRegistrarLibro() {
//        System.out.println("registrarLibro");
//        String titulo = "Libro";
//        String editorial = "Editorial";
//        String biblioteca = "Biblioteca";
//        int ejemplares = 0;
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.registrarLibro(titulo, editorial, biblioteca, ejemplares).resultado;
//        assertEquals(expResult, result);        
//    }
//
//    
//    @Test
//    public void testEliminarLibro() {
//        System.out.println("eliminarLibro");
//        String titulo = "Libro";
//        String editorial = "Editorial";
//        String biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.eliminarLibro(titulo, editorial, biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//
//    
//    @Test
//    public void testRegistrarCalificacion() {
//        System.out.println("RegistrarCalificacion");
//        String titulo = "Libro";
//        String editorial = "Editorial";
//        int calificacion = 3;
//        String biblioteca = "Biblioteca";
//        String comentario = "Comentario";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.RegistrarCalificacion(titulo, editorial, calificacion, biblioteca, comentario).resultado;
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testRealizarReserva() {
//        System.out.println("realizarReserva");
//        int cliente = 1;
//        int numero = 1;
//        String biblioteca = "Biblioteca";
//        String título = "Libro";
//        String editorial = "Editorial";
//        String fecha = "01/01/2021";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.realizarReserva(cliente, numero, biblioteca, título, editorial, fecha).resultado;
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testCancelarReserva() {
//        System.out.println("cancelarReserva");
//        int cliente = 1;
//        int numero = 1;
//        String biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno result = instance.cancelarReserva(cliente, numero, biblioteca);
//        assertEquals(expResult, result);
//    }    
//
//  
//    @Test
//    public void testListarLibros() {
//        System.out.println("listarLibros");
//        String biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.listarLibros(biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//
//    
//    @Test
//    public void testListarLibrosBiblioteca() {
//        System.out.println("listarLibrosBiblioteca");
//        String biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.listarLibrosBiblioteca(biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//   
//    @Test
//    public void testListarBibliotecaRanking() {
//        System.out.println("listarBibliotecaRanking");
//        Obligatorio instance = new Obligatorio();
//        Retorno expResult = null;
//        Retorno result = instance.listarBibliotecaRanking();
//        assertEquals(expResult, result);
//    }
//  
//    @Test
//    public void testListarComentarios() {
//        System.out.println("listarComentarios");
//        String biblioteca = "Biblioteca";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.listarComentarios(biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testListarEspera() {
//        System.out.println("listarEspera");
//        String titulo = "";
//        String editorial = "";
//        String biblioteca = "";
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.listarEspera(titulo, editorial, biblioteca).resultado;
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testMostrarReservasBiblioteca() {
//        System.out.println("mostrarReservasBiblioteca");
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.mostrarReservasBiblioteca().resultado;
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testDestruirSistemaReservas() {
//        System.out.println("destruirSistemaReservas");
//        Obligatorio instance = new Obligatorio();
//        Retorno.Resultado expResult = Retorno.Resultado.OK;
//        Retorno.Resultado result = instance.destruirSistemaReservas().resultado;
//        assertEquals(expResult, result);        
//    }
    @Test
    public void TestObligatorio() {

        System.out.println("crearSistemaReservas");
        Obligatorio instance = new Obligatorio();
        Retorno.Resultado expResult = Retorno.Resultado.OK;
        Retorno.Resultado result = instance.crearSistemaReservas().resultado;
        assertEquals(expResult, result);

        System.out.println("registrarBiblioteca");
    String biblioteca = "Biblioteca";
        Retorno.Resultado result1 = instance.registrarBiblioteca(biblioteca).resultado;
        assertEquals(expResult, result1);

        System.out.println("registrarLibro");
        String titulo = "Libro";
        String editorial = "Editorial";
        
        int ejemplares = 1;
        Retorno.Resultado result3 = instance.registrarLibro(titulo, editorial, biblioteca, ejemplares).resultado;
        assertEquals(expResult, result3);
        
        System.out.println("RegistrarCalificacion");
        int calificacion = 3;
        String comentario = "Comentario";
        Retorno.Resultado result5 = instance.RegistrarCalificacion(titulo, editorial, calificacion, biblioteca, comentario).resultado;
        assertEquals(expResult, result5);

        System.out.println("realizarReserva");
        int cliente = 1;
        int numero = 1;
        String fecha = "01/01/2021";
        Retorno.Resultado result6 = instance.realizarReserva(cliente, numero, biblioteca, titulo, editorial, fecha).resultado;
        assertEquals(expResult, result6);
        Retorno.Resultado resultX = instance.realizarReserva(cliente, 2, biblioteca, titulo, editorial, fecha).resultado;
        assertEquals(expResult, resultX);

        System.out.println("listarLibros");
        Retorno.Resultado result8 = instance.listarLibros(biblioteca).resultado;
        assertEquals(expResult, result8);

        System.out.println("listarLibrosBiblioteca");
        Retorno.Resultado result9 = instance.listarLibrosBiblioteca(biblioteca).resultado;
        assertEquals(expResult, result9);

        System.out.println("listarBibliotecaRanking");
        Retorno.Resultado result10 = instance.listarBibliotecaRanking().resultado;
        assertEquals(expResult, result10);

        System.out.println("listarComentarios");
        Retorno.Resultado result11 = instance.listarComentarios(biblioteca).resultado;
        assertEquals(expResult, result11);

        System.out.println("listarEspera");
        Retorno.Resultado result12 = instance.listarEspera(titulo, editorial, biblioteca).resultado;
        assertEquals(expResult, result12);

        System.out.println("mostrarReservasBiblioteca");
        Retorno.Resultado result13 = instance.mostrarReservasBiblioteca().resultado;
        assertEquals(expResult, result13);

        System.out.println("cancelarReserva");
        Retorno.Resultado result7 = instance.cancelarReserva(cliente, 2, biblioteca).resultado;
        assertEquals(expResult, result7);

        System.out.println("eliminarLibro");
        Retorno.Resultado result4 = instance.eliminarLibro(titulo, editorial, biblioteca).resultado;
        assertEquals(expResult, result4);

        System.out.println("eliminarBiblioteca");
        Retorno.Resultado result2 = instance.eliminarBiblioteca(biblioteca).resultado;
        assertEquals(expResult, result2);

        System.out.println("destruirSistemaReservas");
        Retorno.Resultado result14 = instance.destruirSistemaReservas().resultado;
        assertEquals(expResult, result14);

    }

}
