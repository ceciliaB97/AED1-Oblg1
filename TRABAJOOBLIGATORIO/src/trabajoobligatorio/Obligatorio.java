package trabajoobligatorio;

import Estructuras.Lista;
import Clases.*;

/**
 *
 * @author RAFAEL
 */
public class Obligatorio extends Lista implements IObligatorio {

    Biblioteca bibliotecaBase;

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        NodoBiblioteca bibliotecaBase = new NodoBiblioteca("Base");
        this.bibliotecaBase.agregarInicio(bibliotecaBase)
        ret.valorString = "Se ha agregado el sistema de reservas";
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        bibliotecaBase.vaciar();
        ret.valorString = "Se ha destruido el sistema de reservas";
        return ret;
    }

    @Override
    public Retorno registrarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se crea una biblioteca sin libros
        Biblioteca buscar = bibliotecaBase.obtenerElemento(Biblioteca);

        if (buscar == null) {
            Biblioteca nueva = new Biblioteca(Biblioteca);
            bibliotecaBase.agregarFinal(nueva);
            ret = new Retorno(Retorno.Resultado.OK);
        } else {
            ret.valorString = "Biblioteca ya existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno eliminarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se busca y se elimina
        Biblioteca buscar = bibliotecaBase.getInicioB().obtenerElemento(Biblioteca);

        if (buscar != null) {
            bibliotecaBase.eliminarElemento(buscar);
            ret.valorString = "Biblioteca eliminada0";
            ret = new Retorno(Retorno.Resultado.OK);
        } else {
            ret.valorString = "Biblioteca no existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Biblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            Libro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                ret.valorString = "Libro ya existe en la biblioteca";
                ret = new Retorno(Retorno.Resultado.ERROR);
                return ret;
            } else {
                Libro nuevo = new Libro(1, titulo, editorial, 3);
                biBuscada.getLibros().agregarInicio(nuevo);
                ret.valorString = "Libro ya existe en la biblioteca";
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        }
        return ret;
    }

    @Override
    public Retorno eliminarLibro(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        Biblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            Libro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                biBuscada.getLibros().eliminarElemento(liBuscado);
                ret.valorString = "Se eliminó el libro";
                ret = new Retorno(Retorno.Resultado.OK);
                return ret;
            } else {
                ret.valorString = "Libro no existe en la biblioteca";
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }

        return ret;
    }

    @Override
    public Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        Biblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            Libro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                Calificacion nueva = new Calificacion(calificacion, comentario);
                liBuscado.getCalificacion().agregarFinal(nueva);
                ret.valorString = "Se agregó la calificación al libro";
                ret = new Retorno(Retorno.Resultado.OK);
                return ret;
            } else {
                ret.valorString = "Libro no existe en la biblioteca";
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String biblioteca, String título, String editorial, String fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        Biblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            Libro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                Reserva nueva = new Reserva(cliente, numero, fecha, liBuscado.getEjemplares());
                liBuscado.getReserva().agregarFinal(nueva); //o -> o -> o ->
                ret.valorString = "Se agregó la calificación al libro";
                ret = new Retorno(Retorno.Resultado.OK);
                return ret;
            } else {
                ret.valorString = "Libro no existe en la biblioteca";
                ret = new Retorno(Retorno.Resultado.ERROR);
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
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
