package alg_taller4;

/**
 *
 * @author Sergi
 */
public class Asignatura implements AccesoElemento{

    private String nombre;
    private String codigo;

    public Asignatura(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre= " + nombre + ", codigo= " + codigo + '}';
    }

}
