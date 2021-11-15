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
public class Curso implements AccesoElemento {

    private String nombre;
    private String codigo;
    private ListaAsignaturas lista;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.lista = new ListaAsignaturas();
    }

    public void addAsignatura(Asignatura a) {
        lista.addAsignaturaLista(a);
    }

    public String getListaAsignaturas() {
        return lista.getInfoLista();
    }

    public void eliminarAsginatura(int i) {
        lista.removeAsignatura(i);
    }

    public int getLengthLista() {
        return lista.getLength();
    }

    public Asignatura getAsignatura(int i) {
        return this.lista.getAsignatura(i);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre= " + nombre + ", codigo= " + codigo + '}';
    }

}
