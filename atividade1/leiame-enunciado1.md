A proposta do enunciado 1 era:

Programa 1 - Numero Aleatório /**
O metodo deve receber dois inteiros que representam o inicio e o fim de um intervalo e retornar um numero aleatorio que se encontra dentro do intervalo estabelecido, ou seja, [inicio, fim].
Caso o inicio do intervalo ou o fim do intervalo sejam menor que zero, o metodo deve retornar -1. O metodo tambem retorna -1 quando o inteiro representando o inicio do intervalo for maior ou igual ao inteiro representando o fim do intervalo.
**/
public int gerarNumeroAleatorio(int inicio, int fim) {
if (fim < 0) { return -1;
}
if (inicio >= fim) { return -1;
}
int diff = inicio - fim + 1;
Random random = new Random();
int tInt = random.nextInt(diff); //esse método retorna um número aleatorio //entre 0 e diff [ 0, diff [
return inicio + tInt; }

com essa classe o teste gerou o seguinte erro:

java.lang.IllegalArgumentException: bound must be positive

Foi identificado o seguinte problema:

O problema está ocorrendo porque a diferença entre o início e o fim do intervalo está sendo calculada de forma incorreta.

Na classe Aleatorio, a linha int diff = inicio - fim + 1; está invertendo a subtração. O correto seria int diff = fim - inicio + 1;.

Com isso foi elaborado uma correção na classe Aleatorio para:

import java.util.Random;

public class Aleatorio {

    public int gerarNumeroAleatorio(int inicio, int fim) {
        if (inicio < 0 || fim < 0) {
            return -1;
        }
        if (inicio >= fim) {
            return -1;
        }
        int diff = fim - inicio + 1;
        Random random = new Random();
        int tInt = random.nextInt(diff); // esse método retorna um número aleatório entre 0 e diff [0, diff [
        return inicio + tInt;
    }
}

Para classe de teste foi gerado o seguinte código:

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


