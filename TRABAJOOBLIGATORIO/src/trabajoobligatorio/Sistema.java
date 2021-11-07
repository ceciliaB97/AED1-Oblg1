package trabajoobligatorio;
import Clases.*;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p=new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(o,p);
        Reserva r1 = new Reserva(11111111, 120, "06/11/21");        
        Reserva r2 = new Reserva(22222222, 121, "06/11/21");        
        Reserva r3 = new Reserva(33333333, 122, "06/11/21");
      
        r1.agregarFinal(r1);
        r1.agregarFinal(r2);
        r1.agregarFinal(r3);
        r1.mostrarREC(r1);
        
        System.out.println(r1.eliminarElemento(r2));
        r1.mostrarREC(r1);
        
        
    }
    public static void juegodeprueba(Obligatorio o, Prueba p){
    p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
    
    
    
    p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
    
    p.imprimirResultadosPrueba();
    
    }  
}
