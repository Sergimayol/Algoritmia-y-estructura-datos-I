package alg_taller4;

/**
 *
 * @author Sergi
 */
public class CursoFP extends Curso {

    private String especialidad;

    public CursoFP(String especialidad, String nombre, String codigo) {
        super(nombre, codigo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
