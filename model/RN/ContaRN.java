package model.RN;

import model.VO.ContaVO;
import model.DAO.ContaDAO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaRN {

    private ContaDAO contaDAO;

    public ContaRN() {
        this.contaDAO = new ContaDAO();
    }

    public void criarConta(ContaVO conta) {
        //TRATAMENTOS DE ERRO
        if (conta.getPedido() == null) {
            throw new IllegalArgumentException("Pedido associado à conta não pode ser nulo.");
        }
        if (conta.getValorTotal() == null || conta.getValorTotal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor total da conta deve ser maior que zero.");
        }

        if ("Pago".equals(conta.getStatus())) {
            conta.setDataPagamento(LocalDateTime.now());
        }

        contaDAO.inserir(conta);
    }

    public void aplicarDesconto(ContaVO conta, BigDecimal desconto) {
        if (desconto == null || desconto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Desconto deve ser um valor não negativo.");
        }

        BigDecimal valorTotal = conta.getValorTotal();
        BigDecimal novoValorTotal = valorTotal.subtract(desconto);

        if (novoValorTotal.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor total após o desconto não pode ser negativo.");
        }

        conta.setDesconto(desconto);
        conta.setValorTotal(novoValorTotal);

        contaDAO.atualizar(conta);
    }

    public void atualizarStatusConta(ContaVO conta, String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status da conta não pode ser vazio.");
        }

        conta.setStatus(status);

        if ("Pago".equals(status)) {
            conta.setDataPagamento(LocalDateTime.now());
        }

        contaDAO.atualizar(conta);
    }

    public ContaVO buscarContaPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da conta não pode ser nulo.");
        }

        return contaDAO.buscarPorId(id);
    }

    public void removerConta(ContaVO conta) {
        if (conta == null) {
            throw new IllegalArgumentException("Conta não pode ser nula.");
        }

        contaDAO.deletar(conta.getId());
    }
}