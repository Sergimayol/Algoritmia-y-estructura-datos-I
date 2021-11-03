/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_taller1;

/**
 * Taller Evaluable I. - Gestión de memoria dinámica 2021-2022.
 *
 * @authors Alex y Sergi
 */
public class Nodo {

    //Atributos
    private int info;
    private Nodo siguiente;

    //Constructor
    public Nodo(int info) {
        this.info = info;
        siguiente = null;
    }

    //Devuelve el campo info del nodo
    public int getInfo() {
        return info;
    }

    //Deveulve el siguiente nodo al que apunta el actual
    public Nodo getSiguienteNodo() {
        return siguiente;
    }

    //Método para poder cambiar el campo info del nodo
    public void setInfo(int info) {
        this.info = info;
    }

    //Método para poder asignar el siguiente nodo
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    //Método to String para poder ver la lista
    @Override
    public String toString() {
        return "Nodo{" + "info = " + info + ", siguiente = " + siguiente + '}';
    }

}
