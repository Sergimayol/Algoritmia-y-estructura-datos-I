package alg_pract1;

/**
 *
 * @author Sergi Mayol Matos & Alejandro Rodriguez Arguimbau
 */
public interface AccesoElemento {
    
    //Devuelve el nombre de un Objeto
    public String getNombre();

    //Devuelve el código de un Objeto
    public String getCodigo();

    //Permite asignación nombre de un Objeto
    public void setNombre(String nombre);

    //Permite asignación código de un Objeto
    public void setCodigo(String codigo);

    @Override
    public String toString();

}
