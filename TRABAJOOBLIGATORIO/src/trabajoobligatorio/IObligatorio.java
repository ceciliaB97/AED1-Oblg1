package trabajoobligatorio;
import trabajoobligatorio.Retorno;

public interface IObligatorio {
   Retorno crearSistemaReservas();
   Retorno destruirSistemaReservas();
   Retorno registrarBiblioteca(String Biblioteca);
   Retorno eliminarBiblioteca(String Biblioteca);
   Retorno registrarLibro(String titulo, String editorial, String biblioteca, int ejemplares);
   Retorno eliminarLibro(String titulo, String editorial, String biblioteca);
   Retorno RegistrarCalificacion(String titulo, String editorial, int calificacion, String biblioteca, String comentario);
   Retorno realizarReserva(int cliente, int numero, String biblioteca, String título, String editorial, String fecha);
   Retorno cancelarReserva(int cliente, int numero, String biblioteca);
   Retorno listarLibros(String biblioteca);
   Retorno listarLibrosBiblioteca (String biblioteca);
   Retorno listarBibliotecaRanking();
   Retorno listarComentarios (String biblioteca);
   Retorno listarEspera(String titulo, String editorial, String biblioteca);
   Retorno mostrarReservasBiblioteca();
   

}