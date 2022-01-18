//La clase AsignaturaOptativa hereda de la clase Asignatura

package alg_pract1;

/**
 *
 * @author Sergi
 */
public class AsignaturaOptativa extends Asignatura {
    
    //Atributo
    private String perfil;

    //Constructor
    public AsignaturaOptativa(String nombre, String codigo, String perfil) {
        super(nombre, codigo);
        this.perfil = perfil;
        if (this.perfil.isEmpty()) {
            this.perfil = "No especificado";
        }
    }

    //Método que devuelve el perfil
    public String getPerfil() {
        return perfil;
    }

    //Método que asigna un perfil
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return super.toString() + ", tipo asignatura=> Optativa, perfil=>" + perfil;
    }

}
