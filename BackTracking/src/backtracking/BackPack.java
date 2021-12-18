package backtracking;

/**
 *
 * @author Sergi
 */
public class BackPack {

    private final int PESOMAX;
    private int[] pesosObjetos, valorObjetos;

    public BackPack(int PESOMAX, int numeroObjetos) {
        this.PESOMAX = PESOMAX;
        this.pesosObjetos = new int[numeroObjetos];
        this.valorObjetos = new int[numeroObjetos];
    }

}
