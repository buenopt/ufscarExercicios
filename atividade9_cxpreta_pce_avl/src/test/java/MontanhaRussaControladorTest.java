import exerc12.ClienteDao;
import exerc12.MontanhaRussaControlador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class MontanhaRussaControladorTest {

    @Test
    public void nomeValidoTest() {
        // Arrange
        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);

        // Act and Assert
        Assertions.assertThrows(Exception.class, () -> {
            controlador.autorizar("", 20);
        });
    }

    @Test
    public void autorizarComIdadeInvalidaTest() {

        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);

        Assertions.assertThrows(Exception.class, () -> {
            controlador.autorizar("João Silva", 0);
        });
    }

    @Test
    public void autorizarClienteNaoEncontradoTest() throws Exception {

        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        String nome = "Maria Souza";

        Mockito.when(clienteDao.ehCliente(nome)).thenReturn(false);


        Assertions.assertThrows(Exception.class, () -> {
            controlador.autorizar(nome, 30);
        });
    }

    @Test
    public void autorizarIdadeEntre18E90Test() throws Exception {
        // Arrange
        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        String nome = "Fernando Bueno";

        Mockito.when(clienteDao.ehCliente(nome)).thenReturn(true);

        String resultado = controlador.autorizar(nome, 25);

        Assertions.assertEquals("autorizado", resultado);
    }

    @Test
    public void autorizarIdadeMenorQue18Test() throws Exception {
        // Arrange
        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        String nome = "Pedro Oliveira";

        Mockito.when(clienteDao.ehCliente(nome)).thenReturn(true);

        String resultado = controlador.autorizar(nome, 15);

        Assertions.assertEquals("acompanhado dos pais", resultado);
    }

    @Test
    public void autorizarIdadeMaiorQue90Test() throws Exception {
        ClienteDao clienteDao = Mockito.mock(ClienteDao.class);
        MontanhaRussaControlador controlador = new MontanhaRussaControlador(clienteDao);
        String nome = "Ana Santos";

        Mockito.when(clienteDao.ehCliente(nome)).thenReturn(true);

        String resultado = controlador.autorizar(nome, 95);

        Assertions.assertEquals("acompanhado do responsavel legal", resultado);
    }
}
