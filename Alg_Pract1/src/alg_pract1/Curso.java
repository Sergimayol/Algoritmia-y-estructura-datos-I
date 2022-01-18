/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_pract1;

/**
 *
 * @author Sergi
 */
public class Curso implements AccesoElemento {

    //Atributos
    private String nombre;
    private String codigo;
    private ListaAsignaturas listaAsignatura;

    //Constructor
    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        if (this.nombre.isEmpty()) {
            this.nombre = " ";
        }
        if (this.codigo.isEmpty()) {
            this.codigo = " ";
        }
        this.listaAsignatura = new ListaAsignaturas();
    }

    //Devuelve el código de un Objeto
    @Override
    public String getCodigo() {
        return codigo;
    }

    //Permite asignación código de un Objeto
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Devuelve el nombre de un Objeto
    @Override
    public String getNombre() {
        return nombre;
    }

    //Permite asignación nombre de un Objeto
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso: nombre=> " + nombre + ", codigo=> " + codigo;
    }

    //Método para añadir una asignatura a la lista
    public void addAsignatura(Asignatura a) {
        this.listaAsignatura.addObject(a);
    }

    //Devuelve la longitud de la lista
    public int getLengthListaAsig() {
        return this.listaAsignatura.getLength();
    }

    //Devuelve la asignatura de al posición pasada por parámetro
    public Asignatura getObjetoLista(int i) {
        return (Asignatura) this.listaAsignatura.getObjetoLista(i);
    }

    //Elimina la asignatura pasada por parámetro
    public void removeAsignatura(Asignatura a) {
        this.listaAsignatura.removeObject(a);
    }

    //Devuelve String con todas las asognaturas de la lista
    public String verAsignaturas() {
        String asig = "";
        for (int i = 0; i < this.listaAsignatura.getLength(); i++) {
            asig += this.listaAsignatura.getInfo(i) + "\n";
        }
        return asig;
    }

    //Devuelve el nombre de la asignatura de la posición pasada por parámetro
    public String getNombreAsignatura(int i) {
        return this.listaAsignatura.getNombre(i);
    }

    //Deveulve la lista de estudiantes
    public ListaAsignaturas getListaAsignatura() {
        return listaAsignatura;
    }

    //Asignacion de un lista de asignaturas
    public void setListaAsignatura(ListaAsignaturas listaAsignatura) {
        this.listaAsignatura = listaAsignatura;
    }

}
