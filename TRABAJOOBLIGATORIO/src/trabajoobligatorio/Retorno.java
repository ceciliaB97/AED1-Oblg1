
package trabajoobligatorio;
import Clases.Libro;





public class Retorno {
	enum Resultado {
		OK, ERROR, NO_IMPLEMENTADA
	};

	int valorEntero;
	String valorString;
         boolean valorbooleano;
	Resultado resultado;
        Libro Libro;

    public Retorno(Resultado resultado) {

        this.resultado = resultado;
    }
        
        
        
}
