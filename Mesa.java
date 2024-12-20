import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private String status;
    private List<Pedido> pedidosAtivos;

    public Mesa(int numero, String status) {
        this.numero = numero;
        this.status = status;
        this.pedidosAtivos = new ArrayList<>();
    }

  
    public void reservarMesa(Cliente cliente) {
        //Criar a logica de reservar a mesa
    }
    public void ocuparMesa(Cliente cliente) {
        //Criar a logica de ocupar a mesa
  }
    public void liberarMesa() {
        //Criar a logica de liberar a mesa
    }
    public void associarGarcom(Funcionario funcionario) {
        //Implementar a associação de um garçom pra uma mesa
        }
    public void calcularConta() {
        //Criar a logica pra calcular a conta
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Pedido> getPedidosAtivos() { return pedidosAtivos; }
}

// Esse é o código que mais falta coisa pra fazer, mas é o que tem mais a ver com o que a gente já fez até agr