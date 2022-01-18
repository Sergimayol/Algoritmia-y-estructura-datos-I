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
public class Asignatura implements AccesoElemento {

    //Atributos
    private String nombre;
    private String codigo;
    private ListaEstudiantes listaEstudiante;

    //Constructor
    public Asignatura(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        if (this.nombre.isEmpty()) {
            this.nombre = " ";
        }
        if (this.codigo.isEmpty()) {
            this.codigo = " ";
        }
        this.listaEstudiante = new ListaEstudiantes();
    }

    //Método que devuelve el nombre de la Asignatura
    @Override
    public String getNombre() {
        return nombre;
    }

   //Método para asignar el nombre de una Asignatura 
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Método que devuelve el código de la Asignatura
    @Override
    public String getCodigo() {
        return codigo;
    }

    //Método para asignar el código de una Asignatura
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Asignatura: nombre=> " + nombre + ", codigo=> " + codigo;
    }

    //Método para añadir un nuevo Estudiante
    public void addEstudiante(Estudiante e) {
        this.listaEstudiante.addObject(e);
    }

    //Método que devuelve un objeto Estudiante
    public Estudiante getObjetoLista(int i) {
        return (Estudiante) this.listaEstudiante.getObjetoLista(i);
    }

    //Método que devuelve la longitud de la lista de Estudiantes
    public int getLengthListaEst() {
        return this.listaEstudiante.getLength();
    }

    //Método para eliminar un Estudiante de la lista
    public void removeEstudiante(Estudiante e) {
        this.listaEstudiante.removeObject(e);
    }

    //Método para ver un Estudiante
    public String verEstudiante() {
        String est = "";
        for (int i = 0; i < this.listaEstudiante.getLength(); i++) {
            est += this.listaEstudiante.getInfo(i) + "\n";
        }
        return est;
    }

    //Método que devuelve la lista de Estudiantes
    public ListaEstudiantes getListaEstudiante() {
        return listaEstudiante;
    }
    
    //Método que asigna una lista de Estudiantes
    public void setListaEstudiante(ListaEstudiantes listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }

}
