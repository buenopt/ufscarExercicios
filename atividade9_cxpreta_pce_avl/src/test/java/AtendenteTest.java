import exerc13.Atendente;
import exerc13.ProdutoDAO;
import exerc13.SemEstoqueException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class AtendenteTest {
    @Test
    public void testEfetuarPedidoDeOrcamento_ValidInput_NormalOrcamento() throws SemEstoqueException {
        // Mock do ProdutoDAO
        ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        when(produtoDAO.getQuantidadeDisponivel("1234567890123")).thenReturn(100);

        // Criação do objeto Atendente
        Atendente atendente = new Atendente(produtoDAO);

        // Chamada do método de teste
        String resultado = atendente.efetuarPedidoDeOrcamento("1234567890123", 30);

        // Verificação do resultado esperado
        assertEquals("Orcamento normal", resultado);
    }

    @Test
    public void testEfetuarPedidoDeOrcamento_ValidInput_VariavelOrcamento() throws SemEstoqueException {
        // Mock do ProdutoDAO
        ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        when(produtoDAO.getQuantidadeDisponivel("1234567890123")).thenReturn(100);

        // Criação do objeto Atendente
        Atendente atendente = new Atendente(produtoDAO);

        // Chamada do método de teste
        String resultado = atendente.efetuarPedidoDeOrcamento("1234567890123", 60);

        // Verificação do resultado esperado
        assertEquals("Orcamento variavel", resultado);
    }

    @Test
    public void testEfetuarPedidoDeOrcamento_InvalidCodigo_ExceptionThrown() {
        // Criação do objeto Atendente
        Atendente atendente = new Atendente(null);

        // Chamada do método de teste e verificação da exceção lançada
        assertThrows(IllegalArgumentException.class, () -> {
            atendente.efetuarPedidoDeOrcamento("12345", 50);
        });
    }

    @Test
    public void testEfetuarPedidoDeOrcamento_InvalidQuantidade_ExceptionThrown() {
        // Criação do objeto Atendente
        Atendente atendente = new Atendente(null);

        // Chamada do método de teste e verificação da exceção lançada
        assertThrows(IllegalArgumentException.class, () -> {
            atendente.efetuarPedidoDeOrcamento("1234567890123", 0);
        });
    }

    @Test
    public void testEfetuarPedidoDeOrcamento_InsufficientStock_ExceptionThrown() throws SemEstoqueException {
        // Mock do ProdutoDAO
        ProdutoDAO produtoDAO = Mockito.mock(ProdutoDAO.class);
        when(produtoDAO.getQuantidadeDisponivel("1234567890123")).thenReturn(50);

        // Criação do objeto Atendente
        Atendente atendente = new Atendente(produtoDAO);

        // Chamada do método de teste e verificação da exceção lançada
        assertThrows(SemEstoqueException.class, () -> {
            atendente.efetuarPedidoDeOrcamento("1234567890123", 100);
        });
    }

}
