package alg_pract1;

import java.util.ArrayList;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public interface AccesoLista {

    //Devuelve longitud lista
    public int getLength();

    //Devuelve un String de la lista
    public String getInfoLista();

    //Devuelve un String del objeto de la posición 
    // 'i' pasada por parámetro de la lista
    public String getInfo(int i);

    //Devuelve un objecto de la posción 'i' de la lista
    public Object getObjetoLista(int i);

    //Devuelve la lista completa en forma de Arraylist
    public ArrayList getListaCompleta();

    //Método para ordenar la lista por nombre del 
    //objeto de mayor a menor
    public void ordenarLista();
    
    //Elimina un objeto de la posción i de la lista
    public void removeObjectI(int i);

    //Elimina el objeto pasado por parametro de la lista
    public void removeObject(Object o);

    //Método para añadir un objeto a la lista
    public void addObject(Object o);
}
