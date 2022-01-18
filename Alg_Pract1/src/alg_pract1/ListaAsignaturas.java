package alg_pract1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public class ListaAsignaturas implements AccesoLista {

    //Atributo
    private ArrayList<Asignatura> listaAsignaturas;

    //Constructor
    public ListaAsignaturas() {
        this.listaAsignaturas = new ArrayList<>();
    }

    //Deveulve un String con el nombre de la asignatura de 
    //la posción pasada por parametro
    public String getNombre(int i) {
        return this.listaAsignaturas.get(i).getNombre();
    }

    //Devuelve longitud lista
    @Override
    public int getLength() {
        return this.listaAsignaturas.size();
    }

    //Devuelve un String de la lista
    @Override
    public String getInfoLista() {
        return this.listaAsignaturas.toString();
    }

    //Devuelve un String del objeto de la posición 
    // 'i' pasada por parámetro de la lista
    @Override
    public String getInfo(int i) {
        return this.listaAsignaturas.get(i).toString();
    }

    //Devuelve un objecto de la posción 'i' de la lista
    @Override
    public Object getObjetoLista(int i) {
        return this.listaAsignaturas.get(i);
    }

    //Devuelve la lista completa en forma de Arraylist
    @Override
    public ArrayList getListaCompleta() {
        return this.listaAsignaturas;
    }

    //Método para ordenar la lista por nombre del 
    //objeto de mayor a menor
    @Override
    public void ordenarLista() {
        Collections.sort(listaAsignaturas, new Comparator<Asignatura>() {
            @Override
            public int compare(Asignatura t, Asignatura t1) {
                return t.getNombre().compareTo(t1.getNombre());
            }
        });
    }

    //Elimina un objeto de la posción i de la lista
    @Override
    public void removeObjectI(int i) {
        this.listaAsignaturas.remove(i);
    }

    //Elimina el objeto pasado por parametro de la lista
    @Override
    public void removeObject(Object o) {
        this.listaAsignaturas.remove((Asignatura) o);
    }

    //Método para añadir un objeto a la lista
    @Override
    public void addObject(Object o) {
        this.listaAsignaturas.add((Asignatura) o);
    }

}
