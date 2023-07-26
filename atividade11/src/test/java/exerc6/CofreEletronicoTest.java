package exerc6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CofreEletronicoTest {
    CofreEletronico cofre = new CofreEletronico();
    @Test
    public void testEstadoTravado2Tentativa() {
        cofre.fecharPorta();
        assertEquals("fechada", cofre.statusPorta());
        assertFalse(cofre.travado());

        cofre.inserirSenha("1234");
        assertTrue(cofre.travado());

        // Tentativa 1: Senha errada
        try {
            cofre.digitarSenha("4321");
        } catch (RuntimeException e) {
            assertEquals("Senha errada. Tente novamente", e.getMessage());
        }
        assertTrue(cofre.travado());

        // Tentativa 2: Senha errada novamente
        try {
            cofre.digitarSenha("9876");
        } catch (RuntimeException e) {
            assertEquals("Cofre bloqueado por tentativas; reiniciar", e.getMessage());
            assertTrue(cofre.travado());
        }

        // Tentar inserir a senha novamente após o cofre estar travado
        try {
            cofre.digitarSenha("4321");
        } catch (RuntimeException e) {
            assertEquals("Cofre bloqueado por tentativas; reiniciar", e.getMessage());
            assertTrue(cofre.travado());
        }
    }
@Test
    public void testTravarCofreERetornarAteDestravado() {
    cofre.fecharPorta();
    cofre.inserirSenha("1234");
    assertTrue(cofre.travado());

    // Tentar digitar senha correta após o cofre estar travado
    try {
        cofre.digitarSenha("1234");
    } catch (RuntimeException e) {
        assertEquals("Senha errada. Tente novamente", e.getMessage());
    }
    assertTrue(cofre.travado());
    }

    @Test
    public void testTransicoesNaoCobertas() {
        // Porta inicialmente aberta
        assertEquals("aberta", cofre.statusPorta());
        assertFalse(cofre.travado());

        // Fechar a porta
        cofre.fecharPorta();
        assertEquals("fechada", cofre.statusPorta());
        assertFalse(cofre.travado());

        // Tentar inserir senha com a porta aberta
        try {
            cofre.inserirSenha("1234");
        } catch (RuntimeException e) {
            assertEquals("Porta aberta", e.getMessage());
        }
        assertFalse(cofre.travado());

        // Tentar travar o cofre sem definir senha
        try {
            cofre.fecharPorta();
            cofre.digitarSenha("4321");
        } catch (RuntimeException e) {
            assertEquals("Cofre ja possui senha definida", e.getMessage());
        }
        assertFalse(cofre.travado());

        // Definir senha correta e travar o cofre
        cofre.inserirSenha("1234");
        cofre.fecharPorta();
        assertTrue(cofre.travado());
    }
}
