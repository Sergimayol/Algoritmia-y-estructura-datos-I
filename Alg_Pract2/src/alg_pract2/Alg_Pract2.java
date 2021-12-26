package alg_pract2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Alg_Pract2 extends JFrame implements ActionListener {

    private Container panelContenidos;
    private JPanel panelPrincipal;
    private Tablero tablero[];
    private int numSoluciones;

    public static void main(String[] args) {
        new Alg_Pract2().inicio();
    }

    public Alg_Pract2() {
        this.panelPrincipal = new JPanel();
        this.panelPrincipal.setLayout(new BorderLayout());
    }

    //Método principal
    private void inicio() {
        getAllTableros();
        configVentana();
        configMenuBar();
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
        panelPrincipal.add(tablero[0], BorderLayout.CENTER);
        panelContenidos.add(panelPrincipal, BorderLayout.CENTER);
        //Activar visualización contenedor JFrame ventana
        setVisible(true);
    }

    //Este método es el encargado de la gestión de acciones y configuración 
    //de los botones del menuBar. 
    private void configMenuBar() {
        //CONFIGURACIÓN CONTENEDOR JPanel contenedor del panelMenu
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.LIGHT_GRAY);
        panelMenu.setLayout(new BorderLayout());

        //DECLARACIÓN COMPONENTE JMenuBar (barra de menu)
        JMenuBar barraMenu = new JMenuBar();

        //DECLARACIÓN Y CONFIGURACIÓN COMPONENTES JMENUS DE LA BARRA DE MENU
        JMenu opciones = new JMenu("Opciones");

        //DECLARACIÓN OPCIONES JMenuItem
        JMenuItem salir = new JMenuItem("Salir");
        JMenuItem soluciones = new JMenuItem("Soluciones");

        //Asociación componente JMenuItem, con gestor de evento gestorEventoMenu
        salir.addActionListener(this);
        soluciones.addActionListener(this);

        //Asignación componentes JMenuItem con su correspondiente JMenu
        opciones.add(soluciones);
        opciones.add(salir);

        //Introducción de la componentes JMenu en el JMenuBar
        barraMenu.add(opciones);
        //Introducción de la componentes JMenuBar en el JPanel
        panelMenu.add(barraMenu, BorderLayout.SOUTH);

        //Adicion del mapa y barraMenu al JPanel panelContenidos
        panelContenidos.add(panelMenu, BorderLayout.NORTH);
    }

    private void getAllTableros() {
        NQueens2 q = new NQueens2(4);
        q.inicio();
        this.numSoluciones = NQueens2.getAccount();
        this.tablero = new Tablero[this.numSoluciones];
        ArrayList aux = q.getSoluciones();
        int n = q.getN();
        int cont = 0;
        int[][] tableroaux = null;
        boolean inicio = true;
        int fila = 0, columna = 0;
        for (int i = 0; i < aux.size(); i++) {
            if (i % (n * n) == 0) {
//                System.out.println();
                if (!inicio && cont <= NQueens2.getAccount()) {
                    this.tablero[cont++] = new Tablero(tableroaux, NQueens2.getAccount());
                }
                if (tableroaux != null) {
//                    System.out.println(Arrays.deepToString(tableroaux));
                    inicio = true;
                }
                tableroaux = new int[n][n];
                fila = 0;
                columna = 0;
            }
            if (i % n == 0) {
//                System.out.println();
                columna = 0;
                if (!inicio) {
                    fila++;
                }
                inicio = false;
            }
//            System.out.print(aux.get(i) + " ");
            tableroaux[fila][columna++] = (int) aux.get(i);
        }
//        System.out.println("\n" + Arrays.deepToString(tableroaux));
        this.tablero[cont] = new Tablero(tableroaux, NQueens2.getAccount());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Soluciones":
                String[] datosventana = {"Número solución a ver: "};
                String titulo = "Dispone de " + this.numSoluciones + " soluciones";
                boolean entradaCorrecta = false;
                int entrada = 0;
                try {
                    while (!entradaCorrecta) {
                        datosventana = new lecturaDatos(this, datosventana, titulo, true).getDatosTexto();
                        if (!datosventana[0].isEmpty()) {
                            entrada = Integer.parseInt(datosventana[0]);
                        }
                        if (entrada >= 0 && entrada <= this.numSoluciones) {
                            entradaCorrecta = true;
                        }
                    }
                    this.panelPrincipal.add(this.tablero[entrada], BorderLayout.CENTER);
                    this.tablero[entrada].setVisible(true);
                    for (int i = 0; i < this.tablero.length; i++) {
                        if (i == entrada) {
                            this.tablero[i].setVisible(false);
                        }
                    }
                    this.panelPrincipal.validate();
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + e.toString());
                }
                break;
            case "Salir":
                System.exit(0);
                break;
            default:
                throw new AssertionError();
        }
    }

}
