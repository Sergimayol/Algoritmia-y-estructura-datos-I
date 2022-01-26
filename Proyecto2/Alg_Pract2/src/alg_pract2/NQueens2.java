package alg_pract2;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 */
public class NQueens2 {

    private static int account = 0;
    private ArrayList soluciones;
    private int res[][];
    private int n;

    public NQueens2(int n) {
        this.n = n;
        this.soluciones = new ArrayList();
        this.res = new int[n][n];				// Inicializar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
            }
        }
    }

    public void inicio() {
        dfs(res, n, 0);			// Llamar a la función de búsqueda profunda
        System.out.println();
        System.out.println("Número total de soluciones: " + account);
        System.out.println();
    }

    private void dfs(int res[][], int n, int row) {
        if (row == n) {
            account++;
            System.out.println();
            System.out.println("Solución: " + account);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + "  ");
                    this.soluciones.add(res[i][j]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(res, i, row)) {
                res[i][row] = 1;
                dfs(res, n, row + 1);
                res[i][row] = 0;
            }
        }
    }

    private boolean check(int res[][], int x, int y) {
        for (int i = 0; i < res.length; i++) {
            if (res[x][i] == 1) {
                return false;
            }
            if (res[i][y] == 1) {
                return false;
            }

            for (int j = 0; j < res.length; j++) {
                if (i + j == x + y && res[i][j] == 1) {
                    return false;
                }
                if (i - j == x - y && res[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getAccount() {
        return account;
    }

    public static void setAccount(int account) {
        NQueens2.account = account;
    }

    public ArrayList getSoluciones() {
        return soluciones;
    }

    public void setSoluciones(ArrayList soluciones) {
        this.soluciones = soluciones;
    }

    public int[][] getRes() {
        return res;
    }

    public void setRes(int[][] res) {
        this.res = res;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
