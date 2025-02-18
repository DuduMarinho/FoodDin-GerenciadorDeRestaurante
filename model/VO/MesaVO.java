package model.VO;

public class MesaVO {
    private Integer id;
    private Integer numero;
    private Integer capacidade;
    private String status;
    private FuncionarioVO funcionario;

    public MesaVO() {}

    public MesaVO(Integer id, Integer numero, Integer capacidade, String status, FuncionarioVO funcionario) {
        this.id = id;
        this.numero = numero;
        this.capacidade = capacidade;
        this.status = status;
        this.funcionario = funcionario;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public FuncionarioVO getFuncionario() { return funcionario; }
    public void setFuncionario(FuncionarioVO funcionario) { this.funcionario = funcionario; }
}

