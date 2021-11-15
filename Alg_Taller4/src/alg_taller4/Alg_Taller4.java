/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_taller4;

/**
 *
 * @author Sergi
 */
public class Alg_Taller4 {

    private Colegio cole;

    public static void main(String[] args) {
        new Alg_Taller4().inicio();
    }

    public Alg_Taller4() {
        cole = new Colegio("Escuela Politecnica");
    }

    private void inicio() {
        boolean salir = false;
        System.out.println("Taller No Evaluable IV.\n");
        while (!salir) {
            menu();
            switch (leerOpcion("\nIntroducir opción: ")) {
                case 1:
                    darAltaCursos();
                    break;
                case 2:
                    addAsginaturaCurso();
                    break;
                case 3:
                    darBajaCurso();
                    break;
                case 4:
                    darBajaAsignatura();
                    break;
                case 5:
                    verAsignaturasCurso();
                    break;
                case 6:
                    verCursoAsignaturas();
                    break;
                case 7:
                    break;
                case 0:
                    salir = true;
                    break;
            }
            System.out.println("\n\n\n");
        }
    }

    private void menu() {
        System.out.println("Opciones: ");
        System.out.println("1. Donar d’alta cursos.");
        System.out.println("2. Afegir una assignatura a un curs donat ja existent.");
        System.out.println("3. Donar de baixa un curs donat.");
        System.out.println("4. Donar de baixa una assignatura d’un curs donat.");
        System.out.println("5. Donat un curs, llistar totes les seves assignatures.");
        System.out.println("6. Donada una assignatura, indicar a quín curs pertany.");
        System.out.println("7. Donada la característica obligatòria/optativa, llistar totes les"
                + "assignatures que la satisfan");
        System.out.println("0. Salir");
    }

    private int leerOpcion(String msg) {
        Integer x = 0;
        try {
            System.out.print(msg);
            x = LT.readInt();
            if (x == null) {
                x = -1;
            }
            while (x != 0 && x != 1 && x != 2 && x != 3 && x != 4 && x != 5
                    && x != 6 && x != 7) {
                System.out.println("No es una opción correcta.");
                System.out.print("Introduzca una opción disponible.\nIntroducir opción:");
                x = LT.readInt();
                if (x == null) {
                    x = -1;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
        return x;
    }

    private void darAltaCursos() {
        String tipo = "";
        String s = "";
        String nombre = "";
        String codigo = "";
        try {
            System.out.println("Cursos: ");
            System.out.println("1. Formación profesional");
            System.out.println("2. Bachillerato");
            System.out.print("Que tipo de curso desea dar de alta: ");
            tipo = LT.readLine();
            if ("1".equals(tipo)) {
                System.out.println("\nEspecialidades FP");
                System.out.println("1. Mecánica");
                System.out.println("2. Electrónica");
                System.out.println("3. Informatica");
                System.out.print("Que especialidad tiene el curso: ");
                s = LT.readLine();
                if (null == s) {
                    s = "Especialidad no especificada.";
                } else {
                    switch (s) {
                        case "1":
                            s = "Mecánica";
                            break;
                        case "2":
                            s = "Electrónica";
                            break;
                        default:
                            s = "Informatica";
                            break;
                    }
                }
            } else {
                System.out.println("Grados: ");
                System.out.println("1. Primero");
                System.out.println("2. Segundo");
                System.out.print("Que grado es :");
                s = LT.readLine();
                if ("1".equals(s)) {
                    s = "Primero";
                } else {
                    s = "Segundo";
                }
            }
            System.out.print("\nNombre del curso: ");
            nombre = LT.readLine();
            System.out.print("\nCódigo del curso: ");
            codigo = LT.readLine();
            cole.addCurso(s, nombre, codigo, Integer.parseInt(tipo));
            System.out.print("Curso creado:)\n ¿Desea añadir asignaturas al curso?\n [y/n]");
            tipo = LT.readLine();
            if ("y".equals(tipo) || "Y".equals(tipo)) {
                addAsginaturaCurso();
            } else {
                System.out.println("Proceso finalizado con éxito.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void addAsginaturaCurso() {
        String c = "";
        try {
            System.out.println("¿A que curso desea añadir la asignatura?");
            c = LT.readLine();
            cole.addAsignatura(cole.buscarCurso(c));
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void darBajaCurso() {
        String c = "";
        try {
            System.out.print("Que curso desea eliminar: ");
            c = LT.readLine();
            cole.eliminarCurso(cole.buscarCurso(c));
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void verAsignaturasCurso() {
        String s = "";
        Curso c;
        try {
            System.out.println("Dispone de los siguientes cursos: ");
            cole.verCursos();
            System.out.println(" ");
            System.out.print("Escriba el curso del cual desea ver las asignaturas: ");
            s = LT.readLine();
            c = cole.buscarCurso(s);
            System.out.println(c.getListaAsignaturas());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void darBajaAsignatura() {
        String s, s2;
        Curso c = null;
        Asignatura a = null;
        try {
            System.out.println("¿Que asignatura quiere dar de baja?");
            s = LT.readLine();
            System.out.print("A que curso pertenece la asignatura: ");
            s2 = LT.readLine();
            c = cole.buscarCurso(s2);
            a = cole.buscarAsignatura(c, s);
            cole.eliminarAsignatura(a, c);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void verCursoAsignaturas() {
        String s;
        Asignatura a;
        Curso c;
        try {
            System.out.print("Asignatura a buscar: ");
            s = LT.readLine();
            for (int i = 0; i < cole.getListaLength(); i++) {
                c = cole.getCurso(i);
                a = cole.buscarAsignatura(c, s);
                if (a != null) {
                    break;
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }
}
