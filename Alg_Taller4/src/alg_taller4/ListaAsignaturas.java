/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg_taller4;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 */
public class ListaAsignaturas implements AccesoLista {

    private ArrayList<Asignatura> listaAsignaturas;

    public ListaAsignaturas() {
        this.listaAsignaturas = new ArrayList<>();
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public void removeAsignatura(int i) {
        listaAsignaturas.remove(i);
    }

    public Asignatura getAsignatura(int i) {
        return this.listaAsignaturas.get(i);
    }

    @Override
    public void addAsignaturaLista(Asignatura asignatura) {
        listaAsignaturas.add(asignatura);
    }

    @Override
    public int getLength() {
        return listaAsignaturas.size();
    }

    @Override
    public String getInfoLista() {
        return listaAsignaturas.toString();
    }

    @Override
    public String getInfo(int i) {
        return listaAsignaturas.get(i).toString();
    }

    @Override
    public void addCursoLista(Curso curso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
