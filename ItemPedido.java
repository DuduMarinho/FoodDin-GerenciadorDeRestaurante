public class ItemPedido {
  private ItemCardapio itemCardapio;
  private int quantidade;
  private String observacao;

  public ItemPedido(ItemCardapio itemCardapio, int quantidade, String observacao) {
      this.itemCardapio = itemCardapio;
      this.quantidade = quantidade;
      this.observacao = observacao;
  }
  public void calcularSubtotal() {
      //Criar um método que calcula o subtotal do item pedido
  }

  public ItemCardapio getItemCardapio() { return itemCardapio; }
  public void setItemCardapio(ItemCardapio itemCardapio) { this.itemCardapio = itemCardapio; }
  public int getQuantidade() { return quantidade; }
  public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
  public String getObservacao() { return observacao; }
  public void setObservacao(String observacao) { this.observacao = observacao; }
}
