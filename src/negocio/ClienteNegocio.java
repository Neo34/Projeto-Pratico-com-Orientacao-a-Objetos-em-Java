package negocio;

import basedados.Banco;
import entidade.Cliente;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     *
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     *
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {

        if (bancoDados.getCliente().getCpfFormatado().equals(cpf)) {
            return Optional.of(bancoDados.getCliente());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Cadastra um novo cliente.
     *
     * @param cliente Novo cliente que terá acesso a aplicação
     */
    //TODO Fazer a inclusão de cliente
    public void cadastrar(Cliente cliente) {
        bancoDados.getCliente().add(cliente);
    }

    /**
     * Exclui um cliente específico.
     *
     * @param cpf CPF do cliente
     */
    //TODO Fazer a exclusão de cliente
    public boolean excluir(String cpf) {
        Optional<Cliente> cliente = consultar(cpf);
        if (cliente.isPresent()) {
            bancoDados.getCliente().remove(cliente.get());
            return true;
        }
        return false;
    }
}