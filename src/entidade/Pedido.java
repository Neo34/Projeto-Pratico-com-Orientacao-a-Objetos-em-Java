package entidade;

import java.util.List;

/**
 * Classe que representa a entidade pedido, qual é a compra dos produtos por um cliente.
 */
public class Pedido {
    private int codigo;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Pedido(int codigo, Cliente cliente, List<Produto> produtos, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Método para calcular o total do pedido
    private double calcularTotal() {
        double soma = 0;
        for (Produto produto : produtos) {
            soma += produto.getPreco();
        }
        return soma;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", cliente=" + cliente.getNome() +
                ", produtos=" + produtos +
                ", total=" + total +
                '}';
    }
}