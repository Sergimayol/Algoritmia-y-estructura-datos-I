package alg_taller4;

/**
 *
 * @author Sergi
 */
public class AsignOptativa extends Asignatura {

    private String perfil;

    public AsignOptativa(String perfil, String nombre, String codigo) {
        super(nombre, codigo);
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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
