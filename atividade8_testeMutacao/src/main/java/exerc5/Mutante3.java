package exerc5;

public class Mutante3 {
    MathOps mathOps;
    public Mutante3(MathOps mathOps) { this.mathOps = mathOps;
    }
    public int somaDeFatoriais(int vet[]) { int soma = 0;
        for (int i = 0; i < vet.length; i++) {
            int numero = vet[i]; if(numero>=0&&numero/2==0){ //'%'->'/'
                soma += mathOps.fatorial(numero); }
        }
        return soma; }
}
