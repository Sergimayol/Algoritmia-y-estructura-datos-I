//La clase FormacionProfesional hereda de la clase Curso
 
package alg_pract1;

/**
 *
 * @author Sergi
 */
public class FormacionProfesional extends Curso {

    //Atributo
    private String especialidad;

    //Constructor
    public FormacionProfesional(String nombre, String codigo, String especialidad) {
        super(nombre, codigo);
        this.especialidad = especialidad;
        if (this.especialidad.isEmpty()) {
            this.especialidad = "No especificada";
        }
    }

    //Método que devuelve la especialidad
    public String getEspecialidad() {
        return especialidad;
    }

    //Método que asigna una especialidad
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return super.toString() + ", tipo curso=> Formación profesional, especialidad=> " + especialidad;
    }

}
