package exerc5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClimatizadorTest2 {
    private Climatizador climatizador;

    @BeforeEach
    public void setUp() {
        climatizador = new Climatizador();
    }

    @Test
    public void testLigar() {
        climatizador.ligar();
        Assertions.assertTrue(climatizador.umidificando());
        Assertions.assertEquals(1, climatizador.velocidade());
    }

    @Test
    public void testDesligar() {
        climatizador.ligar();
        climatizador.desligar();
        Assertions.assertFalse(climatizador.umidificando());
        Assertions.assertEquals(0, climatizador.velocidade());
    }

    @Test
    public void testUmidificar() {
        climatizador.umidificar();
        Assertions.assertTrue(climatizador.umidificando());

        climatizador.umidificar();
        Assertions.assertFalse(climatizador.umidificando());
    }

    @Test
    public void testAumentarVelocidade() {
        climatizador.ligar();
        Assertions.assertTrue(climatizador.aumentarV());
        Assertions.assertEquals(2, climatizador.velocidade());

        // Tentativa de aumentar além do limite máximo (2)
        Assertions.assertFalse(climatizador.aumentarV());
        Assertions.assertEquals(2, climatizador.velocidade());
    }

    @Test
    public void testDiminuirVelocidade() {
        climatizador.ligar();
        climatizador.aumentarV(); // velocidade atual é 2

        Assertions.assertTrue(climatizador.diminuirV());
        Assertions.assertEquals(1, climatizador.velocidade());

        // Tentativa de diminuir além do limite mínimo (1)
        Assertions.assertFalse(climatizador.diminuirV());
        Assertions.assertEquals(1, climatizador.velocidade());
    }

    @Test
    public void testLigarErro() {
        climatizador.ligar();
        Assertions.assertThrows(RuntimeException.class, () -> climatizador.ligar());
    }

    @Test
    public void testDesligarErro() {
        Assertions.assertThrows(RuntimeException.class, () -> climatizador.desligar());
    }
}
