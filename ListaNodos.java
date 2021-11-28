/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Sergi
 */
public class ListaNodos {

    //Apuntador al primer elemento de la lista
    private Nodo primero, libres;

    //Constructor
    public ListaNodos() {
        primero = null;
    }

    //Método para insertar un nuevo nodo a la lista
    @SuppressWarnings("empty-statement")
    public void incluirNodo(int cadena) {
        Nodo elemento;
        elemento = new Nodo(cadena);
        //Mirar si la lista no esta vacia e incluir el elemento al principio
        if (primero == null) {
            primero = elemento;
            //Si la lista no esta vacia se incluye el nodo al final
        } else {
            Nodo aux;
            for (aux = primero; aux.getSiguienteNodo() != null; aux = aux.getSiguienteNodo());
            aux.setSiguiente(elemento);
        }
    }

    @SuppressWarnings("empty-statement")
    private void incluirNodoALibres(int cadena) {
        Nodo elemento;
        elemento = new Nodo(cadena);
        //Mirar si la lista no esta vacia e incluir el elemento al principio
        if (libres == null) {
            libres = elemento;
            //Si la lista no esta vacia se incluye el nodo al final
        } else {
            Nodo aux;
            for (aux = libres; aux.getSiguienteNodo() != null; aux = aux.getSiguienteNodo());
            aux.setSiguiente(elemento);
        }
    }

    //Eliminación del nodo y adicion al final de la lista con el campo INFO pasado por parámetro
    public void eliminarNodo(int dato) {
        //Lista de Fems
        ListaNodos listAux;
        Nodo aux, borrar = null;
        listAux = new ListaNodos();
        aux = primero;
        //Se recorre la lista hasta el final
        while (aux != null) {
            //Si el nodo es diferente del que se solicita borrar se incluye 
            //en una lista auxiliar
            if (aux.getInfo() != dato) {
                listAux.incluirNodo(aux.getInfo());
                //Si es el nodo que se desea eliminar se elimina de la lista,ya 
                //que no se inserta en la nueva lista
            } else {
                borrar = new Nodo(aux.getInfo());
            }
            aux = aux.getSiguienteNodo();
        }
        //Si no se ha encontrado el nodo a borrar se informa al usuario
        if (borrar == null) {
            System.out.println("Nodo no encontrado");
            //Si se ha encontrado se incluye en la lista auxiliar
        } else {
            //listAux.incluirNodo(borrar.getInfo());
            incluirNodoALibres(borrar.getInfo());
        }
        //Se apunta el apuntador primero a la nueva lista creada
        primero = listAux.getPrimero();
    }

    //Inserta un nodo en la lista en la primera posición
    public void insertarNodoIzq(int dato1, int dato2) {
        boolean existe = false;
        Nodo aux, nuevoNodo = new Nodo(dato1);
        aux = primero;
        primero = null;
        //Se recorre la lista hasta el final
        while (aux != null) {
            //Si el nodo actual es el que ha pedido el usuario primero se añade 
            //el nuevo nodo y luego el nodo actual de la lista
            if (aux.getInfo() == dato2) {
                incluirNodo(nuevoNodo.getInfo());
                incluirNodo(aux.getInfo());
                existe = true;
                //sino se añade el nodo a lista
            } else {
                existe = false;
                incluirNodo(aux.getInfo());
            }
            //siguiente nodo de la lista
            aux = aux.getSiguienteNodo();
        }
        //Si no existe le nodo que ha decidido buscar el usuario se le avisa
        if (!existe) {
            System.out.println("Nodo no existe");
//            System.out.println("Nodo no existe, se ha añadido al final el nuevo nodo.");
//            incluirNodo(nuevoNodo.getInfo());
        }
    }

    //Imprime todos los campos info de los nodos
    public void getLista() {
        Nodo aux;
        for (aux = primero; aux != null; aux = aux.getSiguienteNodo()) {
            System.out.println(aux.getInfo());
        }
    }

    //Devuelve el nodo apuntador
    public Nodo getPrimero() {
        return primero;
    }

    //Asigna el puntero nodo 
    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    //Devuelve la lista de nodos
    @Override
    public String toString() {
        return "Lista{" + "primero = " + primero + '}';
    }

//    public String libres(){
//        return "Lista basura = " + libres;
//    }
    //Devuelve la longitud de la lista
    public int getLongitudLista() {
        Nodo aux;
        int cont = 0;
        for (aux = primero; aux != null; aux = aux.getSiguienteNodo()) {
            cont++;
        }
        return cont;
    }

    //Devuelve un array con cada nodo de la lista
    public Nodo[] getArrayListaNodos() {
        Nodo aux;
        int indice = 0;
        Nodo[] aux3;
        aux3 = new Nodo[getLongitudLista()];
        aux = primero;
        while (aux != null) {
            aux3[indice] = new Nodo(aux.getInfo());
            indice++;
            aux = aux.getSiguienteNodo();
        }
        return aux3;
    }

    private class Nodo {

        //Atributos
        private int info;
        private Nodo siguiente;

        //Constructor
        public Nodo(int info) {
            this.info = info;
            siguiente = null;
        }

        //Devuelve el campo info del nodo
        public int getInfo() {
            return info;
        }

        //Deveulve el siguiente nodo al que apunta el actual
        public Nodo getSiguienteNodo() {
            return siguiente;
        }

        //Método para poder cambiar el campo info del nodo
        public void setInfo(int info) {
            this.info = info;
        }

        //Método para poder asignar el siguiente nodo
        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        //Método to String para poder ver la lista
        @Override
        public String toString() {
            return "Nodo{" + "info = " + info + ", siguiente = " + siguiente + '}';
        }

    }
}
