package alg_pract2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Tablero extends JPanel {

    private boolean fin = false;
    private Casilla casilla;
    private int[][] tablero;
    private final int numeroSoluciones;

    public Tablero(int[][] tablero, int numeroSoluciones) {
        this.casilla = null;
        this.tablero = tablero;
        this.numeroSoluciones = numeroSoluciones;
        if (tablero != null) {
            setLayout(new GridLayout(tablero.length, tablero.length));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (numeroSoluciones != 0) {
            for (int i = 0; i < tablero.length && !fin; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    if (tablero[i][j] == 1) {
                        //Add reina
                        this.casilla = new Casilla("src/imagenes/queen.png");
                    } else {
                        //Add nada
                        this.casilla = new Casilla("src/imagenes/none.png");
                    }
                    if ((i + j) % 2 == 0) {
                        casilla.setBackground(new Color(227, 206, 167));
                    } else {
                        casilla.setBackground(new Color(166, 126, 91));
                    }
                    add(casilla);
                }
            }
            fin = true;
        } else {
            setLayout(new BorderLayout());
            JPanel panelAux = new JPanel();
            JPanel panelAux2 = new JPanel();
            panelAux2.setLayout(new GridLayout(1, 3));
            JLabel etiqueta = new JLabel("      No tiene solución");
            etiqueta.setFont(new Font("Arial", Font.ITALIC, 24));
            panelAux.setLayout(new GridLayout(tablero.length, tablero.length));
            for (int i = 0; i < tablero.length && !fin; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    this.casilla = new Casilla("sprite/none.png");
                    if ((i + j) % 2 == 0) {
                        casilla.setBackground(new Color(227, 206, 167));
                    } else {
                        casilla.setBackground(new Color(166, 126, 91));
                    }
                    panelAux.add(casilla);
                }
            }
            fin = true;
            panelAux2.add(new JLabel(""));
            panelAux2.add(etiqueta);
            panelAux2.add(new JLabel(""));
            add(panelAux2, BorderLayout.NORTH);
            add(panelAux, BorderLayout.CENTER);
        }
    }
}
