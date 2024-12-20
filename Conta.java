import java.time.LocalDateTime;

public class Conta {
    private int numero;
    private LocalDateTime data;
    private Pedido pedido;
    private double valorTotal;
    private String statusPagamento;

    public Conta(int numero, LocalDateTime data, Pedido pedido, double valorTotal, String statusPagamento) {
        this.numero = numero;
        this.data = data;
        this.pedido = pedido;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }

    public void calcularTotal() {
        this.valorTotal = pedido.calcularTotal();
    }
    public void gerarRecibo() {
        //Criar logica de geracao de recibo
    }
    public void registrarPagamento() {
        this.statusPagamento = "Pago";
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }
    public String getStatusPagamento() { return statusPagamento; }
    public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }
}
