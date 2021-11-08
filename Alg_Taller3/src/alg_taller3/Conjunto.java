package alg_taller3;

import java.util.ArrayList;

/**
 *
 * @author Sergi
 */
public class Conjunto implements AccesoLista {

    private ArrayList<Elemento> conjunto;

    public Conjunto() {
        conjunto = new ArrayList<>();
    }

    @Override
    public int getLongitud() {
        return conjunto.size();
    }

    @Override
    public String getInfo(int i) {
        return conjunto.get(i).escribir();
    }

    @Override
    public void poner(String s, double d) {
        poner(new NumeroReal(s, d));
    }

    @Override
    public void poner(String s, String s2) {
        poner(new MensajeTexto(s, s2));
    }

    @Override
    public String getInfoTotal() {
        String s = "";
        for (int j = 0; j < getLongitud(); j++) {
            s += conjunto.get(j).escribir();
        }
        return s;
    }

    private void poner(Elemento e) {
        conjunto.add(e);
    }

}
