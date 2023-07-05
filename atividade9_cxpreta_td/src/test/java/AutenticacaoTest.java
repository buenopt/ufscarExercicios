import exerc14.Autenticacao;
import exerc14.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutenticacaoTest {
    private Autenticacao autenticacao;

    @BeforeEach
    public void setUp() {
        autenticacao = new Autenticacao();
        Usuario admin = new Usuario("admin@example.com", "admin123", "admin");
        Usuario normalUser = new Usuario("user@example.com", "user123", "normal");
        autenticacao.cadastrarUsuario(admin);
        autenticacao.cadastrarUsuario(normalUser);
    }

    @Test
    public void testLoginEmptyEmail() {
        Usuario usuario = new Usuario("", "password", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("E-mail/senha não podem ser vazios.", resultado);
    }

    @Test
    public void testLoginEmptySenha() {
        Usuario usuario = new Usuario("user@example.com", "", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("E-mail/senha não podem ser vazios.", resultado);
    }

    @Test
    public void testLoginInvalidEmail() {
        Usuario usuario = new Usuario("invalid_email", "password", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("E-mail fora do formato.", resultado);
    }

    @Test
    public void testLoginSenhaMenosQue4Caracteres() {
        Usuario usuario = new Usuario("user@example.com", "123", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("A senha deve ter pelo menos 4 caracteres.", resultado);
    }

    @Test
    public void testLoginUsuarioNaoExiste() {
        Usuario usuario = new Usuario("unknown@example.com", "password", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("Usuário não existe.", resultado);
    }

    @Test
    public void testLoginSenhaIncorreta() {
        Usuario usuario = new Usuario("user@example.com", "wrong_password", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("Senha incorreta.", resultado);
    }

    @Test
    public void testLoginAdmin() {
        Usuario usuario = new Usuario("admin@example.com", "admin123", "admin");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("Logado como admin.", resultado);
    }

    @Test
    public void testLoginNormalUser() {
        Usuario usuario = new Usuario("user@example.com", "user123", "normal");
        String resultado = autenticacao.login(usuario);
        Assertions.assertEquals("Logado.", resultado);
    }
}

