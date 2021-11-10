package alg_taller4;

/**
 *
 * @author Sergi
 */
public interface AccesoLista {

    public int getLength();

    public void addAsignaturaLista(Asignatura asignatura);

    public void addCursoLista(Curso curso);

    public String getInfoLista();

    public String getInfo(int i);
}
