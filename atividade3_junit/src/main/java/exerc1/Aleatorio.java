package exerc1;

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
