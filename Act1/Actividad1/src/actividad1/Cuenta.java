package actividad1;

/**
 *
 * @author Sergi
 */
public class Cuenta {

    //Declaración atributos
    private int idCuenta, saldo;

    //Constructor
    public Cuenta(int idCuenta, int saldo) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
    }

    //Métodos setters
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    //Métodos getters
    public int getIdCuenta() {
        return idCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    //Método para permitir ingresar una cantidaad de dinero en la cuenta
    public void depositarDinero(int deposito) {
        saldo = saldo + deposito;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", saldo=" + saldo + '}';
    }

}
