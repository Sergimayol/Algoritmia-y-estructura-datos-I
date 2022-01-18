package alg_pract1;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public class Estudiante implements AccesoElemento {

    //Atributos
    private String nombre;
    private String dni;
    private Estudiante siguiente;

    //Constructor
    public Estudiante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.siguiente = null;
        if (this.nombre.isEmpty()) {
            this.nombre = " ";
        }
        if (this.dni.isEmpty()) {
            this.dni = " ";
        }
    }

    //Método que devuelve el nombre del Estudiante
    @Override
    public String getNombre() {
        return nombre;
    }

    //Método para asignar el nombre del Estudiante
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Método que devuelve el DNI del Estudiante
    @Override
    public String getCodigo() {
        return dni;
    }

    //Método para asignar el DNI del Estudiante
    @Override
    public void setCodigo(String dni) {
        this.dni = dni;
    }
    
    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Estudiante: nombre=>" + nombre + ", dni=>" + dni;
    }
    
    //Método que devuelve el siguiente Estudiante
    public Estudiante getSiguienteEstudiante() {
        return siguiente;
    }

    //Método para asignar el siguiente Estudiante
    public void setSiguienteEstudiante(Estudiante siguiente) {
        this.siguiente = siguiente;
    }

}
