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
public class Empresa {

    private String nombre;
    private String cif;
    private String ciudad;
    private String pais;
    private EquipoDesarrollo primerEquipo;

    public Empresa(String nombre, String cif, String ciudad, String pais) {
        this.nombre = nombre;
        this.cif = cif;
        this.ciudad = ciudad;
        this.pais = pais;
        this.primerEquipo = null;
    }

    @SuppressWarnings("empty-statement")
    public void incluirNuevoEquipo(String nombreEquipo) {
        EquipoDesarrollo equipo;
        try {
            equipo = new EquipoDesarrollo(nombreEquipo);
            //Mirar si la lista no esta vacia e incluir el elemento al principio
            if (primerEquipo == null) {
                primerEquipo = equipo;
                //Si la lista no esta vacia se incluye el nodo al final
            } else {
                EquipoDesarrollo aux;
                for (aux = primerEquipo; aux.getSiguienteEquipo() != null; aux = aux.getSiguienteEquipo());
                aux.setSiguienteEquipo(equipo);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public void getListaEquiposDesarrolo() {
        EquipoDesarrollo aux;
        int i = 0;
        try {
            System.out.println("Lista equipos desarrolladores " + nombre);
            for (aux = primerEquipo; aux != null; aux = aux.getSiguienteEquipo()) {
                i++;
                System.out.println("Equipo: " + i + " " + aux.getNombre());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public EquipoDesarrollo buscarEquipo(String s) {
        EquipoDesarrollo aux = null;
        try {
            for (aux = primerEquipo; aux != null; aux = aux.getSiguienteEquipo()) {
                if (s == null ? aux.getNombre() == null : s.equals(aux.getNombre())) {
                    return aux;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return aux;
    }

    public String buscarProgramador(String s) {
        EquipoDesarrollo aux;
        Programador aux2;
        try {
            for (aux = primerEquipo; aux != null; aux = aux.getSiguienteEquipo()) {
                for (aux2 = aux.getPrimerProgramdor(); aux2 != null; aux2 = aux2.getSiguiente()) {
                    if (aux2.getDni() == null ? s == null : aux2.getDni().equals(s)) {
                        return "El programador pertenece al equipo: " + aux.getNombre()
                                + " y su categoría es: " + aux2.getTipoProgramador();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public EquipoDesarrollo getPrimerEquipo() {
        return primerEquipo;
    }

    public void setPrimerEquipo(EquipoDesarrollo primerEquipo) {
        this.primerEquipo = primerEquipo;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", cif=" + cif + ", ciudad=" + ciudad + ", pais=" + pais + "}";
    }

}
