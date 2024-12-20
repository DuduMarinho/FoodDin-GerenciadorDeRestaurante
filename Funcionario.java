import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;
    private LocalDate dataAdmissao;

    public Funcionario(String nome, String telefone, String email, String documento, String matricula, String cargo, LocalDate dataAdmissao) {
        super(nome, telefone, email, documento);
        this.matricula = matricula;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
    }

    public void atenderMesa(Mesa mesa) {
        //Criar a lógica de atender a mesa
    }

    public void registrarPedido(Pedido pedido) {
        //Criar a lógica de registrar o pedido
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }
}
