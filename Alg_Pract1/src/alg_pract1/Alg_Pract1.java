package alg_pract1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public class Alg_Pract1 extends JFrame implements ActionListener {

    //Atributos
    private Container panelContenidos;
    private JPanel panelBotones;
    private JPanel panelTexto;
    private JButton opcionesBotones[];
    private JTextArea textoInfoOpciones;
    private final Color colorCasillas;
    private final Font fuenteDisplayTexto;
    private Colegio cole;
    private JComboBox<String> combo;
    //Extra
    private JLabel autores;
    private JPanel panelAutores;

    //Main
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alg_Pract1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Alg_Pract1().inicio();
        });
    }

    //Constructor
    public Alg_Pract1() {
        opcionesBotones = new JButton[8];
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(8, 1));
        panelBotones.setBackground(Color.WHITE);
        panelTexto = new JPanel();
        panelTexto.setLayout(new BorderLayout());
        panelTexto.setBackground(Color.WHITE);
        colorCasillas = Color.LIGHT_GRAY;
        fuenteDisplayTexto = new Font("Arial", Font.PLAIN, 16);
        cole = new Colegio();
        //Adicion autores :D (EXTRA)
        autores = new JLabel("               Autores: Alejandro Rodríguez Arguimbau & Sergi Mayol Matos");
        autores.setFont(new Font("Arial", Font.ITALIC, 16));
        panelAutores = new JPanel();
        panelAutores.setLayout(new BorderLayout());
        panelAutores.setBackground(Color.WHITE);
        panelAutores.add(autores, BorderLayout.CENTER);
    }

    //Método principal
    private void inicio() {
        configOpcionesUsuario();
        configTextoDisplayUsuario();
        configVentana();
    }

    //Configuración panel botones usuario
    private void configOpcionesUsuario() {
        for (int i = 0; i < opcionesBotones.length; i++) {
            opcionesBotones[i] = new JButton();
            opcionesBotones[i].setBackground(colorCasillas);
            opcionesBotones[i].setFont(new Font("Arial", Font.BOLD, 14));
            opcionesBotones[i].setFocusable(false);
            opcionesBotones[i].addActionListener(this);
            panelBotones.add(opcionesBotones[i]);
        }
        opcionesBotones[0].setText("Dar de alta un curso");
        opcionesBotones[1].setText("Matricular estudiante");
        opcionesBotones[2].setText("Dar de baja un curso");
        opcionesBotones[3].setText("Dar de baja una asignatura");
        opcionesBotones[4].setText("Ver asignaturas de un curso");
        opcionesBotones[5].setText("Ver curso de una asignatura");
        opcionesBotones[6].setText("Ver curso y asignaturas de un estudiante");
        opcionesBotones[7].setText("Salir");
    }

    //Configuración panel display texto
    private void configTextoDisplayUsuario() {
        textoInfoOpciones = new JTextArea();
        textoInfoOpciones.setBackground(Color.WHITE);
        textoInfoOpciones.setForeground(Color.BLACK);
        textoInfoOpciones.setEditable(false);
        textoInfoOpciones.setFont(fuenteDisplayTexto);
        textoInfoOpciones.setLayout(new BorderLayout());
        JScrollPane scrollBar = new JScrollPane(textoInfoOpciones, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelTexto.add(scrollBar, BorderLayout.CENTER);
        //Autores (EXTRA)
        panelTexto.add(panelAutores, BorderLayout.SOUTH);
    }

    ////Configuración de la ventana gráfica
    private void configVentana() {
        //Añadimos un titulo a la ventana
        setTitle("PRACTICA 1 - GESTION ACTIVIDADES DE UN COLEGIO");
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
        panelContenidos.add(panelTexto, BorderLayout.CENTER);
        panelContenidos.add(panelBotones, BorderLayout.WEST);
        //Activar visualización contenedor JFrame ventana
        setVisible(true);
    }

    @SuppressWarnings("empty-statement")
    private void darAltaCurso() {
        Curso c = null;
        Asignatura a = null;
        int numAsignaturas;
        String[] datosVentana = {"Nombre: ", "Código: ", "Tipo de Curso: ", "Especidalidad/curso: ", "Núm. Asignaturas: "};
        String[] datosAsignatura = {"Nombre: ", "Código: ", "Tipo Asignatura:  ", "Especidalidad/Créditos: "};
        try {
            textoInfoOpciones.removeAll();
            datosVentana = new lecturaDatos(this, datosVentana, "Dar alta Curso", false).getDatosTexto();
            if (null == datosVentana[2] || datosVentana[2].isEmpty()) {
                //datos erroneos
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha añadido ningun tipo de curso.\n");
            } else {
                switch (datosVentana[2].toLowerCase()) {
                    case "fp":
                    case "formacionprofesional":
                    case "formacion profesional":
                    case "formación profesional":
                        c = new FormacionProfesional(datosVentana[0], datosVentana[1], datosVentana[3]);
                        break;
                    case "bachiller":
                    case "bach":
                    case "bachillerato":
                        c = new Bachiller(datosVentana[0], datosVentana[1], datosVentana[3]);
                        break;
                    default:
                        textoInfoOpciones.setForeground(Color.RED);
                        textoInfoOpciones.setText("No se ha añadido ningun tipo de curso.\n");
                        break;
                }
            }
            if (c == null) {
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha añadido ningun curso.\n");
            } else {
                textoInfoOpciones.setForeground(Color.GREEN.darker());
                textoInfoOpciones.setText("Curso dado de alta con éxito.\n");
                //adicion curso
                cole.addCurso(c);
                cole.ordenarObjecto(0, null);
                if (datosVentana[4] == null || datosVentana[4].isEmpty()) {
                    numAsignaturas = 0;
                } else {
                    numAsignaturas = Integer.parseInt(datosVentana[4]);
                }
                for (int i = 0; i < numAsignaturas; i++) {
                    datosVentana = new lecturaDatos(this, datosAsignatura, "Dar alta asignatura(" + (i + 1) + ")", false).getDatosTexto();
                    if (datosVentana[2].toLowerCase() == null) {
                        //datos erroneos
                        textoInfoOpciones.setForeground(Color.RED);
                        textoInfoOpciones.append("No se ha seleccionado nigún tipo de asignatura.\n");
                    } else {
                        switch (datosVentana[2].toLowerCase()) {
                            case "obligatoria":
                                int aux;
                                if (datosVentana[3].isEmpty()) {
                                    aux = 0;
                                } else {
                                    aux = Integer.parseInt(datosVentana[3]);
                                }
                                a = new AsignaturaObligatoria(datosVentana[0], datosVentana[1], aux);
                                break;
                            case "optativa":
                                a = new AsignaturaOptativa(datosVentana[0], datosVentana[1], datosVentana[3]);
                                break;
                            default:
                                textoInfoOpciones.append("No se ha añadido ningun tipo de asignatura.\n");
                                break;
                        }
                    }
                    if (a == null) {
                        textoInfoOpciones.setForeground(Color.RED);
                        textoInfoOpciones.append("No se ha añadido ninguna asignatura.\n");
                    } else {
                        //adicion Asignatura al curso creado
                        cole.addAsignatura(a, c);
                        cole.ordenarObjecto(1, c);
                        textoInfoOpciones.setForeground(Color.GREEN.darker());
                        if (numAsignaturas > 1) {
                            textoInfoOpciones.append("Las asignaturas han sido añadidas al curso con éxito.\n");
                        } else {
                            textoInfoOpciones.append("La asignatura ha sido añadida al curso con éxito.\n");
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void matricularEstudiante() {
        String[] datosVentana = {"Asignatura: "};
        String[] datosVentanaEstudiante = {"Nombre: ", "DNI: "};
        Object[] as = null;
        Asignatura a;
        Estudiante es;
        try {
            textoInfoOpciones.setText("Dispone de las siguientes asignaturas para matricular al estudiante:\n"
                    + cole.verTodasAsignaturas());
            datosVentana = new lecturaDatos(this, datosVentana, "Seleccionar asignatura", false).getDatosTexto();
            if (!datosVentana[0].isEmpty()) {
                as = cole.buscarAsignatura(datosVentana[0]);
                a = (Asignatura) as[1];
                datosVentana = new lecturaDatos(this, datosVentanaEstudiante, "Matricular estudiante", true).getDatosTexto();
                if (a != null && !datosVentana[0].isEmpty() && !datosVentana[1].isEmpty()) {
                    es = new Estudiante(datosVentana[0], datosVentana[1]);
                    cole.addEstudiante(es, a);
                    cole.ordenarObjecto(2, a);
                    textoInfoOpciones.setForeground(Color.GREEN.darker());
                    textoInfoOpciones.setText("Estudiante, " + es.getNombre() + ", ha sido matriculado a la asignatura "
                            + a.getNombre() + " con éxito.");
                } else {
                    //Asignatura no econtrada o nombre o dni no incluido
                    textoInfoOpciones.setForeground(Color.RED);
                    textoInfoOpciones.setText("No se ha podido matricular al estudiante.\n"
                            + "La asignatura no está dada de alta en ningun curso, o"
                            + "no se ha introducido ningún nombre ni dni.");
                }
            } else {
                //No se ha seleccionado ninguna asignatura
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha podido matricular al estudiante."
                        + "\nNo se ha seleccionado ninguna asignatura.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void darBajaCurso() {
        try {
            textoInfoOpciones.setText("\nSeleccione el curso que desea dar de baja.\n");
            combo = new JComboBox<>();
            for (int i = 0; i < cole.getListaCurso().getLength(); i++) {
                combo.addItem(cole.getNombreCurso(i));
            }
            textoInfoOpciones.add(combo, BorderLayout.PAGE_END);
            combo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s = combo.getSelectedItem().toString();
                    Curso c = cole.buscarCurso(s);
                    cole.eliminarCurso(c);
                    textoInfoOpciones.append("\nSe ha eliminado el " + c.toString());
                    combo.removeItem(s);
                }
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void darBajaAsignatura() {
        String s;
        Curso aux;
        String[] datosVentana = {"Nombre: ", "Código: "};
        try {
            textoInfoOpciones.setText("\nEl colegio dispone de los siguientes cursos: \n"
                    + cole.verCursos() + "\n\nIntroduzca un curso para dar de baja una asignatura. ");
            datosVentana = new lecturaDatos(this, datosVentana, "Seleccionar curso", true).getDatosTexto();
            if (!datosVentana[0].isEmpty() || !datosVentana[1].isEmpty()) {
                if (datosVentana[0].isEmpty()) {
                    s = datosVentana[1];

                } else {
                    s = datosVentana[0];
                }
                aux = cole.buscarCurso(s);
                textoInfoOpciones.append("\nSe ha seleccionado el curso: " + aux.getNombre());
                combo = new JComboBox<>();
                for (int i = 0; i < aux.getLengthListaAsig(); i++) {
                    combo.addItem(aux.getNombreAsignatura(i));
                }
                textoInfoOpciones.add(combo, BorderLayout.PAGE_END);
                combo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = combo.getSelectedItem().toString();
                        Object[] buscarAsignatura = cole.buscarAsignatura(s);
                        Asignatura a = (Asignatura) buscarAsignatura[1];
                        cole.eliminarAsignatura(a);
                        textoInfoOpciones.append("\nSe ha eliminado la " + a.toString());
                        combo.removeItem(s);
                    }
                });
            } else {
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha introducido ningún curso.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void verAsignaturasCurso() {
        try {
            textoInfoOpciones.setText("\nEl colegio dispone de los siguientes cursos: \n"
                    + cole.verCursos() + "\n\nSelecciona un curso para ver sus asignaturas: ");
            combo = new JComboBox<>();
            for (int i = 0; i < cole.getListaCurso().getLength(); i++) {
                combo.addItem(cole.getNombreCurso(i));
            }
            textoInfoOpciones.add(combo, BorderLayout.PAGE_END);
            combo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Curso c = cole.buscarCurso(combo.getSelectedItem().toString());
                    textoInfoOpciones.append("\n" + c.getNombre() + " tiene las siguientes "
                            + "asignaturas:\n" + c.verAsignaturas() + "\n");
                    for (int i = 0; i < c.getLengthListaAsig(); i++) {
                        textoInfoOpciones.append("A la asignatura " + c.getNombreAsignatura(i)
                                + " están matriculados:\n" + c.getObjetoLista(i).verEstudiante() + "\n");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void verCursoAsignatura() {
        String[] datosVentana = {"Asignatura: "};
        Object[] as = null;
        Asignatura aux;
        try {
            textoInfoOpciones.setText("Dispone de las siguientes asignaturas:\n" + cole.verTodasAsignaturas());
            datosVentana = new lecturaDatos(this, datosVentana, "Seleccionar asignatura", false).getDatosTexto();
            if (!datosVentana[0].isEmpty()) {
                as = cole.buscarAsignatura(datosVentana[0]);
                aux = (Asignatura) as[1];
                if (as != null) {
                    textoInfoOpciones.append("\n" + as[1].toString() + "\npertenece al curso:\n" + as[0].toString()
                            + "\n y están matriculados:\n" + aux.verEstudiante());
                } else {
                    textoInfoOpciones.setForeground(Color.RED);
                    textoInfoOpciones.setText("La asignatura introducida no se encuentra en ninguna lista.");
                }
            } else {
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha introducido ninguna asignatura.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void verCursoAsignaturaEstudiante() {
        Object[] o = null;
        String s;
        String[] datosVentana = {"Nombre: ", "Dni: "};
        try {
            textoInfoOpciones.setText("En el colegio hay los siguientes estudiantes:\n" + cole.verTodosEstudiantes());
            datosVentana = new lecturaDatos(this, datosVentana, "Selección estudiante", true).getDatosTexto();
            if (!datosVentana[0].isEmpty() || !datosVentana[1].isEmpty()) {
                if (!datosVentana[0].isEmpty()) {
                    //busqueda por nombre
                    s = datosVentana[0];

                } else {
                    //busqueda por dni
                    s = datosVentana[1];
                }
                o = cole.buscarEstudiante(s);
                if (o != null) {
                    textoInfoOpciones.setText("El estudiante: " + o[2].toString() + "\nPertenece al curso: " + o[0].toString()
                            + "\nEsta matriculado a la asignatura: " + o[1].toString());
                } else {
                    textoInfoOpciones.setForeground(Color.RED);
                    textoInfoOpciones.setText("Estudiante no encontrado.");
                }
            } else {
                textoInfoOpciones.setForeground(Color.RED);
                textoInfoOpciones.setText("No se ha introducido ningún estudiante.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void restaurarDisplayTexto() {
        textoInfoOpciones.setText(" ");
        textoInfoOpciones.removeAll();
        textoInfoOpciones.setForeground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        restaurarDisplayTexto();
        switch (ae.getActionCommand()) {
            case "Dar de alta un curso":
                darAltaCurso();
                break;
            case "Matricular estudiante":
                matricularEstudiante();
                break;
            case "Dar de baja un curso":
                darBajaCurso();
                break;
            case "Dar de baja una asignatura":
                darBajaAsignatura();
                break;
            case "Ver asignaturas de un curso":
                verAsignaturasCurso();
                break;
            case "Ver curso de una asignatura":
                verCursoAsignatura();
                break;
            case "Ver curso y asignaturas de un estudiante":
                verCursoAsignaturaEstudiante();
                break;
            case "Salir":
                //Cerrar aplicación
                System.exit(0);
                break;
        }
    }
}
