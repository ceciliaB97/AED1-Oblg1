package trabajoobligatorio;

import Estructuras.Lista;
import Clases.*;

/**
 *
 * @author RAFAEL
 */
public class Obligatorio extends Lista implements IObligatorio {

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno registrarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se crea una biblioteca sin libros
        Biblioteca bibliotecaB = new Biblioteca(Biblioteca);
        ret.valorString = "Se creo la bilbioteca " + bibliotecaB.getNombre();
        ret.valorbooleano = true;
        return ret;
    }

    @Override
    public Retorno eliminarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se busca y se elimina
        Biblioteca b = new Biblioteca(Biblioteca);
        //si elimino devuelve true, si no false
        ret.valorbooleano = b.borrarElemento(b);
        ret.valorString = "Se eliminio biblioteca es " + ret.valorbooleano;
        return ret;
    }

    
    @Override
    public Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        Biblioteca b = new Biblioteca(biblioteca);
        ret.valorString = "No se puddo agregar";
        Biblioteca bEncontrada = b.obtenerElemento(b);
        if (bEncontrada != null) {

            Libro libro = new Libro(1, titulo, editorial, ejemplares);
            Libro libroBuscado = bEncontrada.getLibros().obtenerElemento(libro);

            if (libroBuscado != null) {
                libroBuscado.setActual(libroBuscado.getActual() + ejemplares);

                b.getLibros().agregarFinal(libro);

                ret.valorString = "Se agrearon " + ejemplares + " Ejemplares del libro" + titulo + "Editorial " + editorial;
            }

            //Libro(int NumUnico, String Titulo, String Editorial, int Ejemplares) 
        }
        return ret;
    }

    @Override
    public Retorno eliminarLibro(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String biblioteca, String título, String editorial, String fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, int numero, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarLibros(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarLibrosBiblioteca(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);

        return ret;
    }

    @Override
    public Retorno listarBibliotecaRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarComentarios(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno listarEspera(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno mostrarReservasBiblioteca() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

}


//soy fernando probando
