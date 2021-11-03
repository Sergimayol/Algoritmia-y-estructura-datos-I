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
public class EquipoDesarrollo {

    private String nombre;
    private EquipoDesarrollo siguienteEquipo;
    private Programador primerProgramdor;

    public EquipoDesarrollo(String nombre) {
        this.nombre = nombre;
        this.siguienteEquipo = null;
        this.primerProgramdor = null;
    }

    @SuppressWarnings("empty-statement")
    public void incluirNuevoProgramador(String nombre, String dni, String tipoProgramador, boolean esDirector) {
        Programador prog;
        try {
            prog = new Programador(nombre, dni, tipoProgramador, esDirector);
            //Mirar si la lista no esta vacia e incluir el elemento al principio
            if (primerProgramdor == null) {
                primerProgramdor = prog;
                //Si la lista no esta vacia se incluye el nodo al final
            } else {
                Programador aux;
                for (aux = primerProgramdor; aux.getSiguiente() != null; aux = aux.getSiguiente());
                aux.setSiguiente(prog);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void getListaProgramadores() {
        Programador aux;
        int i = 0;
        try {
            System.out.println("Lista programadores del equipo " + nombre);
            for (aux = primerProgramdor; aux != null; aux = aux.getSiguiente()) {
                i++;
                System.out.println("Programador " + i + aux.getInfo());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EquipoDesarrollo getSiguienteEquipo() {
        return siguienteEquipo;
    }

    public void setSiguienteEquipo(EquipoDesarrollo siguienteEquipo) {
        this.siguienteEquipo = siguienteEquipo;
    }

    public Programador getPrimerProgramdor() {
        return primerProgramdor;
    }

    public void setPrimerProgramdor(Programador primerProgramdor) {
        this.primerProgramdor = primerProgramdor;
    }

    @Override
    public String toString() {
        return "EquipoDesarrollo{" + "nombre=" + nombre + ", siguienteEquipo=" + siguienteEquipo + ", primerProgramdor=" + primerProgramdor + '}';
    }

}
