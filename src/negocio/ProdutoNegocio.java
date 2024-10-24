package negocio;


import basedados.Banco;
import entidade.Produto;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Produto}.
 */
public class ProdutoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     *
     * @param banco Banco de dados para ter armazenar e ter acesso os produtos
     */
    public ProdutoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Salva um novo produto(livro ou caderno) na loja.
     *
     * @param novoProduto Livro ou caderno que pode ser vendido
     */
    public void salvar(Produto novoProduto) {

        String codigo = "PR%04d";
        codigo = String.format(codigo, bancoDados.getProdutos().size());
        novoProduto.setCodigo(codigo);

        boolean produtoRepetido = false;
        for (Produto produto : bancoDados.getProdutos()) {
            /*utilizar o método .equals para comparar o conteúdo das Strings.*/
            if (produto.getCodigo().equals(novoProduto.getCodigo())) {
                produtoRepetido = true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!produtoRepetido) {
            this.bancoDados.adicionarProduto(novoProduto);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }

    /**
     * Exclui um produto pelo código de cadastro.
     *
     * @param codigo Código de cadastro do produto
     */
    public void excluir(String codigo) {
        boolean produtoEncontrado = false;
        Produto[] produtos = bancoDados.getProdutos().toArray(new Produto[0]);

        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                bancoDados.removerProduto(String.valueOf(produto));  // Corrigido para remover o objeto Produto
                produtoEncontrado = true;
                System.out.println("Produto excluído com sucesso.");
                break;
            }
        }

        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado.");
        }
    }

    /**
     * Obtem um produto a partir de seu código de cadastro.
     *
     * @param codigo Código de cadastro do produto
     * @return Optional indicando a existência ou não do Produto
     */
    public Optional<Produto> consultar(String codigo) {

        for (Produto produto : bancoDados.getProdutos()) {

            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return Optional.of(produto);
            }
        }

        return Optional.empty();
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarTodos() {

        if (bancoDados.getProdutos().size() == 0) {
            System.out.println("Não existem produtos cadastrados");
        } else {

            for (Produto produto : bancoDados.getProdutos()) {
                System.out.println(produto.toString());
            }
        }
    }
}