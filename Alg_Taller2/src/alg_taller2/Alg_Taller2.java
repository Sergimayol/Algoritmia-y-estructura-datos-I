package alg_taller2;

import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class Alg_Taller2 {

    private Empresa empresa[];
    private final int NUMMAXEMPRESAS = 10;
    private int cont;

    public static void main(String[] args) {
        new Alg_Taller2().inicio();
    }

    public Alg_Taller2() {
        cont = 0;
        empresa = new Empresa[NUMMAXEMPRESAS];
    }

    private void inicio() {
        //System.out.println(Arrays.toString(empresa));
        boolean salir = false;
        System.out.println("Taller No Evaluable II. - CLASTAD una metodologia de "
                + "disseny de programes orientada a objectes 2021-2022.\n");
        while (!salir) {
            menu();
            switch (leerOpcion("\nIntroducir opción: ")) {
                case 1:
                    darAltaNuevaEmpresa();
                    darAltaNuevoEquipo(empresa[cont]);
                    cont++;
                    break;
                case 2:
                    darAltaNuevoProg(buscarEmpresa());
                    break;
                case 3:
                    listarProgramadoresEquipo(buscarEmpresa());
                    break;
                case 4:
                    verDatosProgramador();
                    break;
                case 5:
                    for (Empresa empresa1 : empresa) {
                        if (empresa1 != null) {
                            System.out.println(empresa1);
                        }
                    }
                    break;
                case 6:
                    verListaEquiposEmpresa(buscarEmpresa());
                    break;
                case 7:
                    verListaProgramdoresEquiposEmpresa(buscarEmpresa());
                    break;
                case 0:
                    salir = true;
                    break;
            }
            System.out.println("\n\n");
        }
    }

    private void menu() {
        System.out.println("Opciones: ");
        System.out.println("1. Donar d’alta una empresa i diferents equips de desenvolupament de "
                + "la mateixa.");
        System.out.println("2. Donat un equip de desenvolupament, donar d’alta diferents "
                + "programadors en plantilla i/o contractats.");
        System.out.println("3. Donat un equip de desevolupament, llistar els seus programadors, "
                + "indicant quíns són contractats , quíns de plantilla i quí és el director.");
        System.out.println("4. Donat un programador, indicar a na quín equip de desenvolupament "
                + "pertany i quína és la seva categoria.");
        System.out.println("5. Ver lista empresas");
        System.out.println("6. Ver lista equipos de una empresa");
        System.out.println("7. Ver lista programadores de un equipo de una empresa");
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

    private void verListaProgramdoresEquiposEmpresa(Empresa empresa) {
        EquipoDesarrollo aux;
        try {
            System.out.println("Dispone de estos equipos: ");
            empresa.getListaEquiposDesarrolo();
            System.out.print("Escoja un equipo: ");
            String s = LT.readLine();
            aux = empresa.buscarEquipo(s);
            aux.getListaProgramadores();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void verListaEquiposEmpresa(Empresa empresa) {
        try {
            empresa.getListaEquiposDesarrolo();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void verDatosProgramador() {
        String dni, s;
        try {
            System.out.print("DNI del programador a obtner su información: ");
            dni = LT.readLine();
            for (Empresa empresa1 : empresa) {
                s = empresa1.buscarProgramador(dni);
                if (s != null) {
                    System.out.println(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void darAltaNuevaEmpresa() {
        Empresa nuevaEmpresa;
        try {
            System.out.print("\nNombre de la nueva empresa: ");
            String s = LT.readLine();
            System.out.print("Cif: ");
            String s1 = LT.readLine();
            System.out.print("Ciudad: ");
            String s2 = LT.readLine();
            System.out.print("Pais: ");
            String s3 = LT.readLine();
            nuevaEmpresa = new Empresa(s, s1, s2, s3);
            empresa[cont] = nuevaEmpresa;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void darAltaNuevoEquipo(Empresa empresa) {
        try {
            System.out.println("\nPara finalizar la creación de nuevos equipos escriba un '.'");
            String s = "";
            while (!".".equals(s)) {
                System.out.print("\nIntroduzca nombre del equipo: ");
                s = LT.readLine();
                if (!".".equals(s)) {
                    empresa.incluirNuevoEquipo(s);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void darAltaNuevoProg(Empresa empresa) {
        EquipoDesarrollo aux;
        boolean director = false;
        try {
            if (empresa == null) {
                System.out.println("La empresa que ha elegido no existe");
            } else {
                System.out.println("Dispone de estos equipos: ");
                empresa.getListaEquiposDesarrolo();
                System.out.print("Escoja un equipo: ");
                //Pedir nombre equipo
                String s = LT.readLine();
                //Buscar equipo en la lista
                aux = empresa.buscarEquipo(s);
                if (aux == null) {
                    System.out.println("Equipo no existe");
                } else {
                    //Añadir prog
                    System.out.print("Nombre: ");
                    String s1 = LT.readLine();
                    System.out.print("\nDNI: ");
                    String s2 = LT.readLine();
                    System.out.print("\nTipo programdor: ");
                    String s3 = LT.readLine();
                    System.out.print("\nEs director: ");
                    String s4 = LT.readLine();
                    if ("si".equals(s4) || "Sí".equals(s4) || "Si".equals(s4) || "sí".equals(s4)) {
                        director = true;
                    }
                    aux.incluirNuevoProgramador(s1, s2, s3, director);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void listarProgramadoresEquipo(Empresa empresa) {
        EquipoDesarrollo aux;
        try {
            if (empresa == null) {
                System.out.println("La empresa que ha elegido no existe");
            } else {
                //Pedir nombre equipo
                System.out.print("Introduzaca nombre equipo: ");
                String s = LT.readLine();
                //Buscar equipo en la lista
                aux = empresa.buscarEquipo(s);
                if (aux == null) {
                    System.out.println("Equipo no existe");
                } else {
                    //Dar lista prog
                    aux.getListaProgramadores();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private Empresa buscarEmpresa() {
        System.out.println("Dispone de estas empresas para anlizar: ");
        for (int i = 0; i < empresa.length; i++) {
            if (empresa[i] != null) {
                System.out.println(i + " " + empresa[i].getNombre());
            }
        }
        System.out.print("Escoja una empresa: ");
        String s = LT.readLine();
        for (Empresa empresa1 : empresa) {
            if (s == null ? empresa1.getNombre() == null : s.equals(empresa1.getNombre())) {
                return empresa1;
            }
        }
        return null;
    }
}
