package entidade;

/**
 * Classe que representa a abstração dos produtos que podem ser vendidos pela loja.
 */
public abstract class Produto {

    private final int id;
    /**
     * Código de identiticação do produto.
     */
    private String codigo;

    /**
     * Valor unitário do produto.
     */
    private double preco;

    /**
     * Quantidade comprada do produto.
     */
    private int quantidade;

    /**
     * Campo estático para gerar IDs únicos para cada produto.
     */
    private static int contadorId = 0;

    public Produto() {
        // Ao instanciar um novo produto, o ID é atribuído automaticamente
        this.id = ++contadorId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public abstract double calcularFrete();

    public int getId() {
        return id;
    }

}