package trabajoobligatorio;




public class TRABAJOOBLIGATORIO {

    public static void main(String[] args) {
        // TODO code application logic here
        Prueba p=new Prueba();
        Obligatorio o = new Obligatorio();
        juegodeprueba(o,p);
    }
    public static void juegodeprueba(Obligatorio o, Prueba p){
    p.ver(o.crearSistemaReservas().resultado, Retorno.Resultado.OK, "Se crea sistema de reservas");
    
    
    
    p.ver(o.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye sistema de reservas");
    
    p.imprimirResultadosPrueba();
    
    }  
}
