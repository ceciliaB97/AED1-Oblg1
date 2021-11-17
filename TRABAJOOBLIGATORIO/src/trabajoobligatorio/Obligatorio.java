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
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Biblioteca agregada con éxito";
        } else {
            ret.valorString = "Biblioteca ya existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno eliminarBiblioteca(String Biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        //se busca y se elimina
        NodoBiblioteca buscar = bibliotecaBase.obtenerElemento(Biblioteca);

        if (buscar != null) {
            if (!buscar.tieneReservas()) {
                bibliotecaBase.eliminarElemento(Biblioteca);
                ret.valorString = "Biblioteca eliminada";
                ret.resultado = Retorno.Resultado.OK;
            } else {
                ret.valorString = "Biblioteca NO eliminada, tiene reservas";
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
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
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
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
                ret.resultado = Retorno.Resultado.OK;
                return ret;
            } else {
                ret.valorString = "Libro no existe en la biblioteca";
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
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
                if (calificacion >= 0 && calificacion <= 5) {
                    //agregar calificacion al final
                    liBuscado.getCalificaciones().agregarInicio(calificacion, comentario);
                    //actualizar la calificacion promedio
                    liBuscado.setCalifPromedio();
                    biBuscada.EstablecerPromedioCalificacionesDeUnaBiblioteca();
                    this.bibliotecaBase.OrdenarPorPromedioBiblioteca();
                    ret = new Retorno(Retorno.Resultado.OK);
                    ret.valorString = "Se agregó la calificación al libro";
                } else {
                    ret = new Retorno(Retorno.Resultado.ERROR);
                    ret.valorString = "Calificacion fuera de rango";
                }
            } else {
                ret = new Retorno(Retorno.Resultado.ERROR);
                ret.valorString = "No existe el libro";

            }
        } else {
            ret = new Retorno(Retorno.Resultado.ERROR);
            ret.valorString = "No existe la bilbioteca";

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
                    ret.resultado = Retorno.Resultado.OK;

                } else {
                    NodoReserva nueva = new NodoReserva(cliente, numero, fecha);
                    liBuscado.getEspera().agregarFinal(nueva);
                    ret.valorString = "La lista de reserva está llena, se agregó a la lista de espera";
                    ret.resultado = Retorno.Resultado.OK;

                }
                liBuscado.setCantSolicitudes(liBuscado.getCantSolicitudes() + 1);
                return ret;

            } else {
                ret.valorString = "Libro no existe en la biblioteca";
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
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
            while (auxLibro != null && !encontrada) {
                NodoReserva rBuscada = auxLibro.getReserva().obtenerElemento(cliente, numero);
                ret.valorString = "No se encontró la reserva";
                if (rBuscada != null) {
                    //EliminarReserva
                    auxLibro.EliminarReserva(rBuscada, auxLibro);
                    ret.resultado = Retorno.Resultado.OK;
                    encontrada = true;
                    auxBiblioteca.EstablecerPromedioCalificacionesDeUnaBiblioteca();
                    this.bibliotecaBase.OrdenarPorPromedioBiblioteca();
                    auxLibro.setCantSolicitudes(auxLibro.getCantSolicitudes() - 1);
                    ret.valorString = "Reserva cancelada con éxito";
                }
                auxLibro = auxLibro.getSiguiente();
            }
        } else {
            ret.valorString = "La biblioteca no existe";
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
            ret.valorString = "Listado exitoso";
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno listarLibrosBiblioteca(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca auxBiblioteca = this.bibliotecaBase.obtenerElemento(biblioteca);
        if (auxBiblioteca != null) {
            auxBiblioteca.PromedioGeneralLibros();
            //metodo selection
            //this.bibliotecaBase.OrdenarLibrosCalificacionPromedioPorBiblioteca(auxBiblioteca);
            //metodo bubble
            this.bibliotecaBase.OrdenarLibrosPorCalifPromedioUnaBiblioteca(auxBiblioteca);
            System.out.println("Listar libros de la biblioteca: " + biblioteca);
            auxBiblioteca.getLibros().mostrarRECExtenso();
            ret.resultado = Retorno.Resultado.OK;
            ret.valorString = "Lista de libros por biblioteca";
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
            ret.valorString = "Biblioteca no existe";
        }
        return ret;
    }

    @Override
    public Retorno listarBibliotecaRanking() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        System.out.println("Bibliotecas ordenadas por ranking");
        NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
        while (aux != null) {
            this.bibliotecaBase.OrdenarLibrosPorCalifPromedioUnaBiblioteca(aux);
            System.out.println("Biblioteca: " + aux.getNombre());
            if (aux.getLibros() != null) {
                aux.getLibros().mostrarRECExtenso();
            } else {
                System.out.println("La biblioteca no tiene libros");
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    @Override
    public Retorno listarComentarios(String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca auxB = this.bibliotecaBase.obtenerElemento(biblioteca);
        int cont = 1;
        if (auxB != null) {
            ListaCalificaciones listaComentario = auxB.getLibros().ListaComentarios();
            NodoCalificacion auxCalif = listaComentario.getInicioC();
            listaComentario.mostrarREC();
            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.valorString = "La Biblioteca no existe";
        }
        return ret;
    }

    @Override
    public Retorno listarEspera(String titulo, String editorial, String biblioteca) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        NodoBiblioteca biBuscada = this.bibliotecaBase.obtenerElemento(biblioteca);
        if (biBuscada != null) {
            NodoLibro liBuscado = biBuscada.getLibros().obtenerElemento(titulo, editorial);
            if (liBuscado != null) {
                System.out.println("Lista de espera del titulo " + liBuscado.getTitulo()
                        + " de la editorial " + liBuscado.getEditorial()
                        + " en "
                        + biBuscada.getNombre());
                liBuscado.getEspera().mostrarREC();
                ret.valorString = "Lista Espera";
                ret.resultado = Retorno.Resultado.OK;
            } else {
                ret.valorString = "Libro no existe";
                ret.resultado = Retorno.Resultado.ERROR;
            }
        } else {
            ret.valorString = "Biblioteca no existe";
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno mostrarReservasBiblioteca() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ListaLibros listalb = this.bibliotecaBase.LibrosMasSolicitados();

        int filas = 6;

        for (int fil = 0; fil < filas; fil++) {// filas
            if (fil == 0) {// fila 0
                System.out.print("reservas/bibliotecas");

                for (NodoBiblioteca i = this.bibliotecaBase.getInicioB(); i != null; i = i.getSiguiente()) {
                    System.out.print(" " + i.getNombre() + " ");
                }
                System.out.print("Total\n");
            } else {

                NodoLibro aux = listalb.getInicioL();
                if (aux != null) {
                    System.out.print(aux.getTitulo());
                    for (NodoBiblioteca i = this.bibliotecaBase.getInicioB(); i != null; i = i.getSiguiente()) {
                        int reservaEnBiblioteca = i.cantSolicitudesLibroPorBiblioteca(aux);
                        System.out.print("  R: " + reservaEnBiblioteca);
                    }
                    System.out.print(" Solciitudes " + aux.getCantSolicitudes() + "\n");
                }
                listalb.borrarInicio();
            }
        }
        return ret;
    }
}
