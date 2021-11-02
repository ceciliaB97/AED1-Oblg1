
package Estructuras;

public class TDato<T> {

    private T o;
    private String className;

    public TDato(T obj) {
        //Me guardo el nombre de la clase encapsulada.
        className = obj.getClass().getName();
        o = obj;
    }

    /**
     * HAY QUE REDEFINIRLO SEGUN LA CLASE!.
     *
     * @param o
     * @return
     */
    public int CompareTo(T o) {
        return this.hashCode();
    }

    /**
     * @return el Objeto encapsulado [Hay que castearlo]
     */
    public Object getO() {
        return o;
    }

    /**
     * @param o Seteamos el dato a guardar encapsulado [No se castea]
     */
    public void setO(T o) {
        this.o = o;
    }

    /**
     * @return el nombre de la clase encapsulada [para conocer el tipo por las
     * dudas]
     */
    public String getClassName() {
        return className;
    }

    /**
     * Seteamos el nombre de la clase.
     *
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }
}
