package exerc12;

public class MontanhaRussaControlador {
    ClienteDao clienteDao;

    public MontanhaRussaControlador(ClienteDao pClienteDao) {
        clienteDao = pClienteDao;
    }

    public String autorizar(String nome, int idade) throws Exception {
        if (!nomeValido(nome)) {
            throw new Exception("Nome inválido");
        }

        if (!idadeValido(idade)) {
            throw new Exception("Idade inválida");
        }

        if (!clienteDao.ehCliente(nome)) {
            throw new Exception("Cliente não encontrado");
        }

        if (idade >= 18 && idade <= 90) {
            return "autorizado";
        } else if (idade < 18) {
            return "acompanhado dos pais";
        } else {
            return "acompanhado do responsavel legal";
        }
    }

    private boolean nomeValido(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        String[] palavras = nome.split(" ");
        return palavras.length >= 2 && nome.matches("[a-zA-Z ]+");
    }

    private boolean idadeValido(int idade) {
        return idade >= 1 && idade <= 120;
    }
}

