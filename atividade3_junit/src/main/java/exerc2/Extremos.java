package exerc2;

public class Extremos {
    int menor, maior, indiceMenor, indiceMaior;
    public Extremos(int menor, int indiceMenor, int maior, int indiceMaior) {
        this.menor = menor;
        this.maior = maior; this.indiceMenor = indiceMenor; this.indiceMaior = indiceMaior;
    }
    public int getMenor() {
        return menor; }
    public int getMaior() { return maior;
    }
    public int getIndiceMenor() {
        return indiceMenor; }
    public int getIndiceMaior() { return indiceMaior;
    }
}
