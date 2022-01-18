package alg_pract1;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodríguez Arguimbau
 */
public class Colegio {
    //Atributos
    private ListaCursos listaCurso;
    
    //Constructor
    public Colegio() {
        this.listaCurso = new ListaCursos();
    }

    //Método que deveulve un String de todos los cursos disponibles
    public String verCursos() {
        //String contenedor de los cursos
        String cursos = "";
        //Se recorre toda la lista de curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            //Se añade cada curso al String
            cursos += this.listaCurso.getInfo(i) + "\n";
        }
        //Se devuelve String
        return cursos;
    }

    //Método que devuelve un String con tadas las asignaturas que hay creadas
    public String verTodasAsignaturas() {
        //String contenedor de todas las asignaturas
        String asig = "";
        //Varaible tipo Curso aux
        Curso aux;
        //Se recorre toda la lista de curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            //Por cada objeto Curso se añade su asignatura al String
            aux = (Curso) this.listaCurso.getObjetoLista(i);
            asig += aux.verAsignaturas();
        }
        //Se devuelve String
        return asig;
    }

    //Este método devuelve un String con todos los estudiantes que hay
    public String verTodosEstudiantes() {
        //String contendor de todos los estudiantes
        String est = "";
        //Variables auxiliares
        Curso Caux;
        Asignatura aux;
        //Se recorre la lista de cursos
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            Caux = (Curso) this.listaCurso.getObjetoLista(i);
            //Por cada curso se recorre su lista de asignaturas
            for (int j = 0; j < Caux.getLengthListaAsig(); j++) {
                //Por cada asignatura se añaden los estudiantes al String
                aux = Caux.getObjetoLista(j);
                est += aux.verEstudiante();
            }
        }
        //Se devuelve String
        return est;
    }
    
    //Devuelve el nombre del curso de la posición pasada por
    // parámetro.
    public String getNombreCurso(int i) {
        return this.listaCurso.getNombre(i);
    }

    //Devuelve lista de cursos
    public ListaCursos getListaCurso() {
        return listaCurso;
    }
    
    //Asignación de un lista de cursos
    public void setListaCurso(ListaCursos listaCurso) {
        this.listaCurso = listaCurso;
    }

    //Adicion curso a lista cursos
    public void addCurso(Curso c) {
        this.listaCurso.addObject(c);
    }

    //Adición asignatura a un curso 
    public void addAsignatura(Asignatura a, Curso c) {
        if (c == null || a == null) {
            System.out.println("Curso o asignatura = null");
        } else {
            c.addAsignatura(a);
        }
    }

    //Adición de un estudiante a una asignatura
    public void addEstudiante(Estudiante e, Asignatura a) {
        if (e == null || a == null) {
            System.out.println("Estudiante o asignatura = null");
        } else {
            a.addEstudiante(e);
        }
    }

    //Busca un curso de la lista de cursos del colegio. Permite buscar un curso
    //tanto por nombre o codigo del mismo.
    public Curso buscarCurso(String s) {
        Curso aux = null;
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            aux = (Curso) this.listaCurso.getObjetoLista(i);
            if (aux.getCodigo().equals(s) || aux.getNombre().equals(s)) {
                //Curso a buscar encontrado
                return aux;
            }
        }
        aux = null;
        //aux = null(Objeto no encontrado)
        return aux;
    }

    //Busca una asignatura de la lista de Asignaturas de todos los cursos del colegio.
    //Permite buscar una asignatura tanto por nombre o codigo del mismo.
    public Object[] buscarAsignatura(String s) {
        Asignatura aux = null;
        Curso Caux = null;
        Object[] retorno = new Object[2];
        //Recorrer lista curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            Caux = (Curso) this.listaCurso.getObjetoLista(i);
            retorno[0] = Caux;
            //Recorrer lista Asignatura del curso actual
            for (int j = 0; j < Caux.getLengthListaAsig(); j++) {
                aux = Caux.getObjetoLista(j);
                if (aux.getCodigo().equals(s) || aux.getNombre().equals(s)) {
                    //Curso a buscar encontrado
                    retorno[1] = aux;
                    return retorno;
                }
            }
        }
        //(Objeto no encontrado)
        return null;
    }

    //Busca un estudiante de la lista de Estudiantes de las lista de Asginaturas de cada curso. 
    //Permite buscar un estudiante tanto por nombre o codigo del mismo.
    public Object[] buscarEstudiante(String s) {
        Estudiante aux = null;
        Asignatura Aaux = null;
        Curso Caux = null;
        Object[] retorno = new Object[3];
        //Recorrer lista curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            Caux = (Curso) this.listaCurso.getObjetoLista(i);
            retorno[0] = Caux;
            //Recorrer lista Asignatura del curso actual
            for (int j = 0; j < Caux.getLengthListaAsig(); j++) {
                Aaux = Caux.getObjetoLista(j);
                retorno[1] = Aaux;
                //Recorrer lista Estudiantes
                for (int k = 0; k < Aaux.getLengthListaEst(); k++) {
                    aux = Aaux.getObjetoLista(k);
                    if (aux.getCodigo().equals(s) || aux.getNombre().equals(s)) {
                        //Curso a buscar encontrado
                        retorno[2] = aux;
                        return retorno;
                    }
                }
            }
        }
        //(Objeto no encontrado)
        return null;
    }

    //Elimina un curso de la lista de curso del colegio
    public void eliminarCurso(Curso c) {
        if (c == null) {
            System.out.println("Curso= null");
        } else {
            this.listaCurso.removeObject(c);
        }
    }

    //Elimina una asignatura de la lista de asignaturas de un curso
    public void eliminarAsignatura(Asignatura a) {
        Curso Caux = null;
        //Recorrer lista curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            Caux = (Curso) this.listaCurso.getObjetoLista(i);
            //De cada curso se elimina la asignatura pasada por parametro
            Caux.removeAsignatura(a);
        }
    }

    //Elimina un estudiante de la lista de estudiante de una asignatura
    public void eliminarEstudiante(Estudiante e) {
        Asignatura aux = null;
        Curso Caux = null;
        //Recorrer lista curso
        for (int i = 0; i < this.listaCurso.getLength(); i++) {
            Caux = (Curso) this.listaCurso.getObjetoLista(i);
            //Recorrer lista Asignatura del curso actual
            for (int j = 0; j < Caux.getLengthListaAsig(); j++) {
                aux = Caux.getObjetoLista(j);
                aux.removeEstudiante(e);
            }
        }
    }

    //Método que permite ordenar la lista del objeto pasado por parámetro
    public void ordenarObjecto(int i, Object o) {
        switch (i) {
            case 0:
                //Ordenar lista cursos
                this.listaCurso.ordenarLista();
                break;
            case 1:
                //Ordenar lista asignaturas
                Curso c = (Curso) o;
                c.getListaAsignatura().ordenarLista();
                break;
            case 2:
                //Ordenar lista estudiantes
                Asignatura a = (Asignatura) o;
                a.getListaEstudiante().ordenarLista();
                break;
            default:
                throw new AssertionError();
        }
    }

}
