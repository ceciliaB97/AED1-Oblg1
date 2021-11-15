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
                    return ret;
                } else {
                    NodoReserva nueva = new NodoReserva(cliente, numero, fecha);
                    liBuscado.getEspera().agregarFinal(nueva);
                    ret.valorString = "La lista de reserva está llena, se agregó a la lista de espera";
                    ret.resultado = Retorno.Resultado.OK;
                    return ret;
                }

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
            //version selection
            //this.bibliotecaBase.OrdenarLibrosCalificacionPromedioPorBiblioteca(aux);
            //version bubble
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

//    @Override
//    public Retorno mostrarmatriz(int[][] m) {
//        Retorno ret = new Retorno(Retorno.Resultado.OK);
//        int filas = m.length;
//        int columnas = m[0].length;
//        ret.valorString = "\n";
//
//        for (int col = 0; col < filas; col++) {
//            for (int fil = 0; fil < columnas; fil++) {
//                ret.valorString += m[col][fil] + " ";
//            }
//            ret.valorString += "\n";
//        }
//        return ret;
//    }
    @Override
    public Retorno mostrarReservasBiblioteca() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        ListaLibros listalb = this.bibliotecaBase.LibrosMayorRanKing();

        int filas = 6;

        //for para cabezal
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

                    int reservaEnBiblioteca = 0;
                    for (NodoBiblioteca i = this.bibliotecaBase.getInicioB(); i != null; i = i.getSiguiente()) {
                        if (i.getLibros().buscarElemento(aux)) {
                            reservaEnBiblioteca = aux.getCantSolicitudes();
                        }
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

//        for (int col = 0; col < elementos; col++) {
//            fila = col / columnas;
//            columna = col % columnas;  
//            if (fila == 0) {
//                NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                if (columna == 0) {
//                    System.out.print("reservas/biblioteca ");
//                } else if (columna > 0 && columna < columnas) {
//                    if(columnaAnt != columna){
//                    System.out.print("|" + aux.getNombre() + "|");
//                    aux = aux.getSiguiente();
//                    columnaAnt++;
//                    }                    
//                } else if (columna == 6) {
//                    System.out.print("Total");
//                }                
//            }
//
//        }
//            } else if (fila == 1) {
//                NodoLibro auxLibro = listalb.getInicioL();
//                if (columna == 0) {
//                    System.out.print(auxLibro.getTitulo());
//                } else if (columna > 0 && columna < columnas) {
//                    NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                    for (NodoBiblioteca fil = aux; fil != null; fil = fil.getSiguiente()) {
//                        if (!fil.getLibros().esVacia()) {
//                            NodoLibro lb = fil.getLibros().obtenerElementoAnterior(auxLibro);
//                            if (lb != null) {
//                                System.out.print("|" + lb.getCantSolicitudes() + "|");
//                            } else {
//                                System.out.print(0);
//                            }
//                        } else {
//                            System.out.print(0);
//                        }
//                    }
//                } else if (columna == columnas) {
//                    System.out.print(auxLibro.getCantSolicitudes());
//                }
//                System.out.print("\n");
//            } else if (fila == 2) {
//                NodoLibro auxLibro = listalb.getInicioL().getSiguiente();
//                if (columna == 0) {
//                    System.out.print(auxLibro.getTitulo());
//                } else if (columna > 0 && columna < columnas) {
//                    NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                    for (NodoBiblioteca fil = aux; fil != null; fil = fil.getSiguiente()) {
//                        if (!fil.getLibros().esVacia()) {
//                            NodoLibro lb = fil.getLibros().obtenerElementoAnterior(auxLibro);
//                            if (lb != null) {
//                                System.out.print("|" + lb.getCantSolicitudes() + "|");
//                            } else {
//                                System.out.print(0);
//                            }
//                        } else {
//                            System.out.print(0);
//                        }
//                    }
//                    System.out.print("\n");
//                } else if (columna == columnas) {
//                    System.out.print(auxLibro.getCantSolicitudes());
//                }
//        //int[][] m = {{2, 2}, {2, 2}, {2, 2}};
//        //reservas/biblioteca | biblioteca 1 | biblioteca 2 | biblioteca 3 | ...
//        //    top 1           |    nombre    |    nombre    |    nombre    |
//        //    top 2           |    nombre    |    nombre    |    nombre    |
//        //    top 3           |    nombre    |    nombre    |    nombre    |
//        //    top 4           |    nombre    |    nombre    |    nombre    |
//        //    top 5           |    nombre    |    nombre    |    nombre    |
//        ret.valorString = "\n";
//
//        for (int col = 0; col < elementos; col++) {
//            fila = col / columnas;
//            columna = col % columnas;
//            //salto de linea
//            if (columna == 0) {
//                ret.valorString += "\n";
//            }
//            //si es el m[0][0]
//            if (fila == 0 && columna == 0) {
//                System.out.print(" reservas/biblioteca ");
//            }
//            //si es el m[0][1...n]
//            if (fila == 0 && columna > 0) {
//                NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                while (aux.getSiguiente() != null) {
//                    System.out.print(aux.getNombre());
//                    aux = aux.getSiguiente();
//                }
//            }
//            //si es el m[1...n][0]
//            if (fila > 0 && columna == 0) {
//                //nombre de libro
//                NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                this.bibliotecaBase.OrdenarLibrosPorCantidadSolicitudes(aux);
//                while (aux != null) {
//                    System.out.print(aux.getNombre());
//                    aux = aux.getSiguiente();
//                }
//                System.out.println(" TOP " + fila);
//            }
//            //si es el m[1...n][1...n]
//            if (fila > 0 && columna > 0) {
//                //numero de reservas
//                NodoBiblioteca aux = this.bibliotecaBase.getInicioB();
//                this.bibliotecaBase.OrdenarLibrosPorCantidadSolicitudes(aux);
//                while (aux != null) {
//                    System.out.print(aux.getNombre());
//                    aux = aux.getSiguiente();
//                }
//            }
//            System.out.print(" hola2 ");
//        }
//        //System.out.print(m[fila][columna] + " ");
//
//        ret.valorString = "Lista de 5 libros mas reservados";





//soy fernando probando
