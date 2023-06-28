package exerc1Test;

import exerc1.Aleatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AleatorioTest {
    @Test
    public void testGerarNumeroAleatorio() {
        Aleatorio aleatorio = new Aleatorio();

        // Testando intervalo válido
        int inicio = 1;
        int fim = 10;
        int resultado = aleatorio.gerarNumeroAleatorio(inicio, fim);
        Assertions.assertTrue(resultado >= inicio && resultado <= fim);

        // Testando intervalo inválido (início maior ou igual ao fim)
        inicio = 10;
        fim = 1;
        resultado = aleatorio.gerarNumeroAleatorio(inicio, fim);
        Assertions.assertEquals(-1, resultado);

        // Testando início do intervalo negativo
        inicio = -5;
        fim = 10;
        resultado = aleatorio.gerarNumeroAleatorio(inicio, fim);
        Assertions.assertEquals(-1, resultado);

        // Testando fim do intervalo negativo
        inicio = 1;
        fim = -10;
        resultado = aleatorio.gerarNumeroAleatorio(inicio, fim);
        Assertions.assertEquals(-1, resultado);
    }
}
