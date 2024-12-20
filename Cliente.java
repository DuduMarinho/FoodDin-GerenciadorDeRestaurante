import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Pedido> historicoPedidos;

    public Cliente(String nome, String telefone, String email, String documento) {
        super(nome, telefone, email, documento);
        this.historicoPedidos = new ArrayList<>();
    }

    public void realizarPedido(Mesa mesa) {
        //Criar a logica pra fazer o pedido
    }

    public void solicitarConta(Mesa mesa) {
        //Criar a logica pra pedir a conta
    }
    public List<Pedido> getHistoricoPedidos() { return historicoPedidos; }
}
