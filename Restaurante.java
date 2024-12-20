import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas;
    private List<Funcionario> funcionarios;
    private Cardapio cardapio;
    private List<Pedido> pedidos;
    private List<Cliente> clientes;

    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.cardapio = new Cardapio();
        this.pedidos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void gerarRelatorioVendas(String dataInicio, String dataFim) {
    }

    public Mesa buscarMesaDisponivel() {
        for (Mesa mesa : mesas) {
            if (mesa.getStatus().equalsIgnoreCase("disponível")) {
                return mesa;
            }
        }
        return null;
    }

    public List<Mesa> getMesas() { return mesas; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public Cardapio getCardapio() { return cardapio; }
    public List<Pedido> getPedidos() { return pedidos; }
    public List<Cliente> getClientes() { return clientes; }
}
