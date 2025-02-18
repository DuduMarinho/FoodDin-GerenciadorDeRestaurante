package model.VO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FuncionarioVO extends PessoaVO {
    private String cargo;
    private BigDecimal salario;
    private LocalDateTime dataContratacao;
    private String turno;

    public FuncionarioVO(Integer id, String nome, String cpf, String telefone, String email,
                         String endereco, String cargo, BigDecimal salario,
                         LocalDateTime dataContratacao, String turno) {
        super(id, nome, cpf, telefone, email, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.turno = turno;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }

    public LocalDateTime getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDateTime dataContratacao) { this.dataContratacao = dataContratacao; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
}
