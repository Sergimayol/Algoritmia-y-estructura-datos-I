package alg_pract1;

import java.util.ArrayList;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public class ListaEstudiantes implements AccesoLista {
    //Atributos
    private Estudiante primero;
    
    //Constructor
    public ListaEstudiantes() {
        this.primero = null;
    }

    //Método que devuelve la longitud de la lista
    @Override
    public int getLength() {
        //Se crea una variable auxiliar de Estudiante
        Estudiante aux;
        //Se crea una variable contador de tipo int
        int cont = 0;
        //Se recorre la lista
        for (aux = primero; aux != null; aux = aux.getSiguienteEstudiante()) {
            //El contador va aumentando a medida que se va recorriendo la lista
            cont++;
        }
        //Se devuelve el contador
        return cont;
    }

    //Método que devuelve los elementos de la lista
    @Override
    public String getInfoLista() {
        //Se crea una variable auxiliar de Estudiante
        Estudiante aux;
        //Se crea una variable String 
        String est = "[";
        //Se recorre la lista 
        for (aux = primero; aux != null; aux = aux.getSiguienteEstudiante()) {
            //Se añade la variable auxiliar de Estudiante, y se guarda en la variable String
            est += aux.toString() + ", ";
        }
        //Se devuelve la variable String
        return est + "]";
    }

    //Método que devuelve un elemento de la lista pasado por parámetro
    @Override
    public String getInfo(int i) {
        //Se crea una variable auxiliar de Estudiante
        Estudiante aux;
        //Se crea una variable contador de tipo int
        int cont = 0;
        //Se recorre la lista
        for (aux = primero; aux != null; aux = aux.getSiguienteEstudiante()) {
            //Si coincide el valor del contador con el valor pasado por parámetro
            if (cont == i) {
                //Se devuelve la variable auxiliar
                return aux.toString();
            }
            //Sino se aumenta el contador
            cont++;
        }
        //Sino está el elemento en la lista se devuelve 0 
        return null;
    }

    //Método que devuelve un objeto de la lista pasado por parámetro
    @Override
    public Object getObjetoLista(int i) {
        //Se crea una variable auxiliar de Estudiante
        Estudiante aux;
        //Se crea una variable contador de tipo int
        int cont = 0;
        //Se recorre la lista
        for (aux = primero; aux != null; aux = aux.getSiguienteEstudiante()) {
             //Si coincide el valor del contador con el objeto pasado por parámetro
            if (cont == i) {
                //Se devuelve el objeto 
                return aux;
            }
            //Sino se aumenta el contador
            cont++;
        }
        //Sino está el objeto en la lista se devuelve 0 
        return null;
    }

    //Método para ordenar la lista por orden alfabético
    @Override
    public void ordenarLista() {
        //Si la lista contiene al menos un elemento
        if (getLength() > 1) {
            //Se crea una variable cambio de tipo boolean
            boolean cambio;
            //Hacer
            do {
                Estudiante actual = primero;          
                Estudiante anterior = null;
                Estudiante siguiente = primero.getSiguienteEstudiante();
                cambio = false;
                while (siguiente != null) {
                    if (actual.getNombre().compareTo(siguiente.getNombre()) > 0) {
                        cambio = true;
                        if (anterior != null) {
                            Estudiante sig = siguiente.getSiguienteEstudiante();
                            anterior.setSiguienteEstudiante(siguiente);
                            siguiente.setSiguienteEstudiante(actual);
                            actual.setSiguienteEstudiante(sig);
                        } else {
                            Estudiante sig = siguiente.getSiguienteEstudiante();
                            primero = siguiente;
                            siguiente.setSiguienteEstudiante(actual);
                            actual.setSiguienteEstudiante(sig);
                        }
                        anterior = siguiente;
                        siguiente = actual.getSiguienteEstudiante();
                    } else {
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.getSiguienteEstudiante();
                    }
                }
            } while (cambio);
        }
    }

    //Método para devolver un array list de todos los nodos
    @Override
    public ArrayList getListaCompleta() {
        //Se crea una ArrayList de Estudiante
        ArrayList<Estudiante> lista = new ArrayList<>();
        //Se crea una variable auxiliar de Estudiante
        Estudiante aux;
        //Se recorre la lista
        for (aux = primero; aux != null; aux = aux.getSiguienteEstudiante()) {
            //A medida que se va recorriendo la lista, se van añadiendo a la ArrayList los elementos
            lista.add(aux);
        }
        //Se devuelve la lista
        return lista;
    }

    //Método para remover un elemento de la lista pasado por parámetro
    @Override
    public void removeObjectI(int i) {
        //Verifica si la posición ingresada se encuentre en el rango
        //>= 0 y < que el numero de elementos del la lista.
        if (i >= 0 && i < getLength()) {
            //Consulta si el nodo a eliminar es el primero
            if (i == 0) {
                //Elimina el primer nodo apuntando al siguinte.
                primero = primero.getSiguienteEstudiante();
            } //En caso que el nodo a eliminar este por el medio 
            //o sea el ultimo
            else {
                //Crea una copia de la lista.
                Estudiante aux = primero;
                //Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int j = 0; j < i - 1; j++) {
                    aux = aux.getSiguienteEstudiante();
                }
                //Guarda el nodo siguiente al nodo a eliminar.
                Estudiante siguiente = aux.getSiguienteEstudiante();
                //Elimina la referencia del nodo apuntando al nodo siguiente.
                aux.setSiguienteEstudiante(siguiente.getSiguienteEstudiante());
            }
        }
    }

    //Método para remover un objeto de la lista pasado por parámetro
    @Override
    public void removeObject(Object o) {
        // Consulta si el nodo a eliminar es el pirmero
        if (primero.equals((Estudiante) o)) {
            //El primer nodo apunta al siguiente.
            primero = primero.getSiguienteEstudiante();
        } else {
            //Crea ua copia de la lista.
            Estudiante aux = primero;
            //Recorre la lista hasta llegar al nodo anterior 
            //al de referencia.
            while (!aux.getSiguienteEstudiante().equals((Estudiante) o)) {
                aux = aux.getSiguienteEstudiante();
            }
            //Guarda el nodo siguiente del nodo a eliminar.
            Estudiante siguiente = aux.getSiguienteEstudiante().getSiguienteEstudiante();
            //Enlaza el nodo anterior al de eliminar con el 
            //sguiente despues de el.
            aux.setSiguienteEstudiante(siguiente);
        }
    }

    //Método para añadir un objeto a la lista
    @Override
    @SuppressWarnings("empty-statement")
    public void addObject(Object o) {
        //Si primero no existe
        if (primero == null) {
            //Se crea un objeto Estudiante y se asigna a primero
            primero = (Estudiante) o;
            //Sino
        } else {
            //Se crea una variable auxiliar de Estudiante
            Estudiante aux;
            //Se recorre la lista
            for (aux = primero; aux.getSiguienteEstudiante() != null; aux = aux.getSiguienteEstudiante());
            //Se asigna el nuevo objeto al siguiente del último elemento de la lista
            aux.setSiguienteEstudiante((Estudiante) o);
        }
    }

}
