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
     * Instância do banco de dados que será usada para armazenar e acessar os pedidos.
     */
    public PedidoNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    private double calcularFrete(List<Produto> produtos, Cupom cupom) {

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

        // Definir padrão de código do pedido (por exemplo, gerar um UUID ou código sequencial)
        String codigo = "PED-" + System.currentTimeMillis(); // Exemplo de código simples usando timestamp
        // Pegar data do dia corrente
        novoPedido.setData(java.time.LocalDate.now());
        // Setar o código e cliente no pedido
        novoPedido.setCodigo(Integer.parseInt(codigo));

        // Calcular o total do pedido e setá-lo
        double total = calcularTotal(novoPedido.getProdutos(), cupom);
        novoPedido.setTotal(total);

        // Adicionar o pedido no banco
        bancoDados.adicionarPedido(novoPedido);

        // Mensagem de sucesso
        System.out.println("Pedido salvo com sucesso: " + codigo);
    }

    private double calcularTotal(List<Produto> produtos, Cupom cupom) {
        return 0;
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
    public void listarPedidos() {
        Pedido[] pedidos = bancoDados.getPedidos();
        if (pedidos.length == 0) {
            System.out.println("Nenhum pedido foi realizado.");
            return;
        }
        for (Pedido pedido : pedidos) {
            System.out.println("Código: " + pedido.getCodigo() + ", Cliente: " + pedido.getCliente().getNome() + ", Total: " + pedido.getTotal());
        }
    }


}