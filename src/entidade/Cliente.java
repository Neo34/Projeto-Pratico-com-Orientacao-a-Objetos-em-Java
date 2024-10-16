package entidade;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa a entidade cliente. Este pode fazer um pedido.
 */
public class Cliente implements Serializable, Comparable<Cliente> {

    /**
     * Nome completo do cliente.
     */
    private String nome;

    /**
     * Número de CPF(Cadastro de Pessoa Física) do cliente.
     */
    private String cpf;

    /**
     * Construtor padrão inicializa com valores predefinidos.
     */
    public Cliente() {
        this.nome = "Fulano";
        this.cpf = "12345678901";
    }

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
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ",cpf='" + getCpfFormatado() + '\'' + '}';
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}