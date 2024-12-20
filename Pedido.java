import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDateTime data;
    private String status;
    private List<ItemPedido> items;
    private Mesa mesa;

    public Pedido(int numero, LocalDateTime data, String status, Mesa mesa) {
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.items = new ArrayList<>();
        this.mesa = mesa;
    }

    public void adicionarItem(ItemCardapio itemCardapio, int quantidade) {
        //Criar logica de adicionar item
    }
    public void removerItem(ItemPedido itemPedido) {
        //Criar logica de remover item
    }
    public double calcularTotal() {
            return numero;
        //Criar logica de calcular total
    }
    public void finalizarPedido() {
        //Criar logica de finalizar pedido
    }
    public void cancelarPedido() {
        //Criar logica de cancelar pedido
    }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<ItemPedido> getItems() { return items; }
    public Mesa getMesa() { return mesa; }
    public void setMesa(Mesa mesa) { this.mesa = mesa; }
}
//Joao eu vou te matar