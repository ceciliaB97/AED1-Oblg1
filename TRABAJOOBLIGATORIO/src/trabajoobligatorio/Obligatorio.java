package trabajoobligatorio;

import Clases.*;

/**
 *
 * @author RAFAEL
 */
public class Obligatorio implements IObligatorio {

    ListaBibliotecas bibliotecaBase;

    @Override
    public Retorno crearSistemaReservas() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);

        this.bibliotecaBase = new ListaBibliotecas(0);
        ret.valorString = "Se ha creado el sistema de reservas";
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
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        //se crea una biblioteca sin libros
        NodoBiblioteca buscar = bibliotecaBase.obtenerElemento(Biblioteca);

        if (buscar == null) {
            NodoBiblioteca nueva = new NodoBiblioteca(Biblioteca);
            this.bibliotecaBase.agregarFinal(nueva);
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
        NodoBiblioteca buscar = bibliotecaBase.obtenerElemento(Biblioteca);

        if (buscar != null) {
            bibliotecaBase.eliminarElemento(Biblioteca);
            ret.valorString = "Biblioteca eliminada";
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
        NodoBiblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            NodoLibro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                ret.valorString = "Libro ya existe en la biblioteca";
                ret.resultado = Retorno.Resultado.ERROR;
                return ret;
            } else {
                NodoLibro nuevo = new NodoLibro(titulo, editorial, ejemplares);
                biBuscada.getLibros().agregarInicio(nuevo);
                ret.valorString = "Se ha agregado el libro a la biblioteca";
                ret.resultado = Retorno.Resultado.OK;
            }
        }
        return ret;
    }

    @Override
    public Retorno eliminarLibro(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            NodoLibro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

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

        NodoBiblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            NodoLibro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);

            if (liBuscado != null) {
                //Agregar restricciones calificacion
                NodoCalificacion nueva = new NodoCalificacion(calificacion, comentario);
                liBuscado.getCalificaciones().agregarInicio(nueva);
                liBuscado.EstablecerPromedioCalificacionesDeUnLibro();
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

        NodoBiblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (biBuscada != null) {
            //buscar libro
            NodoLibro liBuscado = biBuscada.getLibros().obtenerElemento(título, editorial);

            if (liBuscado != null) {
                if (!liBuscado.getReserva().esLLena()) {
                    NodoReserva nueva = new NodoReserva(cliente, numero, fecha);
                    liBuscado.getReserva().agregarFinal(nueva);
                    ret.valorString = "Se agregó la reserva al libro";
                    ret = new Retorno(Retorno.Resultado.OK);
                    return ret;
                } else {
                    NodoReserva nueva = new NodoReserva(cliente, numero, fecha);
                    liBuscado.getEspera().agregarFinal(nueva);
                    ret.valorString = "La lista de reserva está llena, se agregó a la lista de espera";
                    ret = new Retorno(Retorno.Resultado.OK);
                    return ret;
                }

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
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca auxBiblioteca = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (auxBiblioteca != null) {
            boolean encontrada = false;
//            si la biblioteca existe, se corrobora
            NodoLibro auxLibro = auxBiblioteca.getLibros().getInicioL();
            while (auxLibro.getSiguiente() != null && !encontrada) {
                NodoReserva rBuscada = auxLibro.getReserva().obtenerElemento(cliente, numero);
                if (rBuscada != null) {
                    //EliminarReserva
                    auxLibro.EliminarReserva(rBuscada, auxLibro);
                    ret.resultado = Retorno.Resultado.OK;
                    encontrada = true;
                }
                auxLibro = auxLibro.getSiguiente();
            }
        }
        return ret;
    }

    @Override
    public Retorno listarLibros(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca auxBiblioteca = this.bibliotecaBase.obtenerElemento(biblioteca);
        if (auxBiblioteca != null) {
            this.bibliotecaBase.mostrarRECLibro(auxBiblioteca);
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno listarLibrosBiblioteca(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca auxBiblioteca = this.bibliotecaBase.obtenerElemento(biblioteca);
        if (auxBiblioteca != null) {
            auxBiblioteca.PromedioGeneralLibros();
            this.bibliotecaBase.OrdenarLibrosPorCalifPromedioUnaBiblioteca(auxBiblioteca);
            System.out.println("Listar libros de la biblioteca: " + biblioteca);
            auxBiblioteca.getLibros().mostrarRECExtenso();
        }
        return ret;
    }

    @Override
    public Retorno listarBibliotecaRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        System.out.println("Bibliotecas ordenadas por ranking");
    
        for (NodoBiblioteca i = this.bibliotecaBase.getInicioB(); i.getSiguiente() != null; i = i.getSiguiente()) {
            this.bibliotecaBase.OrdenarLibrosPorCalifPromedioUnaBiblioteca(i);
            System.out.println("Biblioteca: " + i.getNombre());
            if (i.getLibros() != null) {
                i.getLibros().mostrarRECExtenso();
            } else {
                System.out.println("La biblioteca no tiene libros");
            }
        }
        return ret;
    }

    @Override
    public Retorno listarComentarios(String biblioteca) {

        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        NodoBiblioteca auxB = this.bibliotecaBase.obtenerElemento(biblioteca);

        if (auxB != null) {

            NodoLibro lb = auxB.getLibros().getInicioL();

            while (lb.getSiguiente() != null) {

                lb.getCalificaciones().mostrarREC();
                lb = lb.getSiguiente();

            }

            ret.resultado = Retorno.Resultado.OK;

        } else {

            ret.valorString = "La Biblioteca no existe";
        }

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
