package backtracking;

/**
 *
 * @author Sergi
 */
public class NQueens2 {

    private static int account = 0;

    public NQueens2(int n) {
        int res[][] = new int[n][n];				// Inicializar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
            }
        }
        inicio(res, n, 0);
    }

    private void inicio(int res[][], int n, int row) {
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
}
