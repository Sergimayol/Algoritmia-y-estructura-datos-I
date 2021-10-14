/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Sergi
 */
public class Actividad1 extends JFrame {

    //Declaración atributos
    private Container panelContenidos;
    private JPanel panelBotones;

    public static void main(String[] args) {
        try {
            new Actividad1();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    //Constructor
    public Actividad1() {
        //Añadimos un titulo a la ventana
        setTitle("Actividad 1 - Gestión cuentas clientes");
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
        //Asignación administrador de Layout BordeLayout al panel de contenidos
        //del JFrame
        panelContenidos.setLayout(new BorderLayout());
        //Metodo encargado de la gestion de las acciones de la interface
        metodoPrincipal();
        //Activar visualización contenedor JFrame ventana
        setVisible(true);
    }

    private void metodoPrincipal() {
        //Barra menu y relacionado
        JMenuBar barraMenu = new JMenuBar();
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.LIGHT_GRAY);
        panelMenu.setLayout(new BorderLayout());
        JMenu opciones = new JMenu("Opciones");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new gestorAccionesIGU());
        opciones.add(salir);
        barraMenu.add(opciones);
        panelMenu.add(barraMenu, BorderLayout.SOUTH);
        panelContenidos.add(panelMenu, BorderLayout.NORTH);

        //Botones y realcionado
        panelBotones = new JPanel();
        panelBotones.setBackground(new Color(237, 237, 237));
        panelBotones.setLayout(new GridLayout(6, 1));
        crearBoton("Crear Cuenta");
        crearBoton("Eliminar Cuenta");
        crearBoton("Visualizar Datos Cuenta");
        crearBoton("Visualizar Cuentas");
        crearBoton("Ingresar Dinero");
        crearBoton("Extraer Dinero");
        panelContenidos.add(panelBotones, BorderLayout.WEST);
    }

    //Método para crear botones y añadirlos a la interficie
    private void crearBoton(String s) {
        JButton boton;
        try {
            boton = new JButton(s);
            panelBotones.add(boton);
            boton.addActionListener(new gestorAccionesIGU());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //Clase encargada de la gestión de todas las acciones que puede realizar el 
    //usuario a través de la interficie gráfica.
    private class gestorAccionesIGU implements ActionListener {

        private Cliente cliente;

        public gestorAccionesIGU() {
            cliente = new Cliente();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (ae.getActionCommand()) {
                case "Crear Cuenta":
                    try {
                        cliente.crearCuenta();
                        System.out.println(cliente.toString());
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case "Eliminar Cuenta":
                    try {
                        cliente.eliminarCuenta(1);
                        System.out.println(cliente.toString());
                    } catch (Exception e) {
                    }
                    break;
                case "Visualizar Datos Cuenta":

                    break;
                case "Visualizar Cuentas":

                    break;
                case "Ingresar Dinero":

                    break;
                case "Extraer Dinero":

                    break;
                case "Salir":
                    System.exit(0);
                    break;
            }
        }

    }
}
