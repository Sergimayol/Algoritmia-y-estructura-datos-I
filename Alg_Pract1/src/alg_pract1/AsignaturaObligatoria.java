
//La clase AsignaturaObligatoria hereda de la clase Asignatura

package alg_pract1;

/**
 *
 * @author Sergi
 */

public class AsignaturaObligatoria extends Asignatura {

    //Atributo
    private final int NUMCREDITOS;

    //Constructor
    public AsignaturaObligatoria(String nombre, String codigo, int creditos) {
        super(nombre, codigo);
        this.NUMCREDITOS = creditos;
    }

    //Método que devuelve el número de créditos
    public int getNUMCREDITOS() {
        return NUMCREDITOS;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return super.toString() + ", tipo asignatura=> Obligatoria, créditos=>" + NUMCREDITOS;
    }

}
