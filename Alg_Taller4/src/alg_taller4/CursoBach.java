package alg_taller4;

/**
 *
 * @author Sergi
 */
public class CursoBach extends Curso {

    private String cursoBach;

    public CursoBach(String cursoBach, String nombre, String codigo) {
        super(nombre, codigo);
        this.cursoBach = cursoBach;
    }

    public String getCursoBach() {
        return cursoBach;
    }

    public void setCursoBach(String cursoBach) {
        this.cursoBach = cursoBach;
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getCodigo() {
        return super.getCodigo();
    }

}
