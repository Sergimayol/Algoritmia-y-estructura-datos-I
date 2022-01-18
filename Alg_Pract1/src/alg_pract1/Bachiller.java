//La clase Bachiller hereda de la clase Curso

package alg_pract1;

/**
 *
 * @author Sergi
 */
public class Bachiller extends Curso {

    //Atributo
    private String cursoBach;

    //Constructor
    public Bachiller(String nombre, String codigo, String cursoBach) {
        super(nombre, codigo);
        this.cursoBach = cursoBach;
        if (this.cursoBach.isEmpty()) {
            this.cursoBach = "No especificado";
        }
    }

    //Método que devuelve el nombre del curso de Bachiller
    public String getCursoBach() {
        return cursoBach;
    }

    //Método para asignar un nombre del curso de Bachiller
    public void setCursoBach(String cursoBach) {
        this.cursoBach = cursoBach;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return super.toString() + ", tipo curso=> Bachiller, curso=> " + cursoBach;
    }

}
