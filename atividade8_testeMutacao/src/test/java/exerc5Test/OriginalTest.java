package exerc5Test;

import exerc5.MathOps;
import exerc5.Mutante1;
import exerc5.Original;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OriginalTest {

    @Test
    public void testSomaDeFatoriais() {
        // Mock da interface MathOps
        MathOps mathOps = Mockito.mock(MathOps.class);

        // Criando instância da classe Original com o mock MathOps
        Original original = new Original(mathOps);
        //Mutante1 original =new Mutante1(mathOps);
        //Mutante2 original =new Mutante2(mathOps);
        //Mutante3 original =new Mutante3(mathOps);

        // Vetor de teste
        int[] vetor = {1, 2, 3, 4};

        // Definindo comportamento do mock para o método fatorial
        when(mathOps.fatorial(2)).thenReturn(2);
        when(mathOps.fatorial(4)).thenReturn(24);

        // Testando o método somaDeFatoriais
        int resultado = original.somaDeFatoriais(vetor);

        // Verificando o resultado
        assertEquals(26, resultado);

        // Verificando a interação com o mock
        Mockito.verify(mathOps, Mockito.times(2)).fatorial(Mockito.anyInt());
    }
}
