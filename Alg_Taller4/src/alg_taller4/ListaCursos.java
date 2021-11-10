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
public class ListaCursos implements AccesoLista {

    private ArrayList<Curso> listaCursos;

    public ListaCursos() {
        this.listaCursos = new ArrayList<>();
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Curso getCurso(int i) {
        return this.listaCursos.get(i);
    }

    public void removeCurso(int i) {
        this.listaCursos.remove(i);
    }

    @Override
    public int getLength() {
        return this.listaCursos.size();
    }

    @Override
    public void addAsignaturaLista(Asignatura asignatura) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCursoLista(Curso curso) {
        this.listaCursos.add(curso);
    }

    @Override

    public String getInfoLista() {
        return this.listaCursos.toString();
    }

    @Override
    public String getInfo(int i) {
        return this.listaCursos.get(i).toString();
    }

}
