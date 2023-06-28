package exerc17Test;

import exerc17.AClass;
import exerc17.Coder1;
import exerc17.Coder2;
import exerc17.Coder3;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AClassTest {

    @Test
    public void testCifrarInvalidMessage() {
        // Caminho: [1, 2, 3, 10]
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Coder3 coder3 = Mockito.mock(Coder3.class);

        ArrayList<String> msg = new ArrayList<>();
        msg.add("STOP");

        AClass aClass = new AClass(coder1, coder2, coder3);
        String result = aClass.cifrar(msg);

        assertEquals("INVALID", result);
    }

    @Test
    public void testCifrarC1C2() {
        // Caminho: [1, 2, 4, 5]
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Coder3 coder3 = Mockito.mock(Coder3.class);

        ArrayList<String> msg = new ArrayList<>();
        msg.add("HI");

        when(coder1.m1(msg)).thenReturn(true);
        when(coder2.m2(msg)).thenReturn(true);

        AClass aClass = new AClass(coder1, coder2, coder3);
        String result = aClass.cifrar(msg);

        assertEquals("C1-C2", result);
    }

    @Test
    public void testCifrarTwoOrMoreHIs() {
        // Caminho: [1, 2, 4, 6, 7]
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Coder3 coder3 = Mockito.mock(Coder3.class);

        ArrayList<String> msg = new ArrayList<>();
        msg.add("HI");
        msg.add("HI");

        AClass aClass = new AClass(coder1, coder2, coder3);
        String result = aClass.cifrar(msg);

        assertEquals("2 OR MORE HIs", result);
    }

    @Test
    public void testCifrarNumGreaterThanOne() {
        // Caminho: [1, 2, 4, 8, 9, 11, 13]
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Coder3 coder3 = Mockito.mock(Coder3.class);

        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");

        when(coder3.m3()).thenReturn(2);

        AClass aClass = new AClass(coder1, coder2, coder3);
        String result = aClass.cifrar(msg);

        assertEquals("-Hello-Hello", result);
    }

    @Test
    public void testCifrarDefaultCase() {
        // Caminho: [1, 2, 4, 8, 9, 11, 12, 13]
        Coder1 coder1 = Mockito.mock(Coder1.class);
        Coder2 coder2 = Mockito.mock(Coder2.class);
        Coder3 coder3 = Mockito.mock(Coder3.class);

        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hello");

        when(coder3.m3()).thenReturn(1);

        AClass aClass = new AClass(coder1, coder2, coder3);
        String result = aClass.cifrar(msg);

        assertEquals("Hello", result);
    }
}
