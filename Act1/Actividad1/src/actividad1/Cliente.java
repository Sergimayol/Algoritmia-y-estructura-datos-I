package actividad1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sergi
 */
public class Cliente {

    //Declaración atributos
    private String nombreCliente;
    private ArrayList<Cuenta> cuentasCliente; //Cambio posible a un arrayList
    private int idCuenta, saldo, contCuentas;

    //Constructor/es
    public Cliente() {
        this.nombreCliente = "";
        this.cuentasCliente = new ArrayList<>();
        idCuenta = -1;
        saldo = 0;
        contCuentas = 0;
    }

    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.cuentasCliente = new ArrayList<>();
        idCuenta = -1;
        saldo = 0;
        contCuentas = 0;
    }

    public ArrayList<Cuenta> getCuentasCliente() {
        return cuentasCliente;
    }

    public void setCuentasCliente(ArrayList<Cuenta> cuentasCliente) {
        this.cuentasCliente = cuentasCliente;
    }

    //Métodos setters
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    //Métodos getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    //Método que permite creación de una cuenta
    public void crearCuenta() {
        gestionIdCuentas();
        Cuenta cuenta = new Cuenta(idCuenta, saldo);
        cuentasCliente.add(cuenta);
    }
    
    public void eliminarCuenta(int id){
        cuentasCliente.remove(id);
    }

    //Método para la gestión de Id's de la cuentas de cada cliente
    private void gestionIdCuentas() {
        idCuenta = idCuenta + 1;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getContCuentas() {
        return contCuentas;
    }

    public void setContCuentas(int contCuentas) {
        this.contCuentas = contCuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombreCliente=" + nombreCliente
                + ", cuentasCliente=" + cuentasCliente + ", idCuenta=" + idCuenta
                + ", saldo=" + saldo + ", contCuentas=" + contCuentas + '}';
    }

}
