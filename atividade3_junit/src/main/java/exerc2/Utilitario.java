package exerc2;

public class Utilitario {
    public Extremos acharExtremos(int v[]) throws Exception { if(v == null)
        throw new Exception("vetor nao pode ser nulo");
        if(v.length == 0)
            throw new Exception("vetor com zero elementos");
        int menor = v[0], maior = v[0];
        int indiceMenor = 0, indiceMaior = 0;
        for (int i = 1; i < v.length; i++) { if(v[i] < menor) {
            menor = v[i];
            indiceMenor = i; }
            if(v[i] > maior) { maior = v[i]; indiceMaior = i;
            } }
        return new Extremos(menor, indiceMenor, maior, indiceMaior);
    }
}
