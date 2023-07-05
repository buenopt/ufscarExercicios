package exerc14;

import java.util.HashMap;

public class Autenticacao {
    private HashMap<String, Usuario> bancoDeUsuarios;

    public Autenticacao() {
        this.bancoDeUsuarios = new HashMap<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        bancoDeUsuarios.put(usuario.getEmail(), usuario);
    }

    public String login(Usuario usuario) {
        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        // Verifica se o e-mail ou a senha estão vazios
        if (email.isEmpty() || senha.isEmpty()) {
            return "E-mail/senha não podem ser vazios.";
        }

        // Verifica se o e-mail está no formato correto
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            return "E-mail fora do formato.";
        }

        // Verifica se a senha tem pelo menos 4 caracteres
        if (senha.length() < 4) {
            return "A senha deve ter pelo menos 4 caracteres.";
        }

        // Verifica se o usuário existe no banco de dados
        Usuario usuarioCadastrado = bancoDeUsuarios.get(email);
        if (usuarioCadastrado == null) {
            return "Usuário não existe.";
        }

        // Verifica se a senha fornecida é igual à senha armazenada
        if (!senha.equals(usuarioCadastrado.getSenha())) {
            return "Senha incorreta.";
        }

        // Retorna o tipo de usuário logado
        if (usuarioCadastrado.getTipo().equals("admin")) {
            return "Logado como admin.";
        } else {
            return "Logado.";
        }
    }
}
