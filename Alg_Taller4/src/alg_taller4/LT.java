package alg_taller4;

/**
 * *************************************************************************
 * FUNCIONALIDAD: funcionalidades para llevar a cabo la lectura de datos desde
 * el teclado
 **************************************************************************
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LT {

    private static String secuencia = "";
    private static int indice = 0;

    private static String lecturaln() {
        BufferedReader br = null;
        String res = "";
        try {
            br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            res = br.readLine();
        } catch (IOException e) {
        }
        return res;
    }

    // Lectura secuencia de caracteres finalizada con el caracter '.'
    public static char readCharacterSeq() {
        int elemento = 0;
        if (indice == 0) {
            secuencia = lecturaln();
        }
        elemento = indice;
        indice = ((indice == (secuencia.length() - 1))
                || (secuencia.charAt(indice) == '.')) ? 0 : (indice + 1);
        return (secuencia.charAt(elemento));
    }

    // Lectura secuencia de caracteres finalizada con el caracter '\n'
    public static char readCharacterLine() {
        int elemento = 0;
        if (indice == 0) {
            secuencia = lecturaln() + '\n';
        }
        elemento = indice;
        indice = ((indice == (secuencia.length() - 1))
                || (secuencia.charAt(indice) == '\n')) ? 0 : (indice + 1);
        return (secuencia.charAt(elemento));
    }

    // Lectura de número entero.
    public static Integer readInt() {
        Integer res = 0;
        try {
            String pal = lecturaln();
            res = Integer.parseInt(pal);
        } catch (NumberFormatException e) {
            res = null;
        }
        return res;
    }

    // Lectura número real.
    public static Double readDouble() {
        Double res = 0.0;
        try {
            String pal = lecturaln();
            res = Double.parseDouble(pal);
        } catch (NumberFormatException e) {
            res = null;
        }
        return res;
    }

    // Lectura linea de caracteres sin return
    public static String readLine() {
        String res = lecturaln();
        return res;
    }

    // Lectura de caracter.
    public static Character readChar() {
        Character res;
        char[] pal = lecturaln().toCharArray();
        String s = new String(pal);
        if (s.length() == 0) {
            res = null;
        } else {
            res = s.charAt(0);
        }
        return res;
    }

}
