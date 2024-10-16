package entidade;

/**
 * Classe que representa a entidade cliente. Este pode fazer um pedido.
 */
public class Cliente {

    /**
     * Nome completo do cliente.
     */
    private String nome;

    /**
     * Número de CPF(Cadastro de Pessoa Física) do cliente.
     */
    private String cpf;

    /**
     * É uma boa prática fornecer um construtor que permita passar esses valores
     * como parâmetros para tornar a classe mais flexível
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /**
     * Getters and setters public
     **/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    public String getCpfFormatado() {
        return cpf.substring(0, 3) + ".***.***-" + cpf.substring(9);
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{11}")) {//Exemplo de regex simples para validar se o CPF tem 11 dígitos
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido.Deve conter 11 dígitos.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{ nome='" + nome + "'}";
    }
}