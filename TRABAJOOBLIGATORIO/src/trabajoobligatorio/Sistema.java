package trabajoobligatorio;
import Clases.*;

public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p=new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(o,p);
        Reserva r = new Reserva(49678705, 120, "06/11/21");        
        Reserva r1 = new Reserva(56789705, 121, "06/11/21");        
        Reserva r2 = new Reserva(66789705, 122, "06/11/21");
        r.agregarInicio(r);
        r.agregarInicio(r1);
        r.agregarInicio(r2);
        System.out.println(r.cantElementos());
        r.mostrarREC2(r2,1);
        
        
    }
    public static void juegodeprueba(Obligatorio o, Prueba p){
    p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
    
    
    
    p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
    
    p.imprimirResultadosPrueba();
    
    }  
}
