/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class KnightsTour {

    private final int N;

    public KnightsTour(int N) {
        this.N = N;
        solveKT();
    }

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    private boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    private void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (sol[x][y] > 9) {
                    System.out.print(sol[x][y] + " ");
                } else {
                    System.out.print(sol[x][y] + "  ");
                }
            }
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    private boolean solveKT() {
        int sol[][] = new int[N][];
        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++) {
            sol[x] = new int[N];
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            printSolution(sol);
        }

        return true;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    private boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N) {
            return true;
        }
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = - 1; // backtracking
                }
            }
        }

        return false;
    }
}
