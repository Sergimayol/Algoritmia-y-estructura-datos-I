package alg_taller3;

/**
 *
 * @author Sergi
 */
public class MensajeTexto extends Elemento {

    private String mensaje;

    public MensajeTexto(String s, String s2) {
        super(s);
        this.mensaje = s2;
    }

    @Override
    protected String escribir() {
        String s = super.escribir();
        s += "Su mensaje es: " + mensaje;
        s += "\n------------------\n\n\n";
        return s;
    }
}
