package alg_pract2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Alg_Pract2 extends JFrame {

    private Container panelContenidos;
    private JPanel panelPrincipal;
    private Tablero tablero;

    public static void main(String[] args) {
        new Alg_Pract2().inicio();
    }

    public Alg_Pract2() {
        this.panelPrincipal = new JPanel();
    }

    //Método principal
    private void inicio() {
        tablero = new Tablero();
        configVentana();
    }

    //Configuración de la ventana gráfica
    private void configVentana() {
        //Añadimos un titulo a la ventana
        setTitle("PRACTICA 2 - BACKTRACKING");
        //Alamacena en la variable nuestro sistema nativo de ventanas
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        //Tamañano de la pantalla del usuario
        Dimension tampant = pantalla.getScreenSize();
        //Obtener el alto de resolución de pantalla
        int altpant = tampant.height;
        //Obtener el ancho de resolución de pantalla
        int anchopant = tampant.width;
        //Localización(x,y) + tamaño(ancho,alto). De esta manera siempre
        //la ventana estará situada en el centro
        setBounds(anchopant / 4, altpant / 4, anchopant / 2, altpant / 2);
        //Activar el cierre interactivo del contenedor JFrame ventana para finalizar
        //ejecución
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Asignación al objeto Container panelContenidos DEL PANEL JContentPane 
        //del JFrame 
        panelContenidos = getContentPane();
        //asignación administrador de Layout BordeLayout al panel de contenidos
        //del JFrame
        panelContenidos.setLayout(new BorderLayout());
        //Adicion panel opcionesBotones al panel contenidos
        panelContenidos.add(tablero, BorderLayout.CENTER);
        //Activar visualización contenedor JFrame ventana
        setVisible(true);
    }

//    private class panelDibujo extends JPanel {
//
//        private BackTrackingNQueens q;
//        private boolean fin = false;
//        private Casilla casilla;
//
//        public panelDibujo() {
//            casilla = null;
//            q = new BackTrackingNQueens(8);
//            setLayout(new GridLayout(q.getN(), q.getN()));
//        }
//
//        @Override
//        public void paintComponent(Graphics g) {
//            if (q.solveNQ()) {
//                int[][] t = q.getBoard();
//                for (int i = 0; i < q.getN() && !fin; i++) {
//                    for (int j = 0; j < q.getN(); j++) {
//                        if (t[i][j] == 1) {
//                            //Add reina
//                            this.casilla = new Casilla("sprite/queen.png");
//                        } else {
//                            //Add nada
//                            this.casilla = new Casilla("sprite/none.png");
//                        }
//                        if ((i + j) % 2 == 0) {
//                            casilla.setBackground(new Color(227, 206, 167));
//                        } else {
//                            casilla.setBackground(new Color(166, 126, 91));
//                        }
//                        add(casilla);
//                    }
//                }
//                fin = true;
//            } else {
//                setLayout(new BorderLayout());
//                JPanel panelAux = new JPanel();
//                JPanel panelAux2 = new JPanel();
//                panelAux2.setLayout(new GridLayout(1, 3));
//                JLabel etiqueta = new JLabel("      No tiene solución");
//                etiqueta.setFont(new Font("Arial", Font.ITALIC, 24));
//                panelAux.setLayout(new GridLayout(q.getN(), q.getN()));
//                for (int i = 0; i < q.getN() && !fin; i++) {
//                    for (int j = 0; j < q.getN(); j++) {
//                        this.casilla = new Casilla("sprite/none.png");
//                        if ((i + j) % 2 == 0) {
//                            casilla.setBackground(new Color(227, 206, 167));
//                        } else {
//                            casilla.setBackground(new Color(166, 126, 91));
//                        }
//                        panelAux.add(casilla);
//                    }
//                }
//                fin = true;
//                panelAux2.add(new JLabel(""));
//                panelAux2.add(etiqueta);
//                panelAux2.add(new JLabel(""));
//                add(panelAux2, BorderLayout.NORTH);
//                add(panelAux, BorderLayout.CENTER);
//            }
//        }
//    }
//
//    private class Casilla extends JPanel {
//
//        private BufferedImage imagen;
//        private boolean fin = false;
//        private String dir;
//
//        public Casilla(String dir) {
//            //Inicialización de BufferedImage
//            imagen = null;
//            this.dir = dir;
//        }
//
//        @Override
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Graphics2D g2D = (Graphics2D) g;
//            try {
//                imagen = ImageIO.read(new File(dir));
//                g2D.drawImage(imagen.getScaledInstance(this.getWidth(), this.getHeight(), 0), 0, 0, this);
//            } catch (IOException e) {
//                System.out.println("Error: " + e.toString());
//            }
//        }
//    }
}
