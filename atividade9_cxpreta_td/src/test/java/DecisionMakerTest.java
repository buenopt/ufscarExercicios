import exerc15.DecisionMaker;
import exerc15.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecisionMakerTest {

    @Test
    public void testMostrarAnuncioUsuarioInativo() {
        Usuario usuario = new Usuario(100, true, false);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);

        assertFalse(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioViuAnuncioUltimaHora() {
        Usuario usuario = new Usuario(500, false, true);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);

        assertFalse(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioInfluenciadorNaoRelevante() {
        Usuario usuario = new Usuario(1500, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, false);

        assertTrue(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioInfluenciadorRelevante() {
        Usuario usuario = new Usuario(2000, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);

        assertTrue(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioNaoInfluenciadorNaoRelevante() {
        Usuario usuario = new Usuario(500, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, false);

        assertFalse(resultado);
    }

    @Test
    public void testMostrarAnuncioUsuarioNaoInfluenciadorRelevante() {
        Usuario usuario = new Usuario(800, false, false);
        DecisionMaker decisionMaker = new DecisionMaker();

        boolean resultado = decisionMaker.mostrarAnuncio(usuario, true);

        assertTrue(resultado);
    }
}
