package model.VO;

import java.math.BigDecimal;

public class ItemPedidoVO {
    private Integer id;
    private ItemCardapioVO itemCardapio;
    private Integer quantidade;
    private String observacoes;
    private BigDecimal precoUnitario;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public ItemCardapioVO getItemCardapio() { return itemCardapio; }
    public void setItemCardapio(ItemCardapioVO itemCardapio) { this.itemCardapio = itemCardapio; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(BigDecimal precoUnitario) { this.precoUnitario = precoUnitario; }
}
