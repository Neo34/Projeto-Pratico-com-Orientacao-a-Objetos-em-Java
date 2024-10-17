package entidade;

/**
 * Classe que representa um produto físico, que pode ser enviado via correio ou transportadora.
 */
public class ProdutoFisico extends Produto {
    private double peso;

    public ProdutoFisico(String codigo, double peso, double preco, int quantidade) {
        setCodigo(codigo);
        setPreco(preco);
        setQuantidade(quantidade);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calcularFrete() {
        // Exemplo de cálculo: o frete é baseado no peso e quantidade de produtos
        return peso * getQuantidade() * 0.1;
    }
}
