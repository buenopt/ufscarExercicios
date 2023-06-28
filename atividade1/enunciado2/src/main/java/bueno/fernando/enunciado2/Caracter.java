
package bueno.fernando.enunciado2;

/**
 *
 * @author fbueno
 */
public class Caracter {

    public String acharCaracter(int tamanho, char cadeia[], char caracterProcurado) {
        if (tamanho < 1 || tamanho > 20) {
            return "comprimento invalido";
        }
        if (cadeia.length != tamanho) {
            return "comprimento fornecido diferente do comprimento real";
        }
        for (int i = 0; i < cadeia.length; i++) {
            char c = cadeia[i];
            if (c == caracterProcurado) {
                return String.valueOf(i);
            }
        }
        return "caracter nao encontrado";
    }
}
