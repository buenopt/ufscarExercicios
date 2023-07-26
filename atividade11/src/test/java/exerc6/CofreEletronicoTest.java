import exerc6.CofreEletronico;
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
            fail("Deveria ter lançado uma exceção");
        } catch (RuntimeException e) {
            assertEquals("Senha errada. Tente novamente", e.getMessage());
            assertTrue(cofre.travado());
        }
        assertTrue(cofre.travado());

        // Tentativa 2: Senha errada novamente
        try {
            cofre.digitarSenha("9876");
            fail("Deveria ter lançado uma exceção");
        } catch (RuntimeException e) {
            assertEquals("Senha errada. Tente novamente", e.getMessage());
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
            assertEquals("Cofre bloqueado por tentativas; reiniciar", e.getMessage());
            assertTrue(cofre.travado());
        }
    }

    @Test
    public void testTransicoesNaoCobertas() {
        // Porta inicialmente aberta
        assertEquals("aberta", cofre.statusPorta());
        assertFalse(cofre.travado());

        // Tentar inserir senha com a porta aberta deve lançar exceção
        assertThrows(RuntimeException.class, () -> cofre.inserirSenha("1234"));
        assertFalse(cofre.travado());

        // Tentar travar o cofre sem definir senha deve lançar exceção
        cofre.fecharPorta();
        assertThrows(RuntimeException.class, () -> cofre.digitarSenha("4321"));
        assertFalse(cofre.travado());

        // Definir senha correta e travar o cofre
        cofre.inserirSenha("1234");
        cofre.fecharPorta();
        assertTrue(cofre.travado());
    }
}
