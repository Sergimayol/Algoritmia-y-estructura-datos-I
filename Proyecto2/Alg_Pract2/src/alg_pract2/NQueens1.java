package alg_pract2;

import javax.swing.JOptionPane;

public class NQueens1 {

    private int tamTablero;
    private int fReina = 0;
    private int cReina = 0;
    boolean[][] solucion;
    boolean resultat = false;

    public NQueens1(int dimension, int fila, int columna) {
        this.tamTablero = dimension;
        this.fReina = fila;
        this.cReina = columna;
    }

    public boolean[][] buscarSolucion() {
        Tauler tauler = new Tauler(tamTablero);
        tauler.setCasilla(this.fReina, this.cReina);
        if (!resolucion(tauler, 0)) {
            System.out.println("No se ha encontrado ninguna solucion");
            JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna solucion");
        }
        return solucion;
    }

    public boolean resolucion(Tauler tauler, int columna) {
        if (cReina == 0 && columna == cReina) {
            columna++;
        }

        for (int i = 0; i < tamTablero && !resultat; i++) {
            if (esSegura(tauler, i, columna)) {
                tauler.setCasilla(i, columna);
                if (columna < tamTablero - 1) {
                    if ((columna + 1) == cReina && cReina < (tamTablero - 1)) {
                        resultat = resolucion(tauler, columna + 2);
                    } else if ((columna + 1) == cReina && cReina == (tamTablero - 1)) {
                        resultat = true;
                        solucion = tauler.getMatriz();
                    } else {
                        resultat = resolucion(tauler, columna + 1);
                    }
                    if (!resultat) {
                        tauler.vaciarCasilla(i, columna);
                    }
                } else {
                    resultat = true;
                    solucion = tauler.getMatriz();
                }
            }
        }
        return resultat;
    }

    private boolean esSegura(Tauler tauler, int fila, int columna) {
        int i, j;
        //Comprova a l'esquerra de la fila
        for (i = 0; i < columna; i++) {
            if (tauler.getCasella(fila, i)) {
                return false;
            }
        }
        //Comprova a la dreta de la fila
        for (i = columna; i < tamTablero; i++) {
            if (tauler.getCasella(fila, i)) {
                return false;
            }
        }

        //Comprova adalt de la casella
        for (i = 0; i < fila; i++) {
            if (tauler.getCasella(i, columna)) {
                return false;
            }
        }
        //Comprova abaix de la casella
        for (i = fila; i < tamTablero; i++) {
            if (tauler.getCasella(i, columna)) {
                return false;
            }
        }

        //Comprova a diagonal superior esquerra
        for (i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        //Comprova la diagonal inferior esquerra
        for (i = fila, j = columna; j >= 0 && i < tamTablero; i++, j--) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }

        //Comprova a diagonal superior dreta
        for (i = fila, j = columna; i >= 0 && j < tamTablero; i--, j++) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        //Comprova la diagonal inferior dreta
        for (i = fila, j = columna; j < tamTablero && i < tamTablero; i++, j++) {
            if (tauler.getCasella(i, j)) {
                return false;
            }
        }
        return true;
    }
}
