package alg_taller4;

/**
 *
 * @author Sergi
 */
public class AsignObligatoria extends Asignatura {

    private final int creditos;

    public AsignObligatoria(int creditos, String nombre, String codigo) {
        super(nombre, codigo);
        this.creditos = creditos;
    }

    public int getCreditos() {
        return creditos;
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
