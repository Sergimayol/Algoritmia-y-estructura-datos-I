/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_taller1;

import java.util.Arrays;

/**
 * Taller Evaluable I. - Gestión de memoria dinámica 2021-2022.
 *
 * @authors Alex y Sergi
 */
public class Alg_Taller1 {

    private Lista lista;

    public static void main(String[] args) {
        new Alg_Taller1().inicio();
    }

    private void inicio() {
        boolean sortir = false;
        System.out.println("Taller Evaluable I. - Gestión de memoria dinámica 2021-2022.\n");
        crearLista();
        while (!sortir) {
            menu();
            switch (leerOpcion("\nIntroducir opción: ")) {
                case 1:
                    inserirNodeEsquerra();
                    break;
                case 2:
                    eliminarNode();
                    break;
                case 3:
                    inserirNodeLlistaOrdenada();
                    break;
                case 4:
                    imprimirLlista();
                    break;
                case 0:
                    sortir = true;
                    break;
            }
            System.out.println("\n\n");
        }
    }

    private static void menu() {
        System.out.println("\nSelecciona el programa que desitja emplear: ");
        System.out.println("\n1. Inserció d’un node davant un de donat en una llista.");
        System.out.println("\n2. Eliminació d’un element donat.");
        System.out.println("\n3. Inserció d’un element en una llista ordenada.");
        System.out.println("\n4. Imprimir llista. ");
        System.out.println("\n0. Sortir.");
    }

    private static int leerOpcion(String msg) {
        Integer x = 0;
        try {
            System.out.print(msg);
            x = LT.readInt();
            if (x == null) {
                x = -1;
            }
            while (x != 0 && x != 1 && x != 2 && x != 3 && x != 4) {
                System.out.println("No es una opción correcta.");
                System.out.print("Introduzca una opción disponible.\nIntroducir opción:");
                x = LT.readInt();
                if (x == null) {
                    x = -1;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
        return x;
    }

    private void inserirNodeEsquerra() {
        System.out.print("Introduce la Info del nuevo nodo: ");
        int dato1 = LT.readInt();
        System.out.print("Nodo a buscar:");
        int dato2 = LT.readInt();
        lista.insertarNodoIzq(dato1, dato2);
    }

    private void eliminarNode() {
        try {
            System.out.print("Introduzca un dato que quiera eliminar de la lista: ");
            lista.eliminarNodo(LT.readInt());
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void inserirNodeLlistaOrdenada() {
        try {
            System.out.print("Inserte un nuevo nodo: ");
            lista.incluirNodo(LT.readInt());
            ordenarLista();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void imprimirLlista() {
        System.out.println(lista.toString());
        //System.out.println(lista.libres());
    }

    private void crearLista() {
        String info;
        try {
            lista = new Lista(); //Crear lista vacia
            System.out.println("Crear lista de nodos.\nPara finalizar la addcición"
                    + " de objectos en la lista, escriba un '.'");
            System.out.print("Escriba la información del nodo: ");
            info = LT.readLine();
            //Mientras el usuario quiera añadir nodo a lista
            while (!"".equals(info) && !".".equals(info)) {
                lista.incluirNodo(Integer.parseInt(info));
                System.out.print("Escriba la información del siguiente nodo: ");
                info = LT.readLine();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }

    private void ordenarLista() {
        //Variables
        Lista aux;
        Nodo[] arrayNodos;
        int[] infoNodos;
        try {
            //Crear lista aux
            aux = new Lista();
            //Asignar los nodos al array
            arrayNodos = lista.getArrayListaNodos();
            //Instanciar el int[]
            infoNodos = new int[arrayNodos.length];
            //Asignacion de cada campo Info de los nodos de la lista al int[]
            for (int i = 0; i < arrayNodos.length; i++) {
                infoNodos[i] = arrayNodos[i].getInfo();
            }
            //Ardenacion nodos de menor a mayor
            Arrays.sort(infoNodos);
            //Asignacion de los nodos ordenados a la lista auxiliar
            for (int i = 0; i < infoNodos.length; i++) {
                aux.incluirNodo(infoNodos[i]);
            }
            //LLista original pasa a ser la aux, que contiene los nodos ordenados
            lista = aux;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }
}
