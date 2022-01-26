package alg_pract2;

public class Tauler {

    public int tamTablero;
    public boolean[][] tauler;

    public Tauler(int tamTablero) {
        this.tamTablero = tamTablero;
        tauler = new boolean[this.tamTablero][this.tamTablero];
    }

    public void setCasilla(int i, int j) {
        tauler[i][j] = true;
    }

    public void vaciarCasilla(int i, int j) {
        tauler[i][j] = false;
    }

    public boolean getCasella(int i, int j) {
        return tauler[i][j];
    }

    public boolean[][] getMatriz() {
        return copiarMatriu(tauler);
    }
    
    private boolean[][] copiarMatriu(boolean[][] origen) {
        boolean[][] dest = new boolean[origen.length][origen[1].length];
        for (int i = 0; i < origen.length; i++) {
            for (int k = 0; k < origen[1].length; k++) {
                dest[i][k] = origen[i][k];
            }
        }
        return dest;
    }
}
