package alg_taller3;

/**
 *
 * @author Sergi
 */
public class NumeroReal extends Elemento {

    private double valor;

    public NumeroReal(String s, double d) {
        super(s);
        this.valor = d;
    }

    @Override
    protected String escribir() {
        String s = super.escribir();
        s += "Su valor real es: " + valor;
        s += "\n------------------\n\n\n";
        return s;
    }

}
