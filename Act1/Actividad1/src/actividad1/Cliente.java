package actividad1;

/**
 *
 * @author Sergi
 */
public class Cliente {

    //Declaración atributos
    private String nombreCliente;
    private Cuenta[] cuentasCliente; //Cambio posible a un arrayList
    private int idCuenta, saldo, contCuentas;
    private final int MAX_CUENTAS = 50;

    //Constructor/es
    public Cliente() {
        this.nombreCliente = "";
        this.cuentasCliente = new Cuenta[MAX_CUENTAS];
        idCuenta = -1;
        saldo = 0;
        contCuentas = 0;
    }

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.cuentasCliente = new Cuenta[MAX_CUENTAS];
        idCuenta = -1;
        saldo = 0;
        contCuentas = 0;
    }

    //Métodos setters
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setCuentasCliente(Cuenta[] cuentasCliente) {
        this.cuentasCliente = cuentasCliente;
    }

    //Métodos getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public Cuenta[] getCuentasCliente() {
        return cuentasCliente;
    }

    //Método que permite creación de una cuenta
    public void crearCuenta() {
        gestionIdCuentas();
//        IngresoSaldo();
        Cuenta cuenta = new Cuenta(idCuenta, saldo);
        cuentasCliente[contCuentas] = cuenta;
        contCuentas = contCuentas + 1;
    }

    //Método para la gestión de Id's de la cuentas de cada cliente
    private void gestionIdCuentas() {
        idCuenta = idCuenta + 1;
    }

//    //Método
//    private void IngresoSaldo(){
//        
//    }
}
