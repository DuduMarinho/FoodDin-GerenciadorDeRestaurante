package model.RN;

import model.VO.FuncionarioVO;
import model.DAO.FuncionarioDAO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FuncionarioRN {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioRN() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public void contratarFuncionario(FuncionarioVO funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionario nao pode ser nulo ou vazio.");
        }
        if (funcionario.getCargo() == null || funcionario.getCargo().isEmpty()) {
            throw new IllegalArgumentException("Cargo do funcionario nao pode ser nulo ou vazio.");
        }
        if (funcionario.getSalario() == null || funcionario.getSalario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salario do funcionario nao pode ser nulo ou menor ou igual a zero.");
        }

        //Data de contrataçao
        funcionario.setDataContratacao(LocalDateTime.now());

        funcionarioDAO.inserir(funcionario);
    }

    public FuncionarioVO buscarFuncionarioPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID do funcionario nao pode ser nulo.");
        }

        return funcionarioDAO.buscarPorId(id);
    }

    public void demitirFuncionario(FuncionarioVO funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionario nao pode ser nulo.");
        }
        funcionarioDAO.deletar(funcionario.getId());
    }

}
