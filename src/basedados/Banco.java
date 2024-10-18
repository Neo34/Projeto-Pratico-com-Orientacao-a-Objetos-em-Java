package basedados;

import entidade.Cliente;
import entidade.Cupom;
import entidade.Pedido;
import entidade.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por simular um banco de dados. Esta faz as inserções e exclusões da
 * aplicação. Atualizações não são permitidas para facilitar o funcionamento da aplicação.
 */
public class Banco {

    /**
     * Lista que armazena os produtos(livros e cadernos) cadastrados.
     */
    private final List<Produto> produtos;

    /**
     * Lista que armazena os pedidos cadastrados.
     */
    private final List<Pedido> pedidos;

    /**
     * Lista que armazena os cupons disponíveis.
     */
    private final List<Cupom> cupons;

    /**
     * Cliente cadastrado.
     */
    private final Cliente cliente;

    public Banco() {

        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cliente = new Cliente();

        this.cupons = new ArrayList<>();
        cupons.add(new Cupom("CUPOM2", 2));
        cupons.add(new Cupom("CUPOM5", 5));
        cupons.add(new Cupom("CUPOM7", 7));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cupom[] getCupons() {
        return cupons.toArray(new Cupom[cupons.size()]);
    }

    public Pedido[] getPedidos() {
        return pedidos.toArray(new Pedido[pedidos.size()]);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    /*Validação de Índices*/
    public void removerProduto(int posicao) {
        if (posicao >= 0 && posicao < produtos.size()) {
            produtos.remove(posicao);
        } else {
            System.out.println("Posicao invalida.");
        }
        produtos.remove(posicao);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /*Validação de Índices*/
    public void removerPedido(int posicao) {
        if (posicao >= 0 && posicao < pedidos.size()) {
            pedidos.remove(posicao);
        } else {
            System.out.println("Posicao invalida.");
        }
        pedidos.remove(posicao);
    }

    /*método simples de "update" para produtos ou pedidos*/

    public void atualizarProduto(int posicao, Produto novoProduto) {
        produtos.set(posicao, novoProduto);
    }

}



