package exerc2Test;

import exerc2.Extremos;
import exerc2.Utilitario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class UtilitarioTest {
    @Test
    public void testAcharExtremos_Caso1() throws Exception {
        Utilitario utilitario = new Utilitario();
        int[] vetor = {1, 2, 3, 4, 5, 6};

        Extremos extremos = utilitario.acharExtremos(vetor);

        Assertions.assertEquals(1, extremos.getMenor());
        Assertions.assertEquals(0, extremos.getIndiceMenor());
        Assertions.assertEquals(6, extremos.getMaior());
        Assertions.assertEquals(5, extremos.getIndiceMaior());
    }

    @Test
    public void testAcharExtremos_Caso2() throws Exception {
        Utilitario utilitario = new Utilitario();
        int[] vetor = {1, 99, 3, -5, 8};

        Extremos extremos = utilitario.acharExtremos(vetor);

        Assertions.assertEquals(-5, extremos.getMenor());
        Assertions.assertEquals(3, extremos.getIndiceMenor());
        Assertions.assertEquals(99, extremos.getMaior());
        Assertions.assertEquals(1, extremos.getIndiceMaior());
    }

    @Test
    public void testAcharExtremos_Caso3() {
        Utilitario utilitario = new Utilitario();
        int[] vetor = {};

        Assertions.assertThrows(Exception.class, () -> {utilitario.acharExtremos(vetor);});
    }

    @Test
    public void testAcharExtremos_Caso4() {
        Utilitario utilitario = new Utilitario();
        int[] vetor = null;

        Assertions.assertThrows(Exception.class, () -> {
            utilitario.acharExtremos(vetor);
        });
    }
}
