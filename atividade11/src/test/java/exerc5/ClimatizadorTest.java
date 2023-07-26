package exerc5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClimatizadorTest {

    private Climatizador climatizador;

    @BeforeEach
    public void setup() {
        climatizador = new Climatizador();
    }

    @Test
    public void testUmidificar() {
        // Estado Inicial: Desligado, sem umidificação, velocidade 0
        Assertions.assertFalse(climatizador.umidificando());

        // Ligado, umidificando, velocidade 1
        climatizador.ligar();
        climatizador.umidificar();
        Assertions.assertFalse(climatizador.umidificando());

        // Ligado, umidificando, velocidade 2
        climatizador.aumentarV();
        climatizador.umidificar();
        Assertions.assertTrue(climatizador.umidificando());

        // Desligado, sem umidificação, velocidade 0
        climatizador.desligar();
        climatizador.umidificar(); // Deve ser ignorado porque está desligado
        Assertions.assertFalse(climatizador.umidificando());
    }

    @Test
    public void testDesligar() {
        // Verificar se o climatizador está desligado inicialmente
        assertFalse(climatizador.umidificando());
        assertEquals(0, climatizador.velocidade());

        // Ligar o climatizador e verificar se ele está funcionando
        climatizador.ligar();
        assertTrue(climatizador.umidificando());

        // Desligar o climatizador e verificar se ele parou de funcionar
        climatizador.desligar();
        assertFalse(climatizador.umidificando());
        assertEquals(0, climatizador.velocidade());

        // Verificar se o climatizador está realmente desligado após a chamada do método desligar()
        assertFalse(climatizador.umidificando());

    }

    @Test
    public void testTransicoes() {
        // Estado Inicial: Desligado, sem umidificação, velocidade 0
        assertFalse(climatizador.umidificando());
        assertEquals(0, climatizador.velocidade());

        // Transição: Desligado -> Ligado (Velocidade 1)
        climatizador.ligar();
        assertTrue(climatizador.umidificando());
        assertEquals(1, climatizador.velocidade());

        // Transição: Ligado (Velocidade 1) -> Velocidade 2
        climatizador.aumentarV();
        assertTrue(climatizador.umidificando());
        assertEquals(2, climatizador.velocidade());

        // Transição: Velocidade 2 -> Velocidade 3 (como não tem o método para aumentar a velocidade novamente, deve permanecer em 2)
        climatizador.aumentarV();
        assertTrue(climatizador.umidificando());
        assertEquals(2, climatizador.velocidade());

        // Transição: Velocidade 2 -> Velocidade 1
        climatizador.diminuirV();
        assertTrue(climatizador.umidificando());
        assertEquals(1, climatizador.velocidade());

        // Transição: Velocidade 1 -> Desligado
        climatizador.desligar();
        assertFalse(climatizador.umidificando());
        assertEquals(0, climatizador.velocidade());
    }

}