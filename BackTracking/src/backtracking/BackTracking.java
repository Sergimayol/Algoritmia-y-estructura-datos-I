package backtracking;

public class BackTracking {

    public static void main(String[] args) {
        new BackTracking().inicio();
    }

    private void inicio() {
        long inicio = System.currentTimeMillis();
        new NQueens(20);
        new NQueens2(8);
        new KnightsTour(8);
        new BackPack(8, 4);
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println(tiempo + " segundos");
    }

}
