
import bueno.fernando.enunciado2.Caracter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author fbueno
 */
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
