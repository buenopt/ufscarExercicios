package exerc1Test;


import exerc1.Pessoa;
import exerc1.PessoaDAO;
import exerc1.RHService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;


/**
 *
 * @author fbueno
 */
public class PessoaDAOTest {

     private PessoaDAO pessoaDAO;
    private RHService rhService;

    @BeforeEach
    public void setup() {
        // Cria uma instância mock de RHService usando Mockito
        rhService = Mockito.mock(RHService.class);
        pessoaDAO = new PessoaDAO(rhService);
    }

    @Test
    public void testExistePessoaPessoaExistente() {
        // Cria um exemplo de pessoa existente
        Pessoa pessoaExistente = new Pessoa();
        pessoaExistente.setNome("Fernando Bueno");
        pessoaExistente.setCodigo(1);

        // Cria uma lista com a pessoa existente
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoaExistente);

        // Configura o comportamento esperado do mock RHService
        Mockito.when(rhService.getAllPessoas()).thenReturn(pessoas);

        // Executa o método a ser testado
        boolean resultado = pessoaDAO.existePessoa("Fernando Bueno");

        // Verifica se o resultado é true (pessoa existe)
        Assertions.assertTrue(resultado);
    }

    @Test
    public void testExistePessoaPessoaNaoExistente() {
        // Cria uma lista vazia (nenhuma pessoa)
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        // Configura o comportamento esperado do mock RHService
        Mockito.when(rhService.getAllPessoas()).thenReturn(pessoas);

        // Executa o método a ser testado
        boolean resultado = pessoaDAO.existePessoa("Fernando Bueno");

        // Verifica se o resultado é false (pessoa não existe)
        Assertions.assertFalse(resultado);
    }

}
