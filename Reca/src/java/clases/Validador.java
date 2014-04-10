package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Giovani
 */
public class Validador {
    Pattern p;
    Matcher m;    
    
    public boolean isEmailValid(String email){
        p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        m = p.matcher(email);
        if(m.find()) return false;
        else return true;
    }
    public boolean isPasswordValid(String $cadena){
        char[] cadena = $cadena.toLowerCase().toCharArray();
        // Mayor a 6 caracteres
        if (cadena.length <= 6) {
            return false;
        }
        for (int i = 0; i < cadena.length; i++) {
            //Compruebo que no existan caracteres especiales
            if (cadena[i] == ' '
                    || cadena[i] == '='
                    || cadena[i] == '?'
                    || cadena[i] == '+'
                    || cadena[i] == '*'
                    || cadena[i] == '-'
                    || cadena[i] == '%'
                    || cadena[i] == '/'
                    || cadena[i] == '.'
                    || cadena[i] == ','
                    || cadena[i] == ';'
                    || cadena[i] == '!'
                    || cadena[i] == '<'
                    || cadena[i] == '>'
                    || cadena[i] == ':') {
                return false;
            }
        }
        return true;
    }
}
