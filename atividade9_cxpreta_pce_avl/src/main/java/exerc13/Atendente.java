package exerc13;

public class Atendente {
    private ProdutoDAO produtoDAO;

    public Atendente(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public String efetuarPedidoDeOrcamento(String codigoDeBarras, int quantidade)

            throws IllegalArgumentException, SemEstoqueException {
        // Verifica se o código de barras contém apenas números e tem tamanho de 13 caracteres
        if (!codigoDeBarras.matches("\\d{13}")) {
            throw new IllegalArgumentException("Código de barras inválido");
        }

        // Verifica se a quantidade está dentro dos limites permitidos
        if (quantidade < 1 || quantidade > 1000) {
            throw new IllegalArgumentException("Quantidade inválida");
        }

        // Obtém a quantidade disponível no estoque
        int quantidadeDisponivel = produtoDAO.getQuantidadeDisponivel(codigoDeBarras);

        // Verifica se a quantidade solicitada é maior que a quantidade em estoque
        if (quantidade > quantidadeDisponivel) {
            throw new SemEstoqueException();
        }

        // Decide o tipo de orçamento com base na quantidade solicitada em relação ao estoque
        if (quantidade < quantidadeDisponivel / 2) {
            return "Orcamento normal";
        } else {
            return "Orcamento variavel";
        }
    }
}


