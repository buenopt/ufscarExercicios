Programa 2 - Achar caracter
/**
O metodo recebe como entrada um inteiro positivo no intervalo entre 1 e 20, uma cadeia de caracteres desse comprimento, e um caracter.
Caso o comprimento seja invalido ou o tamanho da cadeia não seja igual ao tamanho passado como parametro, retornar uma mensagem de erro.
Se todos os dados forem válidos, o metodo deve retornar a posição na cadeia em que o caracter é encontrado pela primeira vez ou uma mensagem indicando que o caracter não está presente na cadeia.
**/
public String acharCaracter(int tamanho, char cadeia[], char caracterProcurado) {
if(tamanho < 1 || tamanho > 20) return "comprimento invalido";
if(cadeia.length != tamanho)
return "comprimento fornecido diferente do comprimento real";
for (int i = 0; i < cadeia.length; i++) { char c = cadeia[i];
if(c == cadeia[i])
return String.valueOf(i); }
return "caracter encontrado"; }

Ao gerar teste com a classe acima, gerou o seguinte erro:

gerou esse erro: CaracterTest.testAcharCaracter:25 expected: <caracter nao encontrado> but was: <0>

Com isso foi executado uma correção ao código acima, pois havia um roblema na lógica do método acharCaracter da classe Caracter. 
O erro ocorre porque a comparação dentro do loop for não está correta. 
Em vez de verificar se o caractere atual c é igual ao caractere procurado caracterProcurado, está sendo comparado o caractere atual c com ele mesmo cadeia[i]. 
Isso faz com que a primeira ocorrência do caractere seja sempre encontrada e retorna o índice 0.

Com isso foi gerado nova classe de caracter:

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

Com isso foi gerado a classe de teste abaixo:

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaracterTest {

    @Test
    public void testAcharCaracter() {
        Caracter caracter = new Caracter();

        // Teste de comprimento inválido
        Assertions.assertEquals("comprimento invalido", caracter.acharCaracter(0, new char[] {'a'}, 'a'));
        Assertions.assertEquals("comprimento invalido", caracter.acharCaracter(21, new char[] {'a'}, 'a'));

        // Teste de comprimento diferente do fornecido
        Assertions.assertEquals("comprimento fornecido diferente do comprimento real",
                caracter.acharCaracter(5, new char[] {'a', 'b', 'c', 'd', 'e', 'f'}, 'a'));

        // Teste de caractere não encontrado
        Assertions.assertEquals("caracter nao encontrado",
                caracter.acharCaracter(6, new char[] {'a', 'b', 'c', 'd', 'e', 'f'}, 'g'));

        // Teste de caractere encontrado
        Assertions.assertEquals("3", caracter.acharCaracter(6, new char[] {'a', 'b', 'c', 'd', 'e', 'f'}, 'd'));
    }
}
