package negocio;

import basedados.Banco;
import entidade.Cupom;
import entidade.Pedido;
import entidade.Produto;

import java.util.List;

/**
 * Classe para manipular a entidade {@link Pedido}.
 */
public class PedidoNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     *
     * @param banco Banco de dados para ter armazenar e ter acesso os pedidos
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {

        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.calcularFrete();
        }

        if (cupom != null) {
            return total * (1 - cupom.getDesconto());
        } else {
            return total;
        }


    }

    /**
     * Salva um novo pedido sem cupom de desconto.
     *
     * @param novoPedido Pedido a ser armazenado
     */
    public void salvar(Pedido novoPedido) {
        salvar(novoPedido, null);
    }

    /**
     * Salva um novo pedido com cupom de desconto.
     *
     * @param novoPedido Pedido a ser armazenado
     * @param cupom      Cupom de desconto a ser utilizado
     */
    public void salvar(Pedido novoPedido, Cupom cupom) {

        //Definir padrão código
        //Pegar data do dia corrente
        //Formatar código

        //Setar código no pedido
        //Setar cliente no pedido
        //Calcular e set total
        //Adicionar no banco
        //Mensagem
    }

    /**
     * Exclui um pedido a partir de seu código de rastreio.
     *
     * @param codigo Código do pedido
     */
    public void excluir(String codigo) {

        int pedidoExclusao = -1;
        for (int i = 0; i < bancoDados.getPedidos().length; i++) {

            Pedido pedido = bancoDados.getPedidos()[i];
            if (pedido.getCodigo()) {
                pedidoExclusao = i;
                break;
            }
        }

        if (pedidoExclusao != -1) {
            bancoDados.removerPedido(pedidoExclusao);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }
    }

    /**
     * Lista todos os pedidos realizados.
     */
    //TODO Método de listar todos os pedidos

}