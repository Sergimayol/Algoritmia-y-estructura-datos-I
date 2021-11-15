package alg_taller4;

/**
 *
 * @author Sergi
 */
public class Colegio {

    private String nombre;
    private ListaCursos lista;
    private int posCursoAux;
    private int posAsignaturaAux;

    public Colegio(String nombre) {
        this.nombre = nombre;
        this.lista = new ListaCursos();
        posCursoAux = 0;
        posAsignaturaAux = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaCursos getLista() {
        return lista;
    }

    public void setLista(ListaCursos lista) {
        this.lista = lista;
    }

    public void verCursos() {
        for (int i = 0; i < lista.getLength(); i++) {
            System.out.println(lista.getInfo(i));
        }
        System.out.println("  ");
    }

    public void addCurso(String s, String nombre, String codigo, int tipo) {
        Curso curso;
        try {
            if (tipo == 1) {
                curso = new CursoFP(s, nombre, codigo);
            } else {
                curso = new CursoBach(s, nombre, codigo);
            }
            lista.addCursoLista(curso);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void addAsignatura(Curso c) {
        String op, s, s1;
        Asignatura asig;
        try {
            if (c == null) {
                System.out.println("Curso no encontrado.");
            } else {
                System.out.println("¿Que tipo de asignatura quiere añadir?");
                System.out.println("1. Obligatoria");
                System.out.println("2. Optativa");
                op = LT.readLine();
                if ("1".equals(op)) {
                    System.out.print("Creditos que contiene la asignatura: ");
                    op = LT.readLine();
                    System.out.print("\nNombre de la asignatura: ");
                    s = LT.readLine();
                    System.out.print("\nCódigo de la asignatura: ");
                    s1 = LT.readLine();
                    asig = new AsignObligatoria(Integer.parseInt(op), s, s1);

                } else {
                    System.out.print("Tipo de perfil de la asignatura(Teórico o práctico): ");
                    op = LT.readLine();
                    System.out.print("\nNombre de la asignatura: ");
                    s = LT.readLine();
                    System.out.print("\nCódigo de la asignatura: ");
                    s1 = LT.readLine();
                    asig = new AsignOptativa(op, s, s1);
                }
                c.addAsignatura(asig);
                System.out.println("Asignatura añadida al curso " + c.getNombre());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public Curso buscarCurso(String s) {
        Curso curso = null;
        try {
            for (int i = 0; i < lista.getLength(); i++) {
                curso = lista.getCurso(i);
                if (curso.getNombre().equals(s) || curso.getCodigo().equals(s)) {
                    posCursoAux = i;
                    return curso;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return curso;
    }

    public void eliminarAsignatura(Asignatura a, Curso c) {
        try {
            c.eliminarAsginatura(posAsignaturaAux);
            System.out.println("Se ha eliminado la asignatura '" + a.getNombre()
                    + "' del curso " + c.getNombre());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public Asignatura buscarAsignatura(Curso c, String s) {
        Asignatura a = null;
        try {
            for (int i = 0; i < c.getLengthLista(); i++) {
                a = c.getAsignatura(i);
                if (a.getCodigo().equals(s) || a.getNombre().equals(s)) {
                    posAsignaturaAux = i;
                    return a;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return a;
    }

    public void eliminarCurso(Curso c) {
        lista.removeCurso(posCursoAux);
        System.out.println("Curso eliminado con éxito." + c.getNombre());
    }
    
    public int getListaLength(){
        return lista.getLength();
    }
    
    public Curso getCurso(int i){
        return lista.getCurso(i);
    }

}
