package alg_taller3;

/**
 *
 * @author Sergi
 */
public class Elemento {

    private String nombre;

    protected Elemento(String s) {
        nombre = s;
    }

    protected String escribir() {
        String s = "";
        s = "Información del elemento: " + nombre + "\n";
        s += "--------------------------------------\n";
        return s;
    }

}
