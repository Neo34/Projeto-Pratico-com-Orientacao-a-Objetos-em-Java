package console;

import entidade.Produto;
import entidade.ProdutoDigital;
import entidade.ProdutoFisico;

public class Start {
    public static void main(String[] args) {
        Produto produtoFisico = new ProdutoFisico("001", 1.5, 100.0, 2); // Produto físico
        Produto produtoDigital = new ProdutoDigital("002", 50.0, 1); // Produto digital

        System.out.println("Frete do produto físico: " + produtoFisico.calcularFrete());
        System.out.println("Frete do produto digital: " + produtoDigital.calcularFrete());
    }
}
