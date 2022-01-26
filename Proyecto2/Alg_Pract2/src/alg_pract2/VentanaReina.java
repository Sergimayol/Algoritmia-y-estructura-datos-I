package alg_pract2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaReina extends JFrame {

    ImageIcon imatge = new ImageIcon("src/imagenes/queen.png");
    private JLabel[][] tablero;
    private int tamTablero, fila1, col1;
    private int idx = 0;
    ArrayList<boolean[][]> soluciones;
    String num = "8";
    JPanel ventana;
    JMenuBar barraMenu, barraBotones;
    JMenu menu;
    JButton resuelve;
    JMenuItem tamaño;
    Dimension dim;
    Tauler tauler;

    public void inicializa(int dimension) {
        this.tamTablero = dimension;
        ventana = new JPanel();
        ventana.setLayout(new GridLayout(dimension, dimension));
        this.setTitle("Práctica 2 Backtracking");
        barraMenu = new JMenuBar();
        barraBotones = new JMenuBar();
        menu = new JMenu("Menú");
        tamaño = new JMenuItem("Elige el tamaño del tablero");
        resuelve = new JButton("Resolver");
        inicializaTablero(dimension);
        seleccionaCasilla();
        tamaño.addActionListener((ActionEvent ae) -> {
            removeListener();
            num = JOptionPane.showInputDialog(null, "Introduce el tamaño del tablero: ", 0);
            inicializaTablero(Integer.parseInt(num));
            seleccionaCasilla();
        });
        resuelve.addActionListener((ActionEvent ae) -> {
            NQueens1 p3 = new NQueens1(tablero.length, fila1, col1);
            pintaSolucio(p3.buscarSolucion());
        });
        menu.add(tamaño);
        barraMenu.add(menu);
        barraBotones.add(resuelve);
        barraBotones.setLayout(new GridBagLayout());
        dim = new Dimension(dimension * 80, dimension * 80 + 30);
//        this.getContentPane().add(barraMenu, BorderLayout.NORTH);
        this.getContentPane().add(ventana, BorderLayout.CENTER);
        this.getContentPane().add(barraBotones, BorderLayout.SOUTH);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setSize(dim);
        this.setPreferredSize(new Dimension(744, 523));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializaTablero(int dimension) {
        this.tamTablero = dimension;
        ventana.removeAll();
        tablero = new JLabel[dimension][dimension];
        ventana.setLayout(new GridLayout(dimension, dimension));
        dim = new Dimension(dimension * 80, dimension * 80 + 30);
        ventana.setSize(dim);
        initCasillas(dimension, tablero);
        ventana.updateUI();
    }

    private void initCasillas(int dimension, JLabel[][] tablero) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                tablero[i][j] = new JLabel();
//                tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pintarCasillas(i, j);
                ventana.add(tablero[i][j]);
            }
        }
    }

    private void pintarCasillas(int i, int j) {
        if ((i + j) % 2 == 0) {
            tablero[i][j].setBackground(new Color(227, 206, 167));
        } else {
            tablero[i][j].setBackground(new Color(166, 126, 91));
        }
        tablero[i][j].setOpaque(true);
    }

    private void pintaSolucio(boolean[][] solucio) {
        if (solucio != null) {
            for (int i = 0; i < solucio.length; i++) {
                for (int j = 0; j < solucio.length; j++) {
                    tablero[i][j].setIcon(null);
                    if (solucio[i][j]) {
                        ImageIcon icon = new ImageIcon(imatge.getImage().getScaledInstance(tablero[i][j].getWidth(), tablero[i][j].getHeight(), Image.SCALE_DEFAULT));
                        tablero[i][j].setIcon(icon);
                    }
                }
            }
        }
    }

    private void seleccionaCasilla() {
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                tablero[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent me) {
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        for (int i = 0; i < tamTablero; i++) {
                            for (int j = 0; j < tamTablero; j++) {
                                pintarCasillas(i, j);
                            }
                        }
                        for (int i = 0; i < tamTablero; i++) {
                            for (int j = 0; j < tamTablero; j++) {
                                if (me.getSource() == tablero[i][j]) {
                                    ponerReina(i, j);
                                    fila1 = i;
                                    col1 = j;
                                }
                            }
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent me) {
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                    }
                }
                );
            }
        }
    }

    private void ponerReina(int i, int j) {
        for (int f = 0; f < tamTablero; f++) {
            for (int c = 0; c < tamTablero; c++) {
                if (tablero[f][c].getIcon() != null) {
                    tablero[f][c].setIcon(null);
                    tablero[f][c].revalidate();
                    pintarCasillas(f, c);
                }
            }
        }
        ImageIcon icon = new ImageIcon(imatge.getImage().getScaledInstance(tablero[i][j].getWidth(), tablero[i][j].getHeight(), Image.SCALE_DEFAULT));
        tablero[i][j].setIcon(icon);
    }

    public void removeListener() {
        for (int i = 0; i < tamTablero; i++) {
            for (int j = 0; j < tamTablero; j++) {
                for (MouseListener ml : tablero[i][j].getMouseListeners()) {
                    tablero[i][j].removeMouseListener(ml);
                }
            }
        }
    }
}
