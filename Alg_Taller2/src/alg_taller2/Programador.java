/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_taller2;

/**
 *
 * @author Sergi
 */
public class Programador {

    private String nombre;
    private String dni;
    private String tipoProgramador;
    private boolean esDirector;
    private Programador siguiente;

    public Programador(String nombre, String dni, String tipoProgramador, boolean esDirector) {
        this.nombre = nombre;
        this.dni = dni;
        this.tipoProgramador = tipoProgramador;
        if (!"fijo".equals(tipoProgramador)) {
            this.esDirector = false;
        } else {
            this.esDirector = esDirector;
        }
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipoProgramador() {
        return tipoProgramador;
    }

    public void setTipoProgramador(String tipoProgramador) {
        this.tipoProgramador = tipoProgramador;
    }

    public boolean isEsDirector() {
        return esDirector;
    }

    public void setEsDirector(boolean esDirector) {
        this.esDirector = esDirector;
    }

    public Programador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Programador siguiente) {
        this.siguiente = siguiente;
    }

    public String getInfo() {
        return " Nombre = " + nombre + ", dni = " + dni
                + ", tipo de Programador = " + tipoProgramador + ", Director="
                + esDirector;
    }

    @Override
    public String toString() {
        return "Programador{" + "nombre=" + nombre + ", dni=" + dni
                + ", tipoProgramador=" + tipoProgramador + ", esDirector="
                + esDirector + ", siguiente=" + siguiente + '}';
    }

}
