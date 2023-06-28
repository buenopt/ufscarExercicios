package exerc17;

import java.util.ArrayList;
public class AClass {
    private Coder1 coder1;
    private Coder2 coder2;
    private Coder3 coder3;

    public AClass(Coder1 coder1, Coder2 coder2, Coder3 coder3) {
        this.coder1 = coder1;
        this.coder2 = coder2;
        this.coder3 = coder3;
    }

    public String cifrar(ArrayList<String> msg) {
        // Nó 1: Retorna "INVALID" se msg for nula, vazia ou contiver "STOP"
        if (msg == null || msg.size() == 0 || msg.contains("STOP"))
            return "INVALID";

        // Nó 2: Retorna "C1-C2" se coder1.m1(msg) e coder2.m2(msg) forem verdadeiros
        if (coder1.m1(msg) && coder2.m2(msg))
            return "C1-C2";

        var count = 0;

        // Nó 3: Executa o loop for
        for (String s : msg) {
            // Nó 4: Incrementa count se o elemento for igual a "HI"
            if (s.equals("HI"))
                count++;
        }

        // Nó 5: Verifica se count é maior ou igual a 2
        if (count >= 2)
            // Nó 6: Retorna "2 OR MORE HIs" se count for maior ou igual a 2
            return "2 OR MORE HIs";

        int num = coder3.m3();

        // Nó 7: Verifica se num é maior que 1
        if (num > 1) {
            String ret = "";

            // Nó 8: Executa o loop for de 1 até num (inclusive)
            for (int i = 1; i <= num; i++)
                // Nó 9: Concatena "-" e o primeiro elemento de msg repetido num vezes em ret
                ret += "-" + msg.get(0);

            // Nó 10: Retorna o valor de ret
            return ret;
        }

        // Nó 11: Retorna o primeiro elemento de msg
        return msg.get(0);
    }

}
