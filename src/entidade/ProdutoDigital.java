package entidade;

/**
 * Classe que representa um produto digital, que pode ser baixado online e não tem custo de frete.
 */
public class ProdutoDigital extends Produto {

    public ProdutoDigital(String codigo, double preco, int quantidade) {
        setCodigo(codigo);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    @Override
    public double calcularFrete() {
        // Produtos digitais geralmente não possuem frete, então o valor é zero
        return 0;
    }
}
