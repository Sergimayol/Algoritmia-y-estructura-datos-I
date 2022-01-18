package alg_pract1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public class ListaCursos implements AccesoLista {

    //Atributo
    private ArrayList<Curso> listaCursos;

    //Constructor
    public ListaCursos() {
        listaCursos = new ArrayList<>();
    }
    
    //Devuelve el nombre del objeto de la posción 'i' de la lista
    public String getNombre(int i) {
        return this.listaCursos.get(i).getNombre();
    }

    //Devuelve longitud lista
    @Override
    public int getLength() {
        return this.listaCursos.size();
    }

    //Devuelve un String de la lista
    @Override
    public String getInfoLista() {
        return this.listaCursos.toString();
    }

    //Devuelve un String del objeto de la posición 
    // 'i' pasada por parámetro de la lista
    @Override
    public String getInfo(int i) {
        return this.listaCursos.get(i).toString();
    }

    //Devuelve un objecto de la posción 'i' de la lista
    @Override
    public Object getObjetoLista(int i) {
        return this.listaCursos.get(i);
    }

    //Devuelve la lista completa en forma de Arraylist
    @Override
    public ArrayList getListaCompleta() {
        return this.listaCursos;
    }

    //Método para ordenar la lista por nombre del 
    //objeto de mayor a menor
    @Override
    public void ordenarLista() {
        Collections.sort(listaCursos, new Comparator<Curso>() {
            @Override
            public int compare(Curso t, Curso t1) {
                return t.getNombre().compareTo(t1.getNombre());
            }
        });
    }

    //Elimina un objeto de la posción i de la lista
    @Override
    public void removeObjectI(int i) {
        this.listaCursos.remove(i);
    }

    //Elimina el objeto pasado por parametro de la lista
    @Override
    public void removeObject(Object o) {
        this.listaCursos.remove((Curso) o);
    }

    //Método para añadir un objeto a la lista
    @Override
    public void addObject(Object o) {
        this.listaCursos.add((Curso) o);
    }
}
