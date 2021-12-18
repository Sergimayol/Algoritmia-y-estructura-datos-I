package backtracking;

public class BackTracking {

    public static void main(String[] args) {
        new BackTracking().inicio();
    }

    private void inicio() {
//        new NQueens(16);
//        new KnightsTour(9);
        new BackPack(8, 4);
    }

}
