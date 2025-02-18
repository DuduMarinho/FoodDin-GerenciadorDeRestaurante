package model.RN;

import model.VO.ClienteVO;
import model.DAO.ClienteDAO;
import java.time.LocalDateTime;

public class ClienteRN {

    private ClienteDAO clienteDAO;

    public ClienteRN() {
        this.clienteDAO = new ClienteDAO();
    }

    public void adicionarCliente(ClienteVO cliente) {

        //TRATAMENTOS DE ERRO

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente nao pode ser Nulo.");
        }
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new IllegalArgumentException("O cpf do cliente nao pode ser Nulo.");
        }

        cliente.setUltimaVisita(LocalDateTime.now());

        clienteDAO.inserir(cliente);
    }

    public void atualizarPontosFidelidade(ClienteVO cliente, Integer pontosAdicionais) {
        if (pontosAdicionais == null || pontosAdicionais < 0) {
            throw new IllegalArgumentException("O numero de pontos adicionais deve ser positivo.");
        }

        Integer pontosAtuais = cliente.getPontosFidelidade();
        cliente.setPontosFidelidade(pontosAtuais + pontosAdicionais);
        }

        clienteDAO.atualizar(cliente);
}

   public ClienteVO buscarClientePorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("O id do cliente nao pode ser Nulo.");
        }
        return clienteDAO.buscarPorId(id);
    }


    public void removerCliente(ClienteVO cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente nao pode ser Nulo.");
        }

        clienteDAO.deletar(cliente.getId());
    }