package alg_taller3;

/**
 *
 * @author Sergi
 */
public class Alg_Taller3 {

    private Conjunto conj;

    public static void main(String[] args) {
        new Alg_Taller3().iniciar();
    }

    public Alg_Taller3() {
        conj = new Conjunto();
    }

    private void iniciar() {
        conj.poner("Primer valor", 8.11);
        conj.poner("Primer mensaje", "Este es el primer mensaje");
        conj.poner("Segundo valor", 12.28);
        conj.poner("Segundo mensaje", "heyy, ¿Quetal?");
        System.out.println(conj.getInfoTotal());
    }

}
