package exerc6Test;
import exerc6.Mutante1;
import exerc6.Mutante2;
import exerc6.Mutante3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class OriginalTest {
    @Test
    public void testMutante1() {
        Mutante1 mutante1 = new Mutante1();
        String resultado = mutante1.coverterParaRomano(400);
        assertEquals("Cd", resultado);
    }

    @Test
    public void testMutante2() {
        Mutante2 mutante2 = new Mutante2();
        String resultado = mutante2.coverterParaRomano(1000);
        assertEquals("CMC", resultado);
    }

    @Test
    public void testMutante3() {
        Mutante3 mutante3 = new Mutante3();
        String resultado = mutante3.coverterParaRomano(0);
        assertEquals("", resultado);
    }
}
