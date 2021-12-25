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

    private BackTrackingNQueens q;
    private boolean fin = false;
    private Casilla casilla;
    private static int N;

    public Tablero() {
        casilla = null;
        lecturaDatos();
        q = new BackTrackingNQueens(N);
        setLayout(new GridLayout(q.getN(), q.getN()));
    }

    private void lecturaDatos() {
        String[] datosventana = {"Tamaño tablero: "};
        try {
            datosventana = new lecturaDatos(null, datosventana, "Inicio", true).getDatosTexto();
            if (datosventana[0].isEmpty()) {
                N = 4;
            } else {
                N = Integer.parseInt(datosventana[0]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (q.solveNQ()) {
            int[][] t = q.getBoard();
            for (int i = 0; i < q.getN() && !fin; i++) {
                for (int j = 0; j < q.getN(); j++) {
                    if (t[i][j] == 1) {
                        //Add reina
                        this.casilla = new Casilla("sprite/queen.png");
                    } else {
                        //Add nada
                        this.casilla = new Casilla("sprite/none.png");
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
            panelAux.setLayout(new GridLayout(q.getN(), q.getN()));
            for (int i = 0; i < q.getN() && !fin; i++) {
                for (int j = 0; j < q.getN(); j++) {
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
