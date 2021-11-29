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
        libres = null;
    }

    /**
     * Consulta si la lista esta vacia.
     *
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean esVacia() {
        return primero == null;
    }

    /**
     * Elimina la lista
     */
    public void eliminar() {
        // Elimina el valor y la referencia a los demas nodos.
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

    public void insertarNodoFinal(int valor) {
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo(valor);
        // Consulta si la lista esta vacia.
        if (esVacia()) {
            // Inicializa la lista agregando como primero al nuevo nodo.
            primero = nuevo;
            // Caso contrario recorre la lista hasta llegar al ultimo nodo
            //y agrega el nuevo.
        } else {
            // Crea ua copia de la lista.
            Nodo aux = primero;
            // Recorre la lista hasta llegar al ultimo nodo.
            while (aux.getSiguienteNodo() != null) {
                aux = aux.getSiguienteNodo();
            }
            // Agrega el nuevo nodo al final de la lista.
            aux.setSiguiente(nuevo);
        }
    }

    //Inserta un nodo en la lista en la primera posición
    public void insertarNodoInicio(int dato1, int dato2) {
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

    /**
     * Inserta un nuevo nodo despues de otro, ubicado por el valor que contiene.
     *
     * @param referencia valor del nodo anterios al nuevo nodo a insertar.
     * @param valor del nodo a insertar.
     */
    public void insertarPorReferencia(int referencia, int valor) {
        // Define un nuevo nodo.
        Nodo nuevo = new Nodo(valor);
        // Verifica si la lista contiene elementos
        if (!esVacia()) {
            // Consulta si el valor existe en la lista.
            if (buscar(referencia)) {
                // Crea ua copia de la lista.
                Nodo aux = primero;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getInfo() != referencia) {
                    aux = aux.getSiguienteNodo();
                }
                // Crea un respaldo de la continuación de la lista.
                Nodo siguiente = aux.getSiguienteNodo();
                // Enlaza el nuevo nodo despues del nodo de referencia.
                aux.setSiguiente(nuevo);
                // Une la continuacion de la lista al nuevo nodo.
                nuevo.setSiguiente(siguiente);
            }
        }
    }

    /**
     * Inserta un nuevo nodo despues en una posición determinada.
     *
     * @param posicion en la cual se va a insertar el nuevo nodo.
     * @param valor valor del nuevo nodo de la lista.
     */
    public void insrtarPorPosicion(int posicion, int valor) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y <= que el numero de elementos del la lista.
        if (posicion >= 0 && posicion <= getLongitudLista()) {
            Nodo nuevo = new Nodo(valor);
            // Consulta si el nuevo nodo a ingresar va al primero de la lista.
            if (posicion == 0) {
                // Inserta el nuevo nodo al primero de la lista.
                nuevo.setSiguiente(primero);
                primero = nuevo;
            } else {
                // Si el nodo a inserta va al final de la lista.
                if (posicion == getLongitudLista()) {
                    Nodo aux = primero;
                    // Recorre la lista hasta llegar al ultimo nodo.
                    while (aux.getSiguienteNodo() != null) {
                        aux = aux.getSiguienteNodo();
                    }
                    // Inserta el nuevo nodo despues de del ultimo.
                    aux.setSiguiente(nuevo);
                } else {
                    // Si el nodo a insertar va en el medio de la lista.
                    Nodo aux = primero;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguienteNodo();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Nodo siguiente = aux.getSiguienteNodo();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setSiguiente(nuevo);
                    // Une el nuevo nodo con el resto de la lista.
                    nuevo.setSiguiente(siguiente);
                }
            }
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

    public String libres() {
        return "Lista basura = " + libres;
    }

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

    /**
     * Obtiene el valor de un nodo en una determinada posición.
     *
     * @param posicion del nodo que se desea obtener su valor.
     * @return un numero entero entre [0,n-1] n = numero de nodos de la lista.
     * @throws Exception
     */
    public int getValor(int posicion) throws Exception {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < getLongitudLista()) {
            // Consulta si la posicion es el primero de la lista.
            if (posicion == 0) {
                // Retorna el valor del primero de la lista.
                return primero.getInfo();
            } else {
                // Crea una copia de la lista.
                Nodo aux = primero;
                // Recorre la lista hasta la posición ingresada.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguienteNodo();
                }
                // Retorna el valor del nodo.
                return aux.getInfo();
            }
            // Crea una excepción de Posicion inexistente en la lista.
        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }

    /**
     * Busca si existe un valor en la lista.
     *
     * @param referencia valor a buscar.
     * @return true si existe el valor en la lista.
     */
    public boolean buscar(int referencia) {
        // Crea una copia de la lista.
        Nodo aux = primero;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while (aux != null && encontrado != true) {
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.getInfo()) {
                // Canbia el valor de la bandera.
                encontrado = true;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.getSiguienteNodo();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }

    /**
     * Consulta la posición de un elemento en la lista
     *
     * @param referencia valor del nodo el cual se desea saber la posición.
     * @return un valor entero entre [0,n] que indica la posición del nodo.
     * @throws Exception
     */
    public int getPosicion(int referencia) throws Exception {
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea una copia de la lista.
            Nodo aux = primero;
            // COntado para almacenar la posición del nodo.
            int cont = 0;
            // Recoore la lista hasta llegar al nodo de referencia.
            while (referencia != aux.getInfo()) {
                // Incrementa el contador.
                cont++;
                // Avansa al siguiente. nodo.
                aux = aux.getSiguienteNodo();
            }
            // Retorna el valor del contador.
            return cont;
            // Crea una excepción de Valor inexistente en la lista.
        } else {
            throw new Exception("Valor inexistente en la lista.");
        }
    }

    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado por un
     * valor de referencia.
     *
     * @param referencia valor del nodo el cual se desea actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editarPorReferencia(int referencia, int valor) {
        // Consulta si el valor existe en la lista.
        if (buscar(referencia)) {
            // Crea ua copia de la lista.
            Nodo aux = primero;
            // Recorre la lista hasta llegar al nodo de referencia.
            while (aux.getInfo() != referencia) {
                aux = aux.getSiguienteNodo();
            }
            // Actualizamos el valor del nodo
            aux.setInfo(valor);
        }
    }

    /**
     * Actualiza el valor de un nodo que se encuentre en la lista ubicado por su
     * posición.
     *
     * @param posicion en la cual se encuentra el nodo a actualizar.
     * @param valor nuevo valor para el nodo.
     */
    public void editarPorPosicion(int posicion, int valor) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < getLongitudLista()) {
            // Consulta si el nodo a eliminar es el primero.
            if (posicion == 0) {
                // Alctualiza el valor delprimer nodo.
                primero.setInfo(valor);
            } else {
                // En caso que el nodo a eliminar este por el medio 
                // o sea el ultimo
                Nodo aux = primero;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguienteNodo();
                }
                // Alctualiza el valor del nodo.
                aux.setInfo(valor);
            }
        }
    }

    /**
     * Elimina un nodo que se encuentre en la lista ubicado por un valor de
     * referencia.
     *
     * @param referencia valor del nodo que se desea eliminar.
     */
    public void removerPorReferencia(int referencia) {
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (primero.getInfo() == referencia) {
                // El primer nodo apunta al siguiente.
                primero = primero.getSiguienteNodo();
            } else {
                // Crea ua copia de la lista.
                Nodo aux = primero;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while (aux.getSiguienteNodo().getInfo() != referencia) {
                    aux = aux.getSiguienteNodo();
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Nodo siguiente = aux.getSiguienteNodo().getSiguienteNodo();
                // Enlaza el nodo anterior al de eliminar con el 
                // sguiente despues de el.
                aux.setSiguiente(siguiente);
            }
        }
    }

    /**
     * Elimina un nodo que se encuentre en la lista ubicado por su posición.
     *
     * @param posicion en la cual se encuentra el nodo a eliminar.
     */
    public void removerPorPosicion(int posicion) {
        // Verifica si la posición ingresada se encuentre en el rango
        // >= 0 y < que el numero de elementos del la lista.
        if (posicion >= 0 && posicion < getLongitudLista()) {
            // Consulta si el nodo a eliminar es el primero
            if (posicion == 0) {
                // Elimina el primer nodo apuntando al siguinte.
                primero = primero.getSiguienteNodo();
            } // En caso que el nodo a eliminar este por el medio 
            // o sea el ultimo
            else {
                // Crea una copia de la lista.
                Nodo aux = primero;
                // Recorre la lista hasta lleger al nodo anterior al eliminar.
                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguienteNodo();
                }
                // Guarda el nodo siguiente al nodo a eliminar.
                Nodo siguiente = aux.getSiguienteNodo();
                // Elimina la referencia del nodo apuntando al nodo siguiente.
                aux.setSiguiente(siguiente.getSiguienteNodo());
            }

        }
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
