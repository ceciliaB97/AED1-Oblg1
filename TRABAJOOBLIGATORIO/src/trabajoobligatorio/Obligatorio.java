package trabajoobligatorio;

import Estructuras.Lista;
import Clases.*;

/**
 *
 * @author RAFAEL
 */
public class Obligatorio extends Lista implements IObligatorio {
<<<<<<< HEAD

    Biblioteca bibliotecaBase;

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Biblioteca bibliotecaBase = new Biblioteca("Base");
        this.bibliotecaBase.agregarInicio(bibliotecaBase);
        ret.valorString = "Se ha agregado el sistema de reservas";
=======

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
<<<<<<< HEAD
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        bibliotecaBase.vaciar();
        ret.valorString = "Se ha destruido el sistema de reservas";
=======
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    @Override
    public Retorno registrarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se crea una biblioteca sin libros
<<<<<<< HEAD
        Biblioteca buscar = bibliotecaBase.obtenerElemento(Biblioteca);

        if (buscar == null) {
            Biblioteca nueva = new Biblioteca(Biblioteca);
            bibliotecaBase.agregarFinal(nueva);
            ret = new Retorno(Retorno.Resultado.OK);
        } else {
            ret.valorString = "Biblioteca ya existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
=======
        Biblioteca bibliotecaB = new Biblioteca(Biblioteca);
        ret.valorString = "Se creo la bilbioteca " + bibliotecaB.getNombre();
        ret.valorbooleano = true;
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    @Override
    public Retorno eliminarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se busca y se elimina
<<<<<<< HEAD
        Biblioteca buscar = bibliotecaBase.getInicioB().obtenerElemento(Biblioteca);

        if (buscar != null) {
            bibliotecaBase.eliminarElemento(buscar);
            ret.valorString = "Biblioteca eliminada0";
            ret = new Retorno(Retorno.Resultado.OK);
        } else {
            ret.valorString = "Biblioteca no existe";
            ret = new Retorno(Retorno.Resultado.ERROR);
        }
=======
        Biblioteca b = new Biblioteca(Biblioteca);
        //si elimino devuelve true, si no false
        ret.valorbooleano = b.borrarElemento(b);
        ret.valorString = "Se eliminio biblioteca es " + ret.valorbooleano;
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    
    @Override
    public Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares) {
<<<<<<< HEAD
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
=======
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
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        }
        return ret;
    }

    @Override
    public Retorno eliminarLibro(String titulo, String editorial, String biblioteca) {
<<<<<<< HEAD
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

=======
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    @Override
    public Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario) {
<<<<<<< HEAD
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
=======
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, int numero, String biblioteca, String título, String editorial, String fecha) {
<<<<<<< HEAD
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
=======
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
>>>>>>> 0df4fc4de593a2187adad7e3a3833289a16189b1
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
